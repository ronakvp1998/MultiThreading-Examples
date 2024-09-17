package Example19;

import java.util.concurrent.*;
public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,4,10, TimeUnit.MINUTES
        , new ArrayBlockingQueue<>(2), new CustomThreadFactory(), new CustomRejectHandler());

        // when treads are not performing any task based in KeepaliveTime it will get deleted
        executor.allowCoreThreadTimeOut(true);

        for(int i=1;i <= 8;i++){  // 4 task created and submitted to executor
            executor.submit(() -> {
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {

                }
                System.out.println("Task processed by " + Thread.currentThread().getName());
            });
        }
        executor.shutdown();
    }
}

// we can use default ThreadPoolExecutor.DiscardOldestPolicy() etc
class CustomRejectHandler implements RejectedExecutionHandler{
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task rejected: " + r.toString());
    }
}

// we can use default thread factory (Executors.defaultThreadFactory())
class CustomThreadFactory implements ThreadFactory{
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        // normal priority
        thread.setPriority(Thread.NORM_PRIORITY);
        // non daemon
        thread.setDaemon(false);
        return thread;
    }
}