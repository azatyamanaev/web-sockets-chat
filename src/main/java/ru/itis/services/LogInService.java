package ru.itis.services;

import ru.itis.dto.LogInDto;

public interface LogInService {
    Boolean logIn(LogInDto form);
}
