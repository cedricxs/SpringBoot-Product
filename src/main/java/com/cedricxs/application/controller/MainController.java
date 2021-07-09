package com.cedricxs.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author chaxingshuo
 * @date 2021/07/10
 */
@Controller
public class MainController {

    @GetMapping({"/", "/index"})
    public String index() {
        return "index.html";
    }

    @GetMapping("/elements")
    public String elements() {
        return "elements.html";
    }

    @GetMapping("/generic")
    public String generic() {
        return "generic.html";
    }


}
