package ru.itis.dto;

import lombok.Builder;
import lombok.Data;
import ru.itis.models.Chat;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class ChatDto {
    private String name;

    public static ChatDto from(Chat chat) {
        return ChatDto.builder()
                .name(chat.getName())
                .build();
    }

    public static List<ChatDto> from(List<Chat> chats) {
        return chats.stream()
                .map(ChatDto::from)
                .collect(Collectors.toList());
    }
}
