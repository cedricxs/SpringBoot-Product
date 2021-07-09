package com.cedricxs.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chaxingshuo
 * @date 2021/07/10
 */
@SpringBootApplication(scanBasePackages = {"com.cedricxs.application.controller"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}