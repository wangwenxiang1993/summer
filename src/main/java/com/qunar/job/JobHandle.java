package com.qunar.job;

import com.qunar.actuator.Actuator;
import com.qunar.job.producer.Producer;
import com.qunar.job.queue.BlockingJobQueue;
import com.qunar.job.queue.LinkedBlockingJobQueue;

import javax.annotation.PostConstruct;

/**
 * Created BY wangwenxiang on 2016/11/15.
 */
public class JobHandle {

    /**
     * the queue to store job
     */
    private BlockingJobQueue queue;

    public <T> Producer<T> newProducer(Actuator<T> actuator) {
        return new Producer<T>(actuator, queue);
    }

    @PostConstruct
    public void init(){
        initQueue();
    }

    /**
     * init queue
     */
    private void initQueue(){
        if (queue == null){
            queue = new LinkedBlockingJobQueue();
            queue.init();
        }
    }
}
