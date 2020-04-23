package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.dto.SignUpDto;
import ru.itis.services.SignUpService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public ModelAndView getSignUpPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("signUp");
        return modelAndView;
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public ModelAndView signUp(SignUpDto form, HttpServletResponse response) {
        Boolean auth = signUpService.signUp(form);
        ModelAndView modelAndView = new ModelAndView();
        if (auth) {
            modelAndView.setViewName("redirect:/");
            Cookie cookie = new Cookie("login", form.getLogin());
            Cookie authCookie = new Cookie("auth", "true");
            response.addCookie(authCookie);
            response.addCookie(cookie);
        } else {
            modelAndView.setViewName("redirect:/signUp?error");
        }
        return modelAndView;
    }
}
