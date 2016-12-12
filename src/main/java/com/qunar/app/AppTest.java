package com.qunar.app;

import com.qunar.actuator.Actuator;
import com.qunar.exceptions.AddJobException;
import com.qunar.job.JobHandle;
import com.qunar.job.producer.Producer;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created BY wangwenxiang on 2016/11/15.
 */
public class AppTest {

    private static LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>(1);

//    public static void main(String[] args) {
//        Runnable[] runnable = new Runnable[10];
//        for (int i = 0; i < 10; i++) {
//            runnable[i] = new Producer(queue, i);
//        }
//        for (Runnable r : runnable) {
//            new Thread(r).start();
//        }
//        new Thread(new Consumer(queue)).start();
//    }

    public static void main(String[] args) {
        JobHandle jobHandle = new JobHandle();
        jobHandle.init();
        Producer<String> stringProducer = jobHandle.newProducer(new Actuator<String>() {
            public void actuate(String s) {
                Thread thread = Thread.currentThread();
                try {
                    thread.sleep(10000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("执行任务"+s);
            }
        });
        for (int i=1;i<10;i++){
            try {
                stringProducer.addJob(i+"");
                System.out.println("添加任务"+i);
            }catch (AddJobException e){
                e.printStackTrace();
            }

        }
    }
}
