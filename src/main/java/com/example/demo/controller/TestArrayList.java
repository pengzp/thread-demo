package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Author: pzp
 * @DateTime: 2020/8/13 15:18
 * @Description:
 */
public class TestArrayList {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    list.add(UUID.randomUUID().toString().substring(0,5));
                    System.out.println(list);
                }
            },String.valueOf(i)).start();
        }
    }
}
