package ru.tchallenge.client.employee.web.setup.asset

import groovy.transform.PackageScope
import groovy.transform.TypeChecked

import org.springframework.stereotype.Service

@TypeChecked
@PackageScope
@Service
class LocalAssetLocatorServiceBean implements LocalAssetLocatorService {

    String localAssetRootPathRelative = 'static'
    String localAssetUriPrefix = 'static/'

    @Override
    Collection<AssetDescriptor> getDescriptors() {
        Collection<AssetDescriptor> result = []
        File assetRoot = new File(assetRootPath)
        locateRecursive(assetRoot, assetRoot, result)
        result
    }

    private void locateRecursive(File file, File assetRoot, Collection<AssetDescriptor> assets) {
        if (file.directory) {
            file.listFiles().each { File it -> locateRecursive(it, assetRoot, assets) }
        } else {
            String assetPathRelative = assetRoot.relativePath(file)
            AssetDescriptor asset = new AssetDescriptor(
                    type: assetType(file),
                    uri: uri(assetPathRelative),
                    vendor: false
            )
            assets << asset
        }
    }

    private String uri(String localAssetPathRelative) {
        localAssetUriPrefix + localAssetPathRelative
    }

    private String getAssetRootPath() {
        Thread.currentThread()
                .getContextClassLoader()
                .getResource(localAssetRootPathRelative)
                .getPath()
    }

    private static AssetType assetType(File file) {
        String filename = file.name
        Integer extensionIndex = filename.lastIndexOf('.') + 1
        String extension = filename.substring(extensionIndex).toLowerCase()
        switch (extension) {
            case 'css':
                return AssetType.STYLE
            case 'js':
                return AssetType.SCRIPT
            case 'htm':
            case 'html':
                return AssetType.MARKUP
            default:
                return AssetType.UNKNOWN
        }
    }
}
