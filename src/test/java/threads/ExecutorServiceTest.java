package threads;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceTest {


    public static final String TASK_CALLABLE = "TASK CALLABLE";

    @Test
    public void testWithlambdas() {

        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        Runnable runnmableLabda = () -> {
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        };

        executorService.execute(runnmableLabda);
        executorService.execute(runnmableLabda);
        executorService.execute(runnmableLabda);
        executorService.execute(runnmableLabda);
        executorService.execute(runnmableLabda);
        executorService.execute(runnmableLabda);
        executorService.shutdown();
    }


    @Test
    public void testSubmitAndFuture() throws ExecutionException, InterruptedException {
        Callable<String> callableItem = () -> {
            TimeUnit.MILLISECONDS.sleep(20);
            return TASK_CALLABLE;
        };

        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        Future<String> future =  executorService.submit(callableItem);
        executorService.shutdown();
        System.out.println(future.get());

    }

    @Test
    public void testCallableInvokeAny() throws ExecutionException, InterruptedException {
        Callable<String> callableTask = () -> {
            TimeUnit.MILLISECONDS.sleep(300);
            return TASK_CALLABLE;
        };

        List<Callable<String>> callableTasks = new ArrayList<>();
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);

        ExecutorService executorService  = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        /**
         * invokeAny() assigns a collection of tasks to an ExecutorService, causing each to be executed,
         * and returns the result of a successful execution of one task (if there was a successful execution).
         */
        String res =   executorService.invokeAny(callableTasks);
        System.out.println(res);
        executorService.shutdown();

    }


    @Test
    public void testInvokeAll() throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        Callable<String> callabletask = () -> {
            return TASK_CALLABLE;
        };


        List<Callable<String>> callableTasks = new ArrayList<>();

        callableTasks.add(callabletask);
        callableTasks.add(callabletask);
        callableTasks.add(callabletask);
        callableTasks.add(callabletask);
        callableTasks.add(callabletask);
        callableTasks.add(callabletask);
        callableTasks.add(callabletask);
        callableTasks.add(callabletask);
        callableTasks.add(callabletask);
        callableTasks.add(callabletask);
        callableTasks.add(callabletask);
        callableTasks.add(callabletask);

        List<Future<String>> futures = executorService.invokeAll(callableTasks);




        try{
            if(! executorService.awaitTermination(800, TimeUnit.MILLISECONDS)){
                executorService.shutdownNow();
            }
        }catch (InterruptedException e){
            executorService.shutdownNow();
        }


        futures.stream().forEach(x -> {
            try {
                System.out.println(x.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
    }
}
