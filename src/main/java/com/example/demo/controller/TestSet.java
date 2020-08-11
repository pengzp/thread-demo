package com.example.demo.controller;

import java.util.HashSet;
import java.util.UUID;

/**
 * @program: thread-demo
 * @description:
 * @author: Mr.peng
 * @create: 2020-08-11 20:48
 **/

public class TestSet {

    public static void main(String[] args) {

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i <= 50; i++) {
            /*new Thread(){
                public void run(){
                    set.add(UUID.randomUUID().toString().substring(0,5));
                    System.out.println(set);
                }
            }.start();*/

            new Thread(new Runnable() {
                @Override
                public void run() {
                    set.add(UUID.randomUUID().toString().substring(0,6));
                    System.out.println(set);
                }
            },String.valueOf(i)).start();
        }
    }
}
