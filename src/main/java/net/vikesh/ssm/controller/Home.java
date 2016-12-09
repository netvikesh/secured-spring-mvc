package net.vikesh.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Vikesh on 09-Dec-16.
 */
@Controller
public class Home {

    @RequestMapping("/")
    public String home() {
        return "index";
    }
}
