package com.zzc.paramtest.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @Auther: Jacy
 * @Date: 2018/7/19 11:55
 * @Description: session监听器，session失效时触发
 */
@WebListener
public class SessionListener implements HttpSessionListener  {

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {


        System.out.println("session创建。。。。");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("session销毁。。。。");
    }

}
