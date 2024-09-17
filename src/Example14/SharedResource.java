package Example14;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    boolean isAvailable = false;
    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void producer(){
        try {
            lock.lock();
            System.out.println("Producer lock acquired by : " + Thread.currentThread().getName());
            if(isAvailable){
                System.out.println("Producer thread is waiting : " + Thread.currentThread().getName());
                condition.await();
            }
            isAvailable = true;
            condition.signalAll();
        }catch (Exception e){

        }finally {
            lock.unlock();
            System.out.println("Producer lock release by " + Thread.currentThread().getName());
        }
    }

    public void consumer(){
        try {
            Thread.sleep(1000);
            lock.lock();
            System.out.println("Consume lock acquired by : " + Thread.currentThread().getName());
            if(!isAvailable){
                System.out.println("Consumer thread is waiting : " + Thread.currentThread().getName());
                condition.await();
            }
            isAvailable = false;
            condition.signal();
        }catch (Exception e){

        }finally {
            lock.unlock();
            System.out.println("Consumer lock release by " + Thread.currentThread().getName());
        }
    }
}
