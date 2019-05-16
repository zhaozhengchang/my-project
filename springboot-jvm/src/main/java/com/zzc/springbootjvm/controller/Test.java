package com.zzc.springbootjvm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoZhengchang
 * @create_date 2018-11-29 17:51
 * Description:
 **/
@Controller
public class Test {

    private List addList = new ArrayList();

    @RequestMapping("/add")
    public void add(){
        while (true){
            addList.add("add-test");
        }
    }
}
