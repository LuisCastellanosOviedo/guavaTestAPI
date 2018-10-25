package threads;

public class RunnableExample implements Runnable {

    private String message;

    public RunnableExample(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println(message);
    }
}
