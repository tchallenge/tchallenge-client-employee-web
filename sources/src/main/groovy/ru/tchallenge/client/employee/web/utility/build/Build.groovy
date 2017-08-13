package ru.tchallenge.client.employee.web.utility.build

import groovy.transform.Immutable
import groovy.transform.TypeChecked

import java.time.Instant

@TypeChecked
@Immutable(knownImmutableClasses = [Instant])
class Build {

    String id
    Instant timestamp
    String version
}
