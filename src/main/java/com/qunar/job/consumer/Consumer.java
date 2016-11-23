package com.qunar.job.consumer;

import com.qunar.job.queue.BlockingJobQueue;
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

    }
}
