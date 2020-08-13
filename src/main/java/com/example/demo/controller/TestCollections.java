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

    }
}
