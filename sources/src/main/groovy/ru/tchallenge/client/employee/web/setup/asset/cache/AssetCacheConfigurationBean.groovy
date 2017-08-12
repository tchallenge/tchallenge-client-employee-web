package ru.tchallenge.client.employee.web.setup.asset.cache

import groovy.transform.PackageScope
import groovy.transform.TypeChecked

import java.time.Duration

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@TypeChecked
@PackageScope
@Configuration
class AssetCacheConfigurationBean {

    @Value('${tchallenge.asset.cache.enabled}')
    Boolean enabled

    @Value('${tchallenge.asset.cache.expiration}')
    String expiration

    @Bean
    AssetCacheLayout assetCacheLayout() {
        new AssetCacheLayout(
                enabled: enabled,
                expiration: Duration.parse(expiration)
        )
    }
}
