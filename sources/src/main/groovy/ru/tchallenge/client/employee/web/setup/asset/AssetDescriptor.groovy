package ru.tchallenge.client.employee.web.setup.asset

import groovy.transform.Immutable
import groovy.transform.TypeChecked

@TypeChecked
@Immutable
class AssetDescriptor {

    AssetType type
    String uri
    boolean vendor
}
