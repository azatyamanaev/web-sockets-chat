package ru.itis.repositories;

import ru.itis.models.User;

import java.util.Optional;

public interface UsersRepository extends CrudRepository<User, Long> {
    Optional<User> findOneByLogin(String login);
    void deleteOneByLogin(String login);
}
