package com.edgardomingues.examples.redis.config;

import jakarta.nosql.mapping.keyvalue.KeyValueTemplate;
import jakarta.nosql.mapping.keyvalue.KeyValueTemplateProducer;
import org.eclipse.jnosql.artemis.reflection.ClassMappingExtension;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class JNoSQLConfig {

    @Produces
    public ClassMappingExtension classMappingExtension() {
        return new ClassMappingExtension();
    }

    @Produces
    public KeyValueTemplateProducer keyValueTemplateProducer() {
        return new KeyValueTemplateProducer() {
            @Override
            public <T extends KeyValueTemplate> T get(final jakarta.nosql.keyvalue.BucketManager bucketManager) {
                throw new AssertionError("KeyValueTemplateProducer not implemented!");
            }
        };
    }

}
