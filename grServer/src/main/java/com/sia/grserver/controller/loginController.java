package com.sia.grserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class loginController {
    @GetMapping("/myLogin")
    public String login(){
        return "login";
    }
    @GetMapping("/templates")
    public String templates(){
        return "login";
    }
}
