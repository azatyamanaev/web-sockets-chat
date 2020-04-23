package ru.itis.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Chat {
    private Long id;
    private String name;
}
