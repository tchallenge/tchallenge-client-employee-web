package ru.tchallenge.client.employee.web.setup.location

import groovy.transform.PackageScope
import groovy.transform.TypeChecked

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@TypeChecked
@PackageScope
@Configuration
class LocationConfigurationBean {

    @Value('${tchallenge.location.base}')
    String base

    @Value('${tchallenge.location.client}')
    String client

    @Value('${tchallenge.location.service.complex}')
    String serviceComplex

    @Bean
    LocationLayout locationLayout() {
        new LocationLayout(
                base: base,
                client: client,
                service: new ServiceLocationLayout(
                        complex: serviceComplex
                )
        )
    }
}
