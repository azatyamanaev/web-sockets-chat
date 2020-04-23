package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.dto.ChatDto;
import ru.itis.services.ChatsService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CreatedChatsController {

    @Autowired
    private ChatsService chatsService;

    @RequestMapping(value = "/createdChats", method = RequestMethod.GET)
    public ModelAndView getCreatedChatsPage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        Cookie[] ck = request.getCookies();
        if (ck != null) {
            String auth = ck[0].getValue();
            if (auth.equals("true")) {
                modelAndView.setViewName("createdChats");
                List<ChatDto> chats = chatsService.getAll();
                modelAndView.addObject("chats", chats);
                modelAndView.addObject("login", request.getCookies()[1].getValue());
            }
        } else {
            modelAndView.setViewName("redirect:/logIn");
        }
        return modelAndView;
    }
}
