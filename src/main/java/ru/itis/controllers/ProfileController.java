package ru.itis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ProfileController {

    @RequestMapping(value = "/profile")
    public ModelAndView getProfilePage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        Cookie[] ck = request.getCookies();
        if (ck != null) {
            String login = ck[1].getValue();
            String auth = ck[0].getValue();
            if (auth.equals("true")) {
                modelAndView.addObject("login", login);
                modelAndView.setViewName("profile");
            }
        } else {
            modelAndView.setViewName("redirect:/logIn");
        }
        return modelAndView;
    }
}
