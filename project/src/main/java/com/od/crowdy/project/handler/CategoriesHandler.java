package com.od.crowdy.project.handler;

import com.od.crowdy.project.domain.model.Categories;
import com.od.crowdy.project.facade.CategoriesFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CategoriesHandler {
    private final CategoriesFacade categoriesFacade;

    public Mono<ServerResponse> findCategoryById(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(categoriesFacade.findCategoryById(serverRequest.pathVariable("id")), Categories.class);
    }

    public Mono<ServerResponse> saveCategory(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(categoriesFacade.saveCategory(serverRequest.bodyToMono(Categories.class)), Categories.class);
    }

    public Mono<ServerResponse> deleteCategoryById(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(categoriesFacade.deleteById(serverRequest.pathVariable("id")), Void.class);
    }

    public Mono<ServerResponse> findAllCategories(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(categoriesFacade.findAllCategories(), Categories.class);
    }
}
