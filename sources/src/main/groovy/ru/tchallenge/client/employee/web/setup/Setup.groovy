package ru.tchallenge.client.employee.web.setup

import groovy.transform.Immutable
import groovy.transform.TypeChecked

import java.time.Instant

@TypeChecked
@Immutable(knownImmutableClasses = [Instant])
class Setup {

    String title
    String description

    String version
    String build

    Instant startedAt
}
