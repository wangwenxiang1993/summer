package com.qunar.job.queue;

import com.qunar.job.Job;

/**
 * Created BY wangwenxiang on 2016/11/15.
 */
public interface JobConsumerQueue<T> {

    /**
     * get a job from queue if have one
     *
     * @return job from queue
     */
    Job<T> take() throws InterruptedException;
}
