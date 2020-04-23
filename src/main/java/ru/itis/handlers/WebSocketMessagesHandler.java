package ru.itis.handlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import ru.itis.dto.MessageDto;

import java.lang.reflect.Array;
import java.util.*;

@Component
@EnableWebSocket
public class WebSocketMessagesHandler extends TextWebSocketHandler {

    private static final Map<String, WebSocketSession> sessions = new HashMap<>();
    private static final Map<String, Map<String, WebSocketSession>> chatSessions = new HashMap<>();

    @Autowired
    private ObjectMapper objectMapper;



    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        String messageText = (String) message.getPayload();
        MessageDto messageFromJson = objectMapper.readValue(messageText, MessageDto.class);
        String chatName = messageFromJson.getChatName();

        if (!sessions.containsKey(messageFromJson.getFrom())) {
            sessions.put(messageFromJson.getFrom(), session);
        }





        //if (!chatSessions.containsKey(chatName)) {
        //    chatSessions.put(chatName, Map.of(messageFromJson.getFrom(), session));
        //} else if (chatSessions.containsKey(chatName) && !chatSessions.get(chatName).containsKey(messageFromJson.getFrom())){
        //    chatSessions.get(chatName).put(messageFromJson.getFrom(), session);
        //}

        //for (WebSocketSession currentSession : chatSessions.get(chatName).values()){
        //    currentSession.sendMessage(message);
        //}
        for (WebSocketSession currentSession : sessions.values()) {
            currentSession.sendMessage(message);
        }
    }
}

