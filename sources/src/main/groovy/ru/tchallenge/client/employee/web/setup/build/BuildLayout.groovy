package ru.tchallenge.client.employee.web.setup.build

import groovy.transform.Immutable
import groovy.transform.TypeChecked

import java.time.Instant

@TypeChecked
@Immutable(knownImmutableClasses = [Instant])
class BuildLayout {

    String id
    String version
    Instant createdAt
}
