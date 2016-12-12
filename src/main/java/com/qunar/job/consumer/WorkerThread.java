package com.qunar.job.consumer;

import com.qunar.job.Job;

/**
 * Created BY wangwenxiang on 2016/11/22.
 */
public class WorkerThread implements Runnable{

    private Job job;

    WorkerThread(Job job){
        this.job = job;
    }

    public void run() {
        if (job == null){
            throw new NullPointerException();
        }
        job.exeCute();
    }
}
