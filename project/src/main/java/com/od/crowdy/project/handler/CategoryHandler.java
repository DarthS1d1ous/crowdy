package com.od.crowdy.project.handler;

import com.od.crowdy.project.dto.CategoryDto;
import com.od.crowdy.project.facade.CategoryFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
@RequiredArgsConstructor
public class CategoryHandler {
    private final CategoryFacade categoryFacade;

    public Mono<ServerResponse> getCategories(ServerRequest serverRequest) {
        return ok()
                .body(categoryFacade.getAllCategories(), CategoryDto.class);
    }
}
