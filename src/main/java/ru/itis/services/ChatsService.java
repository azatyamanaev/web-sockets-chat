package ru.itis.services;

import ru.itis.dto.ChatDto;

import java.util.List;

public interface ChatsService {
    void createChat(String name);
    List<ChatDto> getAll();
}
