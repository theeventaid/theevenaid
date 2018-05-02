package com.tgj.eventaid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class TEAApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {

        SpringApplication.run(TEAApplication.class, args);
    }
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TEAApplication.class);
    }
}
