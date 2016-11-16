package com.qunar.app;

import java.util.concurrent.BlockingQueue;

/**
 * Created BY wangwenxiang on 2016/11/15.
 */
public class Consumer implements Runnable {

    private BlockingQueue<Integer> blockingQueue;

    public Consumer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void run() {
        while (true) {
            try {
                System.out.println("消费了：" + blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
