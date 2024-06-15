package com.ProductStore.ctl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomePageCtl {
    
    @Autowired
    private Environment env;

    @GetMapping("/welcomepage")
    public String welcomePage() {
        return "welcome";
    }
}
