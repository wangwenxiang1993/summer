package com.qunar.job;

import com.qunar.actuator.Actuator;
import com.qunar.job.producer.Producer;
import com.qunar.job.queue.BlockingJobQueue;
import com.qunar.job.queue.LinkedBlockingJobQueue;

/**
 * Created BY wangwenxiang on 2016/11/15.
 */
public class JobHandle<T> {

    /**
     * the queue to store job
     */
    private BlockingJobQueue<T> queue = new LinkedBlockingJobQueue<T>();

    public Producer<T> newProducer(Actuator<T> actuator) {
        return new Producer<T>(actuator, queue);
    }

}
