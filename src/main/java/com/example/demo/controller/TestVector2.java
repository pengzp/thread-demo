package com.example.demo.controller;

import java.util.List;
import java.util.UUID;
import java.util.Vector;

/**
 * @Author: 彭志鹏
 * @DateTime: 2020/8/12 9:42
 * @Description:
 */
public class TestVector2 extends Thread {

    public static void main(String[] args) throws InterruptedException {

        List<String> list = new Vector<>();

        for (int i = 0; i < 30; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    list.add(UUID.randomUUID().toString().substring(0,5));
                }
            },String.valueOf(i)).start();
        }
    }


}
