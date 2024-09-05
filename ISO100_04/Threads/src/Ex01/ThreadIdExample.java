package Ex01;

public class ThreadIdExample {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread ID: " + Thread.currentThread().threadId());
                }
            });
            thread.start();
        }
    }
}