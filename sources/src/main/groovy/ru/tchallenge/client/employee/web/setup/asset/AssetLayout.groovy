package ru.tchallenge.client.employee.web.setup.asset

import groovy.transform.Immutable
import groovy.transform.TypeChecked

import ru.tchallenge.client.employee.web.setup.asset.cache.AssetCacheLayout

@TypeChecked
@Immutable
class AssetLayout {

    AssetCacheLayout cache
    Collection<AssetDescriptor> markups
    Collection<AssetDescriptor> scripts
    Collection<AssetDescriptor> styles
    Collection<AssetDescriptor> unknown
    Collection<AssetDescriptor> vendorScripts
    Collection<AssetDescriptor> vendorStyles
}
