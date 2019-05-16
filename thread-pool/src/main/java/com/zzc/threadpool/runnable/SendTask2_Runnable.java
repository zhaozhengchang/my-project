package com.zzc.threadpool.runnable;

/**
 * @author zhaoZhengchang
 * @create_date 2018-12-18 14:39
 * Description:
 **/

public class SendTask2_Runnable implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "   3");
    }
}
