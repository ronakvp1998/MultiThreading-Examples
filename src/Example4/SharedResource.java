package Example4;

public class SharedResource {

    boolean isAvailable = false;

    public synchronized void produce(){
        System.out.println("Lock acquired");
        isAvailable = true;
        try{
            Thread.sleep(8000);
        }catch (Exception e){

        }
        System.out.println("Lock release");
    }
}
