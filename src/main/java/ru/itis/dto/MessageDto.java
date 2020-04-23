package ru.itis.dto;

import lombok.Data;

@Data
public class MessageDto {
    private String text;
    private String from;
    private String chatName;
}

