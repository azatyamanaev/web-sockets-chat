package ru.itis.models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder()
public class User {
    private Long id;
    private String login;
    private String email;
    private String password;
    private Role role;
}
