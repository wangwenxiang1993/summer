package com.qunar.job.queue;

/**
 * Created BY wangwenxiang on 2016/11/18.
 */
public class QueueBuilder {
    private int capacity = Integer.MAX_VALUE;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException();
        this.capacity = capacity;
    }
}
