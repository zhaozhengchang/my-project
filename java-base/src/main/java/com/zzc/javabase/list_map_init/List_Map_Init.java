package com.zzc.javabase.list_map_init;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhaoZhengchang
 * @create_date 2018-08-19 16:53
 **/

public class List_Map_Init {
    public static void main(String[] args) {
        final int count = 20 * 100000;



        List<Integer> list = new ArrayList<>(count);
        long begin = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            list.add(i);
        }
        System.out.println("设置了ArrayList初始容量： " + (System.currentTimeMillis() - begin) + " ms");

         list = new ArrayList<>();
         begin = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            list.add(i);
        }
        System.out.println("没有设置ArrayList初始容量： " + (System.currentTimeMillis() - begin) + " ms");





        Map map = new HashMap();
        begin = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            map.put(i, i);
        }
        System.out.println("没有设置HashMap初始容量： " + (System.currentTimeMillis() - begin) + " ms");

        map = new HashMap(2097152);
        begin = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            map.put(i, i);
        }
        System.out.println("设置了HashMap初始容量为2^n： " + (System.currentTimeMillis() - begin) + " ms");


        map = new HashMap(count);
        begin = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            map.put(i, i);
        }
        System.out.println("设置了HashMap初始容量为"+count+"   ： " + (System.currentTimeMillis() - begin) + " ms");





    }
}
