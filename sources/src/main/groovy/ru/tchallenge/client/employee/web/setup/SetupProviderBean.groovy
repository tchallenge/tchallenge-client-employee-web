package ru.tchallenge.client.employee.web.setup

import groovy.transform.PackageScope
import groovy.transform.TypeChecked

import java.time.Instant
import javax.annotation.PostConstruct

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Component

import ru.tchallenge.client.employee.web.setup.build.BuildLayout

@TypeChecked
@PackageScope
@Component
@Lazy(false)
class SetupProviderBean implements SetupProvider {

    @Autowired
    BuildLayout build

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
                build: build,
                startedAt: Instant.now()
        )
    }
}
