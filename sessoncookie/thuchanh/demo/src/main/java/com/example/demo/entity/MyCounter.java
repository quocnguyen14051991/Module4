package com.example.demo.entity;

public class MyCounter {
    private Integer count=0;

    public MyCounter() {
    }

    public MyCounter(Integer count) {
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
    public Integer increment(){
        return  count++;
    }
}
