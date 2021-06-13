package com.od.crowdy.project.helper;

import com.od.crowdy.project.dto.CommentDto;
import reactor.core.publisher.Mono;

public interface CommentHelper {
    Mono<CommentDto> fillCommentAuthor(CommentDto commentDto);
}
