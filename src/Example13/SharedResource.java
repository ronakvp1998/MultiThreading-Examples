package Example13;

import java.util.concurrent.Semaphore;

public class SharedResource {
    boolean isAvailable = false;
    Semaphore lock = new Semaphore(2);

    public void producer(){
        try{
            lock.acquire();
            System.out.println("Lock acuired by : " + Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(4000);
        }catch (Exception e){

        }finally {
            lock.release();
            System.out.println("lock release by : " + Thread.currentThread().getName());
        }
    }
}
