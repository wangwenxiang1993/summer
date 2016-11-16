package com.qunar.app;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created BY wangwenxiang on 2016/11/15.
 */
public class AppTest {

    private static LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>(1);

    public static void main(String[] args) {
        Runnable[] runnable = new Runnable[10];
        for (int i = 0; i < 10; i++) {
            runnable[i] = new Producer(queue, i);
        }
        for (Runnable r : runnable) {
            new Thread(r).start();
        }
        new Thread(new Consumer(queue)).start();
    }
}
