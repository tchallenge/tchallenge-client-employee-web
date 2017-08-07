package ru.tchallenge.client.employee.web

import groovy.transform.TypeChecked

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.support.SpringBootServletInitializer

@TypeChecked
@SpringBootApplication
@EnableAutoConfiguration(exclude = [ErrorMvcAutoConfiguration])
class Application extends SpringBootServletInitializer {

    static void main(String... arguments) {
        SpringApplication.run(Application, arguments)
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        application.sources(Application)
    }
}
