package com.qunar.exceptions;

/**
 * Created BY wangwenxiang on 2016/11/15.
 */
public class AddJobException extends Exception{
    public AddJobException(Exception e){
        super("add job error", e);
    }
}
