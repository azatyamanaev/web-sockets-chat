package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.dto.LogInDto;
import ru.itis.services.LogInService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LogInController {

    @Autowired
    private LogInService logInService;

    @RequestMapping(value = "logIn", method = RequestMethod.GET)
    public ModelAndView getLogInPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("logIn");
        return modelAndView;
    }

    @RequestMapping(value = "/logIn", method = RequestMethod.POST)
    public ModelAndView logIn(LogInDto form, HttpServletResponse response) {
        Boolean auth = logInService.logIn(form);
        ModelAndView modelAndView = new ModelAndView();
        if (auth) {
            modelAndView.setViewName("redirect:/");
            Cookie cookie = new Cookie("login", form.getLogin());
            Cookie authCookie = new Cookie("auth", "true");
            response.addCookie(authCookie);
            response.addCookie(cookie);
        } else {
            modelAndView.setViewName("redirect:/logIn?error");
        }
        return modelAndView;
    }
}
