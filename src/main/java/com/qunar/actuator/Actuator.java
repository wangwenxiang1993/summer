package com.qunar.actuator;

/**
 * Created BY wangwenxiang on 16/5/23.
 * 执行器
 */
public interface Actuator<T> {

    /**
     * 执行过程
     *
     * @param t 任务
     */
    void actuate(T t);
}
