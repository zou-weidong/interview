package threadpool;


import java.util.concurrent.*;

/**
 * 针对jdk的线程池做一个测试
 */
public class PoolTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        ScheduledExecutorService scheduledExecutorService1 = Executors.newSingleThreadScheduledExecutor();

        executorService2.submit(new MyThread());

        Future<Integer> task_interrupted = executorService2.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                return 123;
            } catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        });
        System.out.println(task_interrupted.isDone());
        System.out.println(task_interrupted.get());
        executorService2.shutdown();//线程不会停止，执行者必须明确停止，除非想继续监听


    }


    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
