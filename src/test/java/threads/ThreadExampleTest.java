    package threads;

    import org.junit.Test;

    import java.util.concurrent.ExecutorService;
    import java.util.concurrent.Executors;

    public class ThreadExampleTest {


        @Test
        public void test1() throws InterruptedException {
            Thread threadExample = new ThreadExample("MENSAJE DEL THREAD EXTENDS");

            threadExample.start();
            threadExample.join();
        }

        @Test
        public void testUsingExecutor() {
            Thread threadExample = new ThreadExample("MENSAJE DEL THREAD EXTENDS");
            ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
            executorService.submit(threadExample);
            executorService.submit(threadExample);
            executorService.submit(threadExample);
            executorService.submit(threadExample);
            executorService.submit(threadExample);
            executorService.submit(threadExample);
            executorService.submit(threadExample);
            executorService.submit(threadExample);
            executorService.submit(threadExample);
            executorService.submit(threadExample);
            executorService.submit(threadExample);
            executorService.submit(threadExample);
            executorService.submit(threadExample);
            executorService.submit(threadExample);
            executorService.submit(threadExample);
            executorService.submit(threadExample);
            executorService.submit(threadExample);
            executorService.submit(threadExample);
            executorService.submit(threadExample);
            executorService.submit(threadExample);
            executorService.submit(threadExample);
            executorService.submit(threadExample);
            executorService.submit(threadExample);
            executorService.submit(threadExample);

            executorService.shutdown();
        }



    }
