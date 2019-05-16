package com.zzc.paramtest.controller;

import com.zzc.paramtest.param.ParamsVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author zhaoZhengchang
 * @create_date 2018-12-10 14:30
 * Description:
 **/

@Controller
public class UserController {


@RequestMapping(value = "/get",method = RequestMethod.GET)
@ResponseBody
    public String get(HttpSession session){
       return "OK";
    }

    @PostMapping("/get1")
    @ResponseBody
    public String get1(@RequestBody ParamsVO paramsVO){

    System.out.println("****************" + paramsVO);

    return paramsVO.toString();
    }

}
