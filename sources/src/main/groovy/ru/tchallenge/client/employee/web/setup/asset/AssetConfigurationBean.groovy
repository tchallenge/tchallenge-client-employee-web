package ru.tchallenge.client.employee.web.setup.asset

import groovy.transform.PackageScope
import groovy.transform.TypeChecked

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@TypeChecked
@PackageScope
@Configuration
class AssetConfigurationBean {

    @Value('${tchallenge.asset.vendor.prefix}')
    String vendorUriPrefix

    @Bean
    AssetLayout assetLayout() {
        new AssetLayout(
                scripts: scripts,
                styles: styles
        )
    }

    private Collection<AssetDescriptor> getScripts() {
        vendorScripts + applicationScripts
    }

    private Collection<AssetDescriptor> getStyles() {
        vendorStyles + applicationStyles
    }

    private static Collection<AssetDescriptor> getApplicationScripts() {
        []
    }

    private static Collection<AssetDescriptor> getApplicationStyles() {
        []
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

    private AssetDescriptor vendorScript(String uri) {
        vendorAsset(uri, AssetType.SCRIPT)
    }

    private AssetDescriptor vendorStyle(String uri) {
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
