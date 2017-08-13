package ru.tchallenge.client.employee.web

import groovy.transform.PackageScope
import groovy.transform.TypeChecked

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import ru.tchallenge.client.employee.web.utility.build.Build
import ru.tchallenge.client.employee.web.utility.build.BuildParser

@TypeChecked
@PackageScope
@Configuration
class BuildConfigurationBean {

    @Bean
    Build build() {
        BuildParser.load('build.properties')
    }
}
