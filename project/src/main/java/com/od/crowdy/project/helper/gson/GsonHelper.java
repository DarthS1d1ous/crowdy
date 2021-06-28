package com.od.crowdy.project.helper.gson;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class GsonHelper {

    private final Gson gson;

    public <T> Mono<T> getMonoFromJsonString(String json, Class<T> classOfT) {
        return Mono.just(this.gson.fromJson(json, classOfT));
    }
}
