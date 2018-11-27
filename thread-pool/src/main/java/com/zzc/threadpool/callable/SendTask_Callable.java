package com.zzc.threadpool.callable;

import com.zzc.threadpool.common.Constants;
import com.zzc.threadpool.util.ThreadPoolExecutorForTime;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author zhaoZhengchang
 * @create_date 2018-11-22 16:27
 * Description:
 **/

public class SendTask_Callable implements Callable {

    public static int token = 1 ;
    @Override
    public Integer call() {
        int content = 0;
        try {
            int token = getToken();
            String path ="http://localhost:8081/test?token=" + token;
            CloseableHttpClient httpClient = HttpClients.createDefault();
            // 创建一个 GET 请求
            HttpGet httpGet = new HttpGet(path);
            // 执行请求
            CloseableHttpResponse response = httpClient.execute(httpGet);
            //取响应的结果
             content = Integer.valueOf(EntityUtils.toString(response.getEntity(), "UTF-8"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
    public int getToken(){
        synchronized (this){
            token++ ;
            return token;
        }
    }


    public static void main(String[] args) {
        SendTask_Callable task = new SendTask_Callable();
        ExecutorService pool = new ThreadPoolExecutorForTime(Constants.CORE_THREAD_NUM, Constants.MAX_THREAD_NUM,
                60L, TimeUnit.SECONDS,new LinkedBlockingDeque<>());

        // 创建任务集合
        List<FutureTask<Integer>> taskList = new ArrayList<>();
        for (int i = 0; i < Constants.TASK_COUNT ; i++) {
            FutureTask<Integer> ft = new FutureTask<>(task);
            taskList.add(ft);
            pool.submit(ft);
        }
        Integer totalResult = 0;
        for (FutureTask<Integer> ft : taskList) {
            try {
                //FutureTask的get方法会自动阻塞,直到获取计算结果为止
                totalResult =  ft.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        pool.shutdown();
    }


}
