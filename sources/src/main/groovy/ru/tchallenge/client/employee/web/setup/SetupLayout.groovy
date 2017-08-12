package ru.tchallenge.client.employee.web.setup

import groovy.transform.Immutable
import groovy.transform.TypeChecked

import java.time.Instant

import ru.tchallenge.client.employee.web.setup.asset.AssetLayout
import ru.tchallenge.client.employee.web.setup.build.BuildLayout
import ru.tchallenge.client.employee.web.setup.location.LocationLayout

@TypeChecked
@Immutable(knownImmutableClasses = [Instant])
class SetupLayout {

    String title
    String description
    AssetLayout asset
    BuildLayout build
    LocationLayout location
    Instant startedAt
}
