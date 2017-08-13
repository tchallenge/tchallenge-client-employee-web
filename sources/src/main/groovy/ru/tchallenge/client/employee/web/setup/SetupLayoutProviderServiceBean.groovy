package ru.tchallenge.client.employee.web.setup

import groovy.transform.PackageScope
import groovy.transform.TypeChecked

import java.time.Instant

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

import ru.tchallenge.client.employee.web.setup.asset.AssetLayoutProviderService
import ru.tchallenge.client.employee.web.setup.location.LocationLayoutProviderService
import ru.tchallenge.client.employee.web.utility.build.Build

@TypeChecked
@PackageScope
@Service
class SetupLayoutProviderServiceBean implements SetupLayoutProviderService {

    @Autowired
    AssetLayoutProviderService assetLayoutProviderService

    @Autowired
    Build build

    @Autowired
    LocationLayoutProviderService locationLayoutProviderService

    @Value('${tchallenge.mode}')
    String mode

    @Override
    SetupLayout getLayout() {
        new SetupLayout(
                title: 'tchallenge-client-employee-web',
                description: 'T-Challenge client web application for employees',
                asset: assetLayoutProviderService.layout,
                build: build,
                location: locationLayoutProviderService.layout,
                mode: mode,
                startedAt: Instant.now()
        )
    }
}
