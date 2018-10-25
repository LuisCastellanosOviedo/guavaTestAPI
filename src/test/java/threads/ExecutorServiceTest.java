package threads;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class ExecutorServiceTest {


    @Test
    public void testWithlambdas() {


        Runnable runnmableLabda = () -> {
          try {
              TimeUnit.MILLISECONDS.sleep(300);
          }catch (InterruptedException e){

          }
        };
    }
}
