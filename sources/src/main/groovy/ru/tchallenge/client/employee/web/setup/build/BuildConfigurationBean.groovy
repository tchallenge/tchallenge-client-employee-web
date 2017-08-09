package ru.tchallenge.client.employee.web.setup.build

import groovy.transform.PackageScope
import groovy.transform.TypeChecked

import java.time.Instant

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource

@TypeChecked
@PackageScope
@Configuration
@PropertySource('classpath:build.properties')
class BuildConfigurationBean {

    @Value('${id}')
    String id

    @Value('${version}')
    String version

    @Value('${createdAt}')
    String createdAt

    @Bean
    BuildLayout buildLayout() {
        new BuildLayout(
                id: id,
                version: version,
                createdAt: Instant.parse(createdAt)
        )
    }
}
