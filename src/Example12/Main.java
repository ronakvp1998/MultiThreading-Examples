package Example12;

public class Main {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread th1 = new Thread(() -> resource.producer());
        Thread th2 = new Thread(() -> resource.consume());

        th1.start();
        th2.start();
    }
}
