package ru.itis.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.itis.models.Chat;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Repository
public class ChatsRepositoryJdbcTemplateImpl implements ChatsRepository {

    //language=SQL
    private final String SQL_INSERT_CHAT = "insert into chats" +
            "(name) values (?)";
    //language=SQL
    private final String SQL_UPDATE_CHAT = "update chats \n" +
            "set name = ? \n" +
            "where id = ?";
    //language=SQL
    private final String SQL_SELECT_ALL = "select * from chats";
    //language=SQL
    private final String SQL_SELECT_BY_ID = "select * from chats where id = ?";
    //language=SQL
    private final String SQL_SELECT_BY_NAME = "select * from chats where name = ?";
    //language=SQL
    private final String SQL_DELETE_BY_ID = "delete from chats where id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    RowMapper<Chat> chatRowMapper = (row, rowNumber) ->
            Chat.builder()
                    .id(row.getLong("id"))
                    .name(row.getString("name"))
                    .build();


    @Override
    public void save(Chat model) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(dataSource -> {
            PreparedStatement statement = dataSource.prepareStatement(SQL_INSERT_CHAT);
            statement.setString(1, model.getName());
            return statement;
        }, keyHolder);
        model.setId((Long) keyHolder.getKey());
    }

    @Override
    public void update(Chat model) {
        jdbcTemplate.update(dataSource -> {
            PreparedStatement statement = dataSource.prepareStatement(SQL_UPDATE_CHAT);
            statement.setString(1, model.getName());
            statement.setLong(2, model.getId());
            return statement;
        });
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update(dataSource -> {
            PreparedStatement statement = dataSource.prepareStatement(SQL_DELETE_BY_ID);
            statement.setLong(1, id);
            return statement;
        });
    }

    @Override
    public Optional<Chat> find(Long id) {
        try {
            Chat chat = jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, new Object[]{id}, chatRowMapper);
            return Optional.ofNullable(chat);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Chat> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, chatRowMapper);
    }

    @Override
    public Optional<Chat> findOneByName(String name) {
        try {
            Chat chat = jdbcTemplate.queryForObject(SQL_SELECT_BY_NAME, new Object[]{name}, chatRowMapper);
            return Optional.ofNullable(chat);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }
}
