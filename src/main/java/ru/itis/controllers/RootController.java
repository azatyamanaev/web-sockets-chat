package ru.itis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class RootController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getRootPage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("auth", false);
        Cookie[] ck = request.getCookies();
        if (ck != null) {
            String auth = ck[0].getValue();
            if (auth.equals("true")) {
                modelAndView.addObject("auth", true);
            }
        }
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
