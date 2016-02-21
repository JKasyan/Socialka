package com.kasyan.Socialka.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.jsp.PageContext;

/**
 * Created by evgen on 21.02.16.
 */
@Controller
public class MsgController {

    @RequestMapping("/messages")
    public String getMessagePage() {
        return "/messages";
    }
}
