package ru.tchallenge.client.employee.web.setup

import groovy.transform.PackageScope
import groovy.transform.TypeChecked

import java.time.Instant

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import ru.tchallenge.client.employee.web.setup.asset.AssetLayoutProviderService
import ru.tchallenge.client.employee.web.setup.location.LocationLayout
import ru.tchallenge.client.employee.web.utility.build.Build

@TypeChecked
@PackageScope
@Configuration
class SetupConfigurationBean {

    @Autowired
    AssetLayoutProviderService assetLayoutProviderService

    @Autowired
    Build build

    @Autowired
    LocationLayout location

    @Value('${tchallenge.mode}')
    String mode

    @Bean
    SetupLayout setupLayout() {
        new SetupLayout(
                title: 'tchallenge-client-employee-web',
                description: 'T-Challenge client web application for employees',
                asset: assetLayoutProviderService.layout,
                build: build,
                location: location,
                mode: mode,
                startedAt: Instant.now()
        )
    }
}
