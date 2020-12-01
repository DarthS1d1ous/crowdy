package com.od.crowdy.user.helper;


import com.od.crowdy.user.dto.UserDto;
import reactor.core.publisher.Mono;

public interface UserHelper {
    Mono<UserDto> fillRoles(UserDto userDto);
}
