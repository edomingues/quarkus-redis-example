package com.edgardomingues.examples.redis;

import io.smallrye.mutiny.Uni;
import org.jnosql.diana.api.key.BucketManager;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
class IncrementService {

    @Inject
    BucketManager bucketManager;

    void del(String key) {
        bucketManager.remove(key);
    }

    String get(String key) {
        return bucketManager.get(key).map(value -> value.get(String.class)).orElseThrow();
    }

    void set(String key, Integer value) {
        bucketManager.put(key, value);
    }

    void increment(String key, Integer incrementBy) {
        throw new UnsupportedOperationException();
    }

    Uni<List<String>> keys() {
        throw new UnsupportedOperationException();
    }
}