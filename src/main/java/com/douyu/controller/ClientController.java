package com.douyu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Dangerous
 * @time: 2020/3/6 21:38
 */
@RestController
public class ClientController {
    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String index(){
        return "hello CRM_debug";
    }
}
