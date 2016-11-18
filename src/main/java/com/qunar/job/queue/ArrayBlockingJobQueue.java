package com.qunar.job.queue;

import com.qunar.job.Job;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created BY wangwenxiang on 2016/11/18.
 */
public class ArrayBlockingJobQueue<T> extends BlockingJobQueue<T> {
    public void init() {
        blockingQueue = new ArrayBlockingQueue<Job<T>>(getCapacity());
    }
}
