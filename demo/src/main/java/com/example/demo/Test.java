package com.example.demo;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author zhaoZhengchang
 * @create_date 2018-11-23 16:15
 * Description:
 **/

public abstract class Test {
    public static void main(String[] args) {
        sort();
    }

    public static void sort() {
        System.out.println("请输入若干个单词");
        Scanner input = new Scanner(System.in);
        ArrayList<String> character = new ArrayList<>();
       //控制集合中的元素
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            String s = input.next();
            character.add(s);
        }
        Collections.sort(character);
        for (String w : character) {
            System.out.println(w);
        }
    }

}