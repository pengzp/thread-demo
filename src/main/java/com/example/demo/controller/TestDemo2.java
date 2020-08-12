package com.example.demo.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: 彭志鹏
 * @DateTime: 2020/7/31 15:31
 * @Description:
 */
public class TestDemo2 {

    public static void main(String[] args) {

        List list = new CopyOnWriteArrayList();
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
                        //list.remove(integer);
                        list.add(5);
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        },"B").start();
    }
}
