package ru.tchallenge.client.employee.web.utility.serialization.instant

import groovy.transform.TypeChecked

import java.time.Instant
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer

@TypeChecked
class InstantDeserializer extends JsonDeserializer<Instant> {

    @Override
    Instant deserialize(JsonParser parser, DeserializationContext context)
            throws IOException, JsonProcessingException {
        String iso = parser.valueAsString
        ZonedDateTime.parse(iso, DateTimeFormatter.ISO_OFFSET_DATE_TIME).toInstant()
    }

    @Override
    Class<Instant> handledType() {
        Instant
    }
}
