package ru.itis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ChatsController {

    @RequestMapping(value = "/chats", method = RequestMethod.GET)
    public ModelAndView getChatsPage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        Cookie[] ck = request.getCookies();
        if (ck != null) {
            String auth = ck[0].getValue();
            if (auth.equals("true")) {
                modelAndView.setViewName("chats");
            }
        } else {
            modelAndView.setViewName("redirect:/logIn");
        }
        return modelAndView;
    }
}
