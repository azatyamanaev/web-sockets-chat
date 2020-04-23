package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.dto.LogInDto;
import ru.itis.models.User;
import ru.itis.repositories.UsersRepository;

import java.util.Optional;

@Component(value = "logInServiceImpl")
public class LogInServiceImpl implements LogInService {

    @Autowired
    @Qualifier(value = "usersRepositoryJdbcTemplateImpl")
    private UsersRepository usersRepository;

    @Override
    public Boolean logIn(LogInDto form) {
        Optional<User> clientCandidate;
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        User user;
        clientCandidate = usersRepository.findOneByLogin(form.getLogin());
        if (clientCandidate.isPresent()) {
            user = clientCandidate.get();
            return encoder.matches(form.getPassword(), user.getPassword());
        }
        else {
            return false;
        }
    }
}
