package com.example.demo.controller;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: 彭志鹏
 * @DateTime: 2020/8/11 17:01
 * @Description:
 */
public class TestVector {

    public static void main(String[] args) {

        /*List list = new Vector();
        //混淆了同步修改异常和线程安全
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);


        new Thread(new Runnable() {
            @Override
            public void run() {
                Iterator<Integer> iterator = list.iterator();
                while (iterator.hasNext()){
                    Integer integer = iterator.next();
                    System.out.println("当前值:"+integer);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Iterator<Integer> iterator = list.iterator();
                while (iterator.hasNext()){
                    Integer integer = iterator.next();
                    if (integer == 2){
                        //iterator.remove();
                        list.remove(integer);
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        },"B").start();*/

        /*//火车票列表
        final List<String> tickets = new Vector<>();
        //初始化票据池
        for(int i=0;i<1000;i++){
            tickets.add("火车票" + i);
        }
        //10个窗口售票
        for(int i=0;i<10;i++){
            *//*new Thread(){
                @Override
                public void run() {
                    while(true){
                        System.out.println(Thread.currentThread().getName() +"——"+ tickets.remove(0));
                    }
                };
            }.start();*//*
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true){
                        System.out.println(Thread.currentThread().getName() +"——"+ tickets.remove(0));
                    }
                }
            },String.valueOf(i)).start();
        }*/

        TestVector tt = new TestVector();
        tt.train();
    }

    /**
     * 基本上所有的集合类都有一个叫做快速失败（Fail-Fast)的校验机制，当一个集合在被多个线程修改并访问时，
     * 就可能会出现 ConcurrentModificationException异常，
     * 这是为了确保集合方法一致而设置的保护措施
     *
     * 这与线程同 步是两码事，线程同步是为了保护集合中的数据不被脏读、脏写而设置的，我们来看线程安 全到底用在什么地方
     */

    public void train(){
        //火车票列表
        final List<String> tickets = Collections.synchronizedList(new ArrayList<>());
        //初始化票据池
        for(int i=0;i<1000;i++){
            tickets.add("火车票" + i);
        }
        Lock lock = new ReentrantLock();

        //10个窗口售票
         for(int i=0;i<5;i++){
             new Thread(){
                    @Override
                    public void run() {
                        lock.lock();
                        boolean a = tickets.size()>0;
                        while(a){
                            if(tickets.size()<=0){
                                lock.unlock();
                                break;
                            }
                            System.out.println(tickets.size());
                            System.out.println(Thread.currentThread().getName() +"——"+ tickets.remove(0));
                         }
                    };
            }.start();

         }

    }
}
