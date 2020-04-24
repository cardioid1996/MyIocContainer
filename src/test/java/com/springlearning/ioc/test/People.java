package com.springlearning.ioc.test;

public class People {

    private String name;

    private int id;

    public People(String name, int id){
        this.name = name;
        this.id = id;
    }

    public void speak(){
        System.out.println("我的名字是" + name + "， 编号是" + id);
    }

}
