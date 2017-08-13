package ru.tchallenge.client.employee.web

import groovy.transform.PackageScope
import groovy.transform.TypeChecked

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.ObjectMapper

import ru.tchallenge.client.employee.web.utility.serialization.instant.InstantDeserializer
import ru.tchallenge.client.employee.web.utility.serialization.instant.InstantSerializer

@TypeChecked
@PackageScope
@Configuration
class SerializationConfigurationBean {

    @Bean
    ObjectMapper jacksonObjectMapper() {
        new Jackson2ObjectMapperBuilder()
                .failOnEmptyBeans(false)
                .serializationInclusion(JsonInclude.Include.NON_NULL)
                .serializationInclusion(JsonInclude.Include.NON_EMPTY)
                .serializers(instantSerializer())
                .deserializers(instantDeserializer())
                .build()
    }

    @Bean
    InstantSerializer instantSerializer() {
        new InstantSerializer()
    }

    @Bean
    InstantDeserializer instantDeserializer() {
        new InstantDeserializer()
    }
}
