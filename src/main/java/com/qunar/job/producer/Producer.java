package com.qunar.job.producer;

import com.qunar.actuator.Actuator;
import com.qunar.exceptions.AddJobException;
import com.qunar.job.Job;
import com.qunar.job.queue.BlockingJobQueue;
import com.qunar.job.queue.JobProducerQueue;
import com.qunar.util.Precondition;

/**
 * Created BY wangwenxiang on 2016/11/15.
 */
public class Producer<T> {

    private JobProducerQueue queue;

    private Actuator<T> actuator;

    /**
     * init producer
     */
    public Producer(Actuator<T> actuator, JobProducerQueue queue) {
        Precondition.checkAllNotNull(actuator, queue);
        this.actuator = actuator;
        this.queue = queue;
    }

    /**
     * add job to queue with job params and actuator
     */
    public void addJob(T t) throws AddJobException {
        Job<T> job = new Job<T>(actuator, t);
        try {
            queue.put(job);
        } catch (InterruptedException e) {
            throw new AddJobException(e);
        }
    }
}
