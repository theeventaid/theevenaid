package com.tgj.eventaid.controllers;

import com.tgj.eventaid.components.UberComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class UberController {

    @Autowired
    private UberComponent uberComponent;

    @GetMapping("/uber")
    @ResponseBody
    public String test() throws IOException {
        uberComponent.getRideTimeEstimate();
        return "Stuff And Things";
    }
}
