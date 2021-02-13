package com.edgardomingues.examples.redis;

import io.quarkus.test.junit.QuarkusTest;
import org.jnosql.diana.api.key.BucketManager;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
public class JNoSqlIT {

    @Inject
    BucketManager bucketManager;

    @Test
    void bucketManager() {
        bucketManager.put("test-key", "test-value");

        assertEquals("test-value", bucketManager.get("test-key").get().get(String.class));

        bucketManager.remove("test-key");

        assertTrue(bucketManager.get("test-key").isEmpty());
    }
}
