package com.qunar.job.queue;

import com.qunar.job.Job;

/**
 * Created BY wangwenxiang on 2016/11/15.
 */
public interface JobProducerQueue {
    /**
     * add a job to queue if not full
     *
     * @param job to queue
     */
    void put(Job job) throws InterruptedException;
}
