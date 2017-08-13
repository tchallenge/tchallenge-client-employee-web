package ru.tchallenge.client.employee.web.setup.asset

import groovy.transform.TypeChecked

@TypeChecked
interface LocalAssetLocatorService {

    Collection<AssetDescriptor> getDescriptors()
}
