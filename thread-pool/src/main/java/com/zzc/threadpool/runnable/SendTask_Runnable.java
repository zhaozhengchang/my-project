package com.zzc.threadpool.runnable;

import com.zzc.threadpool.common.Constants;
import com.zzc.threadpool.util.ThreadPoolExecutorForTime;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaoZhengchang
 * @create_date 2018-11-22 16:27
 * Description:
 **/

public class SendTask_Runnable implements Runnable{

    private static int token = 1 ;
    static ExecutorService pool = new ThreadPoolExecutorForTime(Constants.CORE_THREAD_NUM, Constants.MAX_THREAD_NUM,
            60L, TimeUnit.SECONDS,new LinkedBlockingDeque<>());
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + "   2");
            SendTask2_Runnable sendTask2_runnable = new SendTask2_Runnable();
            pool.execute(sendTask2_runnable);

            System.out.println(Thread.currentThread().getName() + "   4");
            Thread.sleep(500);
            System.out.println(Thread.currentThread().getName() + "   4");
//            int token = getToken();
//            String path ="http://localhost:8081/test?token=" + token;
//            CloseableHttpClient httpClient = HttpClients.createDefault();
//            // 创建一个 GET 请求
//            HttpGet httpGet = new HttpGet(path);
//            // 执行请求
//            CloseableHttpResponse response = httpClient.execute(httpGet);
//            //取响应的结果
//            int content = Integer.valueOf(EntityUtils.toString(response.getEntity(), "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int getToken(){
        synchronized (this){
            token++ ;
            return token;
        }
    }

    public static void main(String[] args) {
        SendTask_Runnable task = new SendTask_Runnable();

        System.out.println(Thread.currentThread().getName() + "   1");
//        for (int i = 0; i < Constants.TASK_COUNT ; i++) {
            pool.execute(task);
//        }
        System.out.println(Thread.currentThread().getName() + "   5");
//        pool.shutdown();
    }



}
