package ru.tchallenge.client.employee.web.setup.location

import groovy.transform.Immutable
import groovy.transform.TypeChecked

@TypeChecked
@Immutable
class LocationLayout {

    String base
    String client
    ServiceLocationLayout service
}
