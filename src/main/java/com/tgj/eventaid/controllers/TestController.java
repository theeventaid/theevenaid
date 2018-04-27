package com.tgj.eventaid.controllers;

import com.tgj.eventaid.utilities.DomainUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @GetMapping("/")
    @ResponseBody
    public String helloWorld(@RequestHeader("Host") String host) {
        System.out.println(DomainUtils.extractSubdomain(host));
        return "Hello, World!";
    }
}
