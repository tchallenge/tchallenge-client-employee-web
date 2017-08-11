package ru.tchallenge.client.employee.web.setup

import groovy.transform.Immutable
import groovy.transform.TypeChecked

import java.time.Instant

import ru.tchallenge.client.employee.web.setup.asset.AssetLayout
import ru.tchallenge.client.employee.web.setup.build.BuildLayout

@TypeChecked
@Immutable(knownImmutableClasses = [Instant])
class Setup {

    String title
    String description
    AssetLayout asset
    BuildLayout build
    Instant startedAt
}
