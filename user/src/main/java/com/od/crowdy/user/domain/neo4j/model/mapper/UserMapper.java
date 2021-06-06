package com.od.crowdy.user.domain.neo4j.model.mapper;

import com.od.crowdy.common.domain.neo4j.model.mapper.Neo4jMapper;
import com.od.crowdy.user.domain.neo4j.model.User;
import org.neo4j.driver.Record;
import org.neo4j.driver.Value;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements Neo4jMapper<User> {
    private final static int USER_INDEX = 0;
    private final static String ID = "id";
    private final static String USERNAME = "username";
    private final static String PASSWORD = "password";
    private final static String FULL_NAME = "fullName";
    private final static String CREATED_AT = "createdAt";
    private final static String BIRTHDAY = "birthday";
    private final static String AVATAR = "avatar";

    @Override
    public User map(Record record) {
        Value user = record.values().get(USER_INDEX);
        return User.builder()
            .id(user.get(ID).asString())
            .username(user.get(USERNAME).asString())
            .password(user.get(PASSWORD).asString())
            .fullName(user.get(FULL_NAME).asString())
            .createdAt(user.get(CREATED_AT).asLocalDate())
            .birthday(user.get(BIRTHDAY).asLocalDate())
            .avatar(user.get(AVATAR).asString())
            .build();
    }
}
