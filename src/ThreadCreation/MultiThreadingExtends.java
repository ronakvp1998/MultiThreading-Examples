package ThreadCreation;

public class MultiThreadingExtends extends Thread{

    @Override
    public void run(){
        System.out.println("code executed by thread : "
        + Thread.currentThread().getName());
    }
}
