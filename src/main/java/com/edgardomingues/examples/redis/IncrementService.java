package com.edgardomingues.examples.redis;

import io.quarkus.redis.client.RedisClient;
import io.quarkus.redis.client.reactive.ReactiveRedisClient;
import io.smallrye.mutiny.Uni;

import io.vertx.mutiny.redis.client.Response;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import static java.util.Arrays.asList;

@Singleton
class IncrementService {

    @Inject
    RedisClient redisClient; 

    @Inject
    ReactiveRedisClient reactiveRedisClient; 

    Uni<Void> del(String key) {
        return reactiveRedisClient.del(asList(key))
                .map(response -> null);
    }

    String get(String key) {
        return redisClient.get(key).toString();
    }

    void set(String key, Integer value) {
        redisClient.set(asList(key, value.toString()));
    }

    Uni<Void> setReactive(String key, Integer value) {
        return this.reactiveRedisClient
            .set(Arrays.asList(key, value.toString()))
            .map(response -> null);
    }

    void increment(String key, Integer incrementBy) {
        redisClient.incrby(key, incrementBy.toString());
    }

    Uni<List<String>> keys() {
        return reactiveRedisClient
                .keys("*")
                .map(response -> {
                    List<String> result = new ArrayList<>();
                    for (Response r : response) {
                        result.add(r.toString());
                    }
                    return result;
                });
    }
}