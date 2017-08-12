package ru.tchallenge.client.employee.web.setup

import groovy.transform.PackageScope
import groovy.transform.TypeChecked

import java.time.Instant

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import ru.tchallenge.client.employee.web.setup.asset.AssetLayout
import ru.tchallenge.client.employee.web.setup.build.BuildLayout
import ru.tchallenge.client.employee.web.setup.location.LocationLayout

@TypeChecked
@PackageScope
@Configuration
class SetupConfigurationBean {

    @Autowired
    AssetLayout asset

    @Autowired
    BuildLayout build

    @Autowired
    LocationLayout location

    @Value('${tchallenge.mode}')
    String mode

    @Bean
    SetupLayout setupLayout() {
        new SetupLayout(
                title: 'tchallenge-client-employee-web',
                description: 'T-Challenge client web application for employees',
                asset: asset,
                build: build,
                location: location,
                mode: mode,
                startedAt: Instant.now()
        )
    }
}
