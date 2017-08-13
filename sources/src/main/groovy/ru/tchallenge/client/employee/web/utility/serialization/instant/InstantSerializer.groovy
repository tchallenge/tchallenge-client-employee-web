package ru.tchallenge.client.employee.web.utility.serialization.instant

import groovy.transform.TypeChecked

import java.time.Instant

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider

@TypeChecked
class InstantSerializer extends JsonSerializer<Instant> {

    @Override
    void serialize(Instant value, JsonGenerator generator, SerializerProvider serializers)
            throws IOException, JsonProcessingException {
        generator.writeString(value.toString())
    }

    @Override
    Class<Instant> handledType() {
        Instant
    }
}
