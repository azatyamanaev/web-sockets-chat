package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.services.ChatsService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CreateChatController {

    @Autowired
    private ChatsService chatsService;

    @RequestMapping(value = "/createChat", method = RequestMethod.GET)
    public ModelAndView getCreateChatPage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        Cookie[] ck = request.getCookies();
        if (ck != null) {
            String auth = ck[0].getValue();
            if (auth.equals("true")) {
                modelAndView.setViewName("createChat");
            }
        } else {
            modelAndView.setViewName("redirect:/logIn");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/createChat", method = RequestMethod.POST)
    public ModelAndView createChat(String name, HttpServletRequest request) {
        chatsService.createChat(name);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/chat?name=" + name + "&login=" + request.getCookies()[1].getValue());
        return modelAndView;
    }
}
