package com.wzxlq.kill.server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 王照轩
 * @date 2020/2/2 - 12:40
 */
@Controller
@RequestMapping("base")
public class BaseController {
    private static final  Logger log = LoggerFactory.getLogger(BaseController.class);
    @GetMapping("/welcome")
    public String welcome(String name, ModelMap modelMap){
        if(StringUtils.isEmpty(name)){
            name="this is welcome";
        }
        modelMap.put("name",name);
       return "welcome";
    }
    @RequestMapping(value = "/data",method = RequestMethod.GET)
    @ResponseBody
    public String data(String name){
        if(StringUtils.isEmpty(name)){
            name="this is welcome!";
        }
        return name;
    }
    @RequestMapping(value = "/error",method = RequestMethod.GET)
    public String error(){
        return "error";
    }
}
