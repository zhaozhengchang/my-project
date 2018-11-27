package com.zzc.threadpool.util;


import com.zzc.threadpool.common.Constants;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhaoZhengchang
 * @create_date 2018-11-23 16:47
 * Description:
 **/

public class ThreadPoolExecutorForTime extends ThreadPoolExecutor {

    private  AtomicInteger count = new AtomicInteger(0);//统计执行次数
    private long startTime = System.currentTimeMillis();

    public ThreadPoolExecutorForTime(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {//线程执行结束时
        //最后一个任务执行完毕后打印总耗时
        int num = count.addAndGet(1);
        if (num == Constants.TASK_COUNT) {
            System.out.println(  "******************spend time:" + (System.currentTimeMillis() - startTime +" ms"));
        }
    }
}
