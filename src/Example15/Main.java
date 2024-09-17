package Example15;

public class Main {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        for(int i=0;i<400;i++){
            resource.increment();
        }
        System.out.println(resource.get());
    }
}
