package com.qunar.job;

import com.qunar.actuator.Actuator;
import com.qunar.job.consumer.Consumer;
import com.qunar.job.producer.Producer;
import com.qunar.job.queue.BlockingJobQueue;
import com.qunar.job.queue.LinkedBlockingJobQueue;

import javax.annotation.PostConstruct;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created BY wangwenxiang on 2016/11/15.
 */
public class JobHandle {

    /**
     * the queue to store job
     */
    private BlockingJobQueue queue;

    /**
     * 通过执行器新建一个生产者
     * 通过生产者的addJob(T t) 添加执行参数，往队列中添加一个任务
     */
    public <T> Producer<T> newProducer(Actuator<T> actuator) {
        return new Producer<T>(actuator, queue);
    }

    @PostConstruct
    public void init(){
        initQueue();
        initConsumer();
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
    private void initConsumer(){
        Consumer consumer = new Consumer(queue);
        new Thread(consumer).start();
    }
}
