package com.qunar.job.consumer;

import com.qunar.job.Job;
import com.qunar.job.queue.JobConsumerQueue;

/**
 * Created BY wangwenxiang on 2016/11/18.
 */
public class Consumer implements Runnable{
    private JobConsumerQueue consumerQueue;

    public Consumer(JobConsumerQueue consumerQueue) {
        this.consumerQueue = consumerQueue;
    }

    public void run() {
        while (true){
            try {
                Job take = consumerQueue.take();
                System.out.println("获取任务："+take.getT());
                new Thread(new WorkerThread(take)).start();
            } catch (InterruptedException ignored) {
            }
        }
    }
}
