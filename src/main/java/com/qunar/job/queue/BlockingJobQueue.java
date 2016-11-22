package com.qunar.job.queue;

import com.qunar.job.Job;

import javax.annotation.PostConstruct;
import java.util.concurrent.BlockingQueue;

/**
 * Created BY wangwenxiang on 2016/11/15.
 */
public abstract class BlockingJobQueue extends QueueBuilder implements JobProducerQueue, JobConsumerQueue {

    protected BlockingQueue<Job> blockingQueue;

    public void put(Job job) throws InterruptedException {
        blockingQueue.put(job);
    }

    public Job take() throws InterruptedException {
        return blockingQueue.take();
    }

    @PostConstruct
    public abstract void init();
}
