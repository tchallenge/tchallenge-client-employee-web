package ru.tchallenge.client.employee.web.setup.location

import groovy.transform.PackageScope
import groovy.transform.TypeChecked

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@TypeChecked
@PackageScope
@Service
class LocationLayoutProviderServiceBean implements LocationLayoutProviderService {

    @Value('${tchallenge.location.base}')
    String base

    @Value('${tchallenge.location.client}')
    String client

    @Value('${tchallenge.location.service.complex}')
    String serviceComplex

    @Override
    LocationLayout getLayout() {
        new LocationLayout(
                base: base,
                client: client,
                service: new ServiceLocationLayout(
                        complex: serviceComplex
                )
        )
    }
}
