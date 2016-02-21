package com.kasyan.Socialka.controllers;

import java.security.Principal;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.kasyan.Socialka.services.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kasyan.Socialka.dto.SmallImage;
import com.kasyan.Socialka.dto.User;

@Controller
public class MyPageController {

    @Autowired
    private UserService userService;
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @RequestMapping(value = "/my_page", method = RequestMethod.GET)
    public ModelAndView myPage(Principal principal) {
        ModelAndView mv = new ModelAndView("page");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        String name = principal.getName();
        logger.debug("Name from principal: " + name);
        User user = userService.getByEmail(email);
        mv.addObject("user", user);
        mv.addObject("isMyPage", Boolean.TRUE);
        return mv;
    }
}
