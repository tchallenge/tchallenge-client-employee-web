package ru.tchallenge.client.employee.web.setup

import groovy.transform.Immutable
import groovy.transform.TypeChecked

import java.time.Instant

import ru.tchallenge.client.employee.web.setup.asset.AssetLayout
import ru.tchallenge.client.employee.web.setup.location.LocationLayout
import ru.tchallenge.client.employee.web.utility.build.Build

@TypeChecked
@Immutable(knownImmutableClasses = [Instant])
class SetupLayout {

    String title
    String description
    AssetLayout asset
    Build build
    LocationLayout location
    String mode
    Instant startedAt
}
