package ru.itis.repositories;

import ru.itis.models.Chat;

import java.util.Optional;

public interface ChatsRepository extends CrudRepository<Chat, Long> {
    Optional<Chat> findOneByName(String name);
}
