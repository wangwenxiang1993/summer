package com.qunar.job.queue;

import com.qunar.job.Job;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created BY wangwenxiang on 2016/11/18.
 */
public class LinkedBlockingJobQueue<T> extends BlockingJobQueue<T> {
    public void init() {
        blockingQueue = new LinkedBlockingQueue<Job<T>>(getCapacity());
    }
}
