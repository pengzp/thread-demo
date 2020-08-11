package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @program: thread-demo
 * @description:
 * @author: Mr.peng
 * @create: 2020-08-11 20:42
 **/

public class TestCollections {

    public static void main(String[] args) {

        List<Integer> list = Collections.synchronizedList(new ArrayList<>());

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
        },"B").start();
    }
}
