package com.department.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by deng on 19-5-10.
 * <p>
 * kafka源码中BufferPool中分配Buffer用了ReentrantLock和它的Condition，很有意思。
 */
public class Condition {


    public static void main(String[] args) throws InterruptedException {
//        KafkaProducer producer;
//        HashMap<String, String> map = new HashMap<String, String>();
//
//        map.put("A", "b");
        final ReentrantLock lock = new ReentrantLock();
        lock.lock();
        final java.util.concurrent.locks.Condition condition = lock.newCondition();
        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    lock.lock();
                    System.out.println("sleep start");
                    Thread.sleep(300);
                    condition.signalAll();
                    System.out.println("sleep end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        thread.start();
        System.out.println("main await start");
        boolean result = condition.await(1000, TimeUnit.MILLISECONDS);

        System.out.println("wait result:" + result);
        System.out.println("i am wake");
        lock.unlock();
    }
}
