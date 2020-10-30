package com.od.crowdy.project.handler;

import com.od.crowdy.project.domain.model.Category;
import com.od.crowdy.project.facade.CategoryFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CategoryHandler {
    private final CategoryFacade CategoryFacade;

    public Mono<ServerResponse> findCategoryById(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(CategoryFacade.findCategoryById(serverRequest.pathVariable("id")), Category.class);
    }

    public Mono<ServerResponse> saveCategory(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(CategoryFacade.saveAllCategory(serverRequest.bodyToFlux(Category.class)), Category.class);
    }

    public Mono<ServerResponse> deleteCategoryById(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(CategoryFacade.deleteById(serverRequest.pathVariable("id")), Void.class);
    }

    public Mono<ServerResponse> findAllCategory(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(CategoryFacade.findAllCategory(), Category.class);
    }
}
