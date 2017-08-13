package ru.tchallenge.client.employee.web.setup.asset

import groovy.transform.PackageScope
import groovy.transform.TypeChecked

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

import ru.tchallenge.client.employee.web.setup.asset.cache.AssetCacheLayout

@TypeChecked
@PackageScope
@Service
class AssetLayoutProviderServiceBean implements AssetLayoutProviderService {

    @Autowired
    AssetCacheLayout cache

    @Value('${tchallenge.asset.vendor.prefix}')
    String vendorUriPrefix

    @Autowired
    LocalAssetLocatorService localAssetLocatorService

    @Override
    AssetLayout getLayout() {
        Collection<AssetDescriptor> markups = []
        Collection<AssetDescriptor> scripts = []
        Collection<AssetDescriptor> styles = []
        Collection<AssetDescriptor> unknowns = []
        localAssetLocatorService.descriptors.each { AssetDescriptor it ->
            switch (it.type) {
                case AssetType.MARKUP:
                    markups << it
                    break
                case AssetType.SCRIPT:
                    scripts << it
                    break
                case AssetType.STYLE:
                    styles << it
                    break
                default:
                    unknowns << it
            }
        }
        scripts.sort { AssetDescriptor left, AssetDescriptor right ->
            scriptPrecedence(left) - scriptPrecedence(right)
        }
        new AssetLayout(
                cache: cache,
                markups: markups,
                scripts: vendorScripts + scripts,
                styles: vendorStyles + styles,
                unknown: unknowns
        )
    }

    private static int scriptPrecedence(AssetDescriptor asset) {
        int result = 1
        if (asset.uri.contains('.module')) {
            result =- 1
        }
        if (asset.uri.contains('main.js')) {
            result =+ 2
        }
        result
    }

    private Collection<AssetDescriptor> getVendorScripts() {
        [
                vendorScript('angular.js/1.6.5/angular.min.js'),
                vendorScript('angular-ui-router/1.0.3/angular-ui-router.min.js'),
                vendorScript('jquery/3.2.1/jquery.min.js'),
                vendorScript('ngStorage/0.3.11/ngStorage.min.js'),
                vendorScript('twitter-bootstrap/3.3.7/js/bootstrap.min.js')
        ]
    }

    private Collection<AssetDescriptor> getVendorStyles() {
        [
                vendorStyle('twitter-bootstrap/3.3.7/css/bootstrap.min.css'),
                vendorStyle('twitter-bootstrap/3.3.7/css/bootstrap-theme.min.css')
        ]
    }

    AssetDescriptor vendorScript(String uri) {
        vendorAsset(uri, AssetType.SCRIPT)
    }

    AssetDescriptor vendorStyle(String uri) {
        vendorAsset(uri, AssetType.STYLE)
    }

    private AssetDescriptor vendorAsset(String uri, AssetType type) {
        new AssetDescriptor(
                type: type,
                uri: "${vendorUriPrefix}${uri}",
                vendor: true
        )
    }
}
