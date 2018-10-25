package threads;

public class ThreadExample extends Thread {

    private String message;

    public ThreadExample(String message) {
        this.message = message;
    }

    public void run(){
        System.out.println(message);
    }

}
