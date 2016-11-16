package com.qunar.app;

import java.util.concurrent.BlockingQueue;

/**
 * Created BY wangwenxiang on 2016/11/15.
 */
public class Producer implements Runnable {

    private final BlockingQueue<Integer> blockingQueue;
    private int i;

    public Producer(BlockingQueue<Integer> blockingQueue, int i) {
        this.blockingQueue = blockingQueue;
        this.i = i;
    }

    public void run() {
        while (true) {
            try {
                blockingQueue.put(i);
                System.out.println("生产了：" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
