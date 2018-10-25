package threads;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableExampleTest {


    public static final String MESSAGE = "MENSAJE DE UN RUNNABLE";

    @Test
    public void test1() throws InterruptedException {
        Thread runnable = new Thread(new RunnableExample(MESSAGE));
        runnable.start();
        runnable.join();
    }


    @Test
    public void testExecutorService() {
        ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        threadPool.submit(new RunnableExample(MESSAGE));
        threadPool.submit(new RunnableExample(MESSAGE));
        threadPool.submit(new RunnableExample(MESSAGE));
        threadPool.submit(new RunnableExample(MESSAGE));
        threadPool.submit(new RunnableExample(MESSAGE));
        threadPool.submit(new RunnableExample(MESSAGE));
        threadPool.submit(new RunnableExample(MESSAGE));
        threadPool.submit(new RunnableExample(MESSAGE));
        threadPool.submit(new RunnableExample(MESSAGE));
        threadPool.submit(new RunnableExample(MESSAGE));
        threadPool.submit(new RunnableExample(MESSAGE));
        threadPool.submit(new RunnableExample(MESSAGE));
        threadPool.submit(new RunnableExample(MESSAGE));
        threadPool.submit(new RunnableExample(MESSAGE));
        threadPool.submit(new RunnableExample(MESSAGE));
        threadPool.submit(new RunnableExample(MESSAGE));
        threadPool.shutdown();
    }

    @Test
    public void testWithlamdas() {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        executorService.submit(()-> System.out.println(MESSAGE));
        executorService.submit(()-> System.out.println(MESSAGE));
        executorService.submit(()-> System.out.println(MESSAGE));
        executorService.submit(()-> System.out.println(MESSAGE));
        executorService.submit(()-> System.out.println(MESSAGE));
        executorService.submit(()-> System.out.println(MESSAGE));
        executorService.submit(()-> System.out.println(MESSAGE));
        executorService.submit(()-> System.out.println(MESSAGE));
        executorService.submit(()-> System.out.println(MESSAGE));
        executorService.submit(()-> System.out.println(MESSAGE));
        executorService.submit(()-> System.out.println(MESSAGE));
        executorService.submit(()-> System.out.println(MESSAGE));
        executorService.submit(()-> System.out.println(MESSAGE));
        executorService.submit(()-> System.out.println(MESSAGE));
        executorService.submit(()-> System.out.println(MESSAGE));
        executorService.submit(()-> System.out.println(MESSAGE));
        executorService.submit(()-> System.out.println(MESSAGE));
        executorService.submit(()-> System.out.println(MESSAGE));
        executorService.submit(()-> System.out.println(MESSAGE));
        executorService.submit(()-> System.out.println(MESSAGE));
        executorService.submit(()-> System.out.println(MESSAGE));
        executorService.submit(()-> System.out.println(MESSAGE));
        executorService.submit(()-> System.out.println(MESSAGE));
        executorService.submit(()-> System.out.println(MESSAGE));
        executorService.shutdown();
    }
}
