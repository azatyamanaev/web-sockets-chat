package ru.itis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LogoutController {

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        Cookie ck = new Cookie("auth","");
        response.addCookie(ck);
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }
}
