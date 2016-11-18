package com.qunar.job.queue;

import com.qunar.job.Job;

import javax.annotation.PostConstruct;
import java.util.concurrent.BlockingQueue;

/**
 * Created BY wangwenxiang on 2016/11/15.
 */
public abstract class BlockingJobQueue<T> extends QueueBuilder implements JobProducerQueue<T>, JobConsumerQueue<T> {

    protected BlockingQueue<Job<T>> blockingQueue;

    public void put(Job<T> job) throws InterruptedException {
        blockingQueue.put(job);
    }

    public Job<T> take() throws InterruptedException {
        return blockingQueue.take();
    }

    @PostConstruct
    public abstract void init();
}
