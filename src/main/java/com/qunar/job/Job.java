package com.qunar.job;

import com.qunar.actuator.Actuator;

/**
 * Created BY wangwenxiang on 2016/11/14.
 * job
 */
public class Job<T> {
    /**
     * execute job
     */
    private Actuator<T> actuator;

    /**
     * job params
     */
    private T t;

    public Job(Actuator<T> actuator, T t) {
        this.actuator = actuator;
        this.t = t;
    }

    public Actuator<T> getActuator() {
        return actuator;
    }

    public void setActuator(Actuator<T> actuator) {
        this.actuator = actuator;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public void exeCute(){
        actuator.actuate(t);
    }
}
