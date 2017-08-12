package ru.tchallenge.client.employee.web.setup.asset.cache

import groovy.transform.Immutable
import groovy.transform.TypeChecked

import java.time.Duration

@TypeChecked
@Immutable(knownImmutableClasses = [Duration])
class AssetCacheLayout {

    Boolean enabled
    Duration expiration
}
