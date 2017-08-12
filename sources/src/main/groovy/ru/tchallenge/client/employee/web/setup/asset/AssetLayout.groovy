package ru.tchallenge.client.employee.web.setup.asset

import groovy.transform.Immutable
import groovy.transform.TypeChecked

import ru.tchallenge.client.employee.web.setup.asset.cache.AssetCacheLayout

@TypeChecked
@Immutable
class AssetLayout {

    AssetCacheLayout cache
    Collection<AssetDescriptor> scripts
    Collection<AssetDescriptor> styles
}
