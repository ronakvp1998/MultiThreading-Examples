package Example1;

public class MonitorLockExample {
    public synchronized void task1(){
        try{
            System.out.println("Inside task1");
            Thread.sleep(10000);
        }catch (Exception e){

        }
    }

    public synchronized void task2(){
        System.out.println("Inside task2 but before synchronized");
        synchronized (this){
            System.out.println("Task2 ,inside synchronized");
        }
    }

    public synchronized void task3(){
        System.out.println("task 3");
    }

    public static void main(String[] args) {
        MonitorLockExample obj = new MonitorLockExample();

        Thread t1 = new Thread(() -> obj.task1());
        Thread t2 = new Thread(() -> obj.task2());
        Thread t3 = new Thread(() -> obj.task3());

        t1.start();
        t2.start();
        t3.start();

    }
}
