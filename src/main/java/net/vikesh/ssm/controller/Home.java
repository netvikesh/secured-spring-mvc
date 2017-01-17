package net.vikesh.ssm.controller;

import net.vikesh.ssm.controller.form.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Vikesh on 09-Dec-16.
 */
@Controller
public class Home {

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    public String getLogin() {
        return "login";
    }

    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    public String doLogin(LoginForm loginForm) {
        return "login";
    }
}
