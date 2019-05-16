package com.zzc.springbootjvm.controller.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoZhengchang
 * @create_date 2018-11-30 18:02
 * Description:
 *  栈中存放局部变量，参数，运行中间结果等。所以变量数量及值得大小都会影响栈的深度
 **/

public class JavaStack {

    private int count = 0;
    private List list = new ArrayList();

    /**
     * 递归方法
     */
    public void testStack(int a, int b) {
        int c = 5;
        long d = 44546546545456L;
        count++;
        testStack(a, b);
    }

    ;

    /**
     * 触发递归
     */
    public void test() {
        try {
            testStack(1, 2);
        } catch (Throwable e) {
            System.out.println(e);
            System.out.println("stack height:" + count);
        }
    }

    public void testFor() {
        int aaaaa = 445641564;
        int aaaaa1 = 445641564;
        int aaaaa11 = 445641564;
        int aaaaa12 = 445641564;
        int aaaaa13 = 445641564;
        int c = aaaaa;
        int b = aaaaa1;
        int d = aaaaa11;
    }

    public static void main(String[] args) {
        //递归前面只有入栈，没有出栈，容易造成栈溢出
        new JavaStack().test();
        //循环出栈入栈同时进行，即使循环9百万次，也不会栈溢出
        for (int i = 0; i < 9000000; i++) {
            int aaaaa = 445641564;
            int aaaaa1 = 445641564;
            int aaaaa11 = 445641564;
            int aaaaa12 = 445641564;
            int aaaaa13 = 445641564;
            new JavaStack().testFor();
        }

    }



}
