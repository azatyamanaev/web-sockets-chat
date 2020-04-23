package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.dto.ChatDto;
import ru.itis.models.Chat;
import ru.itis.repositories.ChatsRepository;

import java.util.List;

@Service
public class ChatsServiceImpl implements ChatsService {

    @Autowired
    private ChatsRepository chatsRepository;

    @Override
    public void createChat(String name) {
        chatsRepository.save(Chat.builder()
                .name(name)
                .build());
    }

    @Override
    public List<ChatDto> getAll() {
        return ChatDto.from(chatsRepository.findAll());
    }
}
