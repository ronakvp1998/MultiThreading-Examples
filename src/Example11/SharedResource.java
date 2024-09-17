package Example11;

import java.util.concurrent.locks.StampedLock;

public class SharedResource {
    boolean isAvailable = false;
    StampedLock lock = new StampedLock();

    public void producer(){
        long stamp = lock.readLock();
        try {
            System.out.println("Read lock acquired by : " + Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(3000);
        }catch (Exception e){

        }finally {
            lock.unlockRead(stamp);
            System.out.println("Read lock release by : " + Thread.currentThread().getName());
        }
    }

    public void consume(){
        long stamp = lock.writeLock();
        try{
            System.out.println("Write lock acquired by : " + Thread.currentThread().getName());
            isAvailable = false;
            Thread.sleep(1000);
        }catch (Exception e){

        }finally {
            lock.unlockWrite(stamp);
            System.out.println("Write lock release by : " + Thread.currentThread().getName());
        }
    }
}
