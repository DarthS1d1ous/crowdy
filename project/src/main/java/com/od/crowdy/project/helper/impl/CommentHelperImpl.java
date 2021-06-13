package com.od.crowdy.project.helper.impl;

import com.od.crowdy.project.dto.CommentDto;
import com.od.crowdy.project.helper.CommentHelper;
import com.od.crowdy.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CommentHelperImpl implements CommentHelper {
    private final UserService userService;

    @Override
    public Mono<CommentDto> fillCommentAuthor(CommentDto commentDto) {
        return this.userService.getAuthorByCommentId(commentDto.getId())
            .doOnNext(commentDto::setAuthor)
            .thenReturn(commentDto);
    }
}
