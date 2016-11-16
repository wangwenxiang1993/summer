package com.qunar.job.queue;

import com.qunar.job.Job;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created BY wangwenxiang on 2016/11/15.
 */
public abstract class BlockingJobQueue<T> implements JobProducerQueue<T>, JobConsumerQueue<T> {

    private final BlockingQueue<Job<T>> blockingQueue;

    private BlockingJobQueue(BlockingQueue<Job<T>> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void put(Job<T> job) throws InterruptedException {
        blockingQueue.put(job);
    }

    public Job<T> take() throws InterruptedException {
        return blockingQueue.take();
    }

    public final class LinkedBlockingJobQueue<L> extends BlockingJobQueue<L> {

        public LinkedBlockingJobQueue() {
            super(new LinkedBlockingQueue<Job<L>>());
        }
    }

    public final class ArrayBlockingJobQueue<L> extends BlockingJobQueue<L> {

        public ArrayBlockingJobQueue() {
            super(new ArrayBlockingQueue<Job<L>>(1));
        }

    }
}
