package ru.tchallenge.client.employee.web.setup

import groovy.transform.PackageScope
import groovy.transform.TypeChecked

import java.time.Instant
import javax.annotation.PostConstruct

import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Component

@TypeChecked
@PackageScope
@Component
@Lazy(false)
class SetupProviderBean implements SetupProvider {

    private Setup value

    @Override
    Setup getValue() {
        value
    }

    @PostConstruct
    protected void init() {
        value = new Setup(
                title: 'tchallenge-client-employee-web',
                description: 'T-Challenge client web application for employees',
                version: '1.0.0-SNAPSHOT',
                build: UUID.randomUUID().toString(),
                startedAt: Instant.now()
        )
    }
}
