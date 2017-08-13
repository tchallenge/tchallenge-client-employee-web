package ru.tchallenge.client.employee.web

import groovy.transform.PackageScope
import groovy.transform.TypeChecked

import java.time.Duration
import java.time.temporal.ChronoUnit
import java.time.temporal.TemporalUnit
import java.util.concurrent.TimeUnit

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.CacheControl
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

import ru.tchallenge.client.employee.web.setup.SetupLayout
import ru.tchallenge.client.employee.web.setup.asset.cache.AssetCacheLayout
import ru.tchallenge.client.employee.web.utility.request.forward.ForwardFilterRegistrationBuilder

@TypeChecked
@PackageScope
@Configuration
class WebConfigurationBean extends WebMvcConfigurerAdapter {

    private final static Integer FILTER_ORDER_FAVICON_FORWARD = 1
    private final static Integer FILTER_ORDER_INDEX_PAGE_FORWARD = 2

    private final static String PATH_STATIC = 'classpath:/static/'

    private final static String URI_ALIAS_FAVICON = '/favicon.ico'
    private final static String URI_ALIAS_INDEX = '/*'
    private final static String URI_FAVICON = '/static/images/favicon.ico'
    private final static String URI_INDEX = '/'
    private final static String URI_MAPPING_ANY = '/**'
    private final static String URI_MAPPING_STATIC = '/static/**'
    private final static String URI_PATTERN_SETUP = '/setup/?'
    private final static String URI_PATTERN_STATIC = '/static/.+'

    @Autowired
    SetupLayout setup

    @Override
    void addCorsMappings(CorsRegistry registry) {
        registry.addMapping(URI_MAPPING_ANY)
    }

    @Override
    void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler(URI_MAPPING_STATIC)
                .addResourceLocations(PATH_STATIC)
                .setCacheControl(cacheControl(setup.asset.cache))
    }

    @Override
    void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false)
    }

    @Bean
    FilterRegistrationBean faviconForwardFilterRegistration() {
        new ForwardFilterRegistrationBuilder(
                name: 'favicon-forward',
                order: FILTER_ORDER_FAVICON_FORWARD,
                scope: URI_ALIAS_FAVICON,
                target: URI_FAVICON
        ).build()
    }

    @Bean
    FilterRegistrationBean indexPageForwardFilterRegistration() {
        new ForwardFilterRegistrationBuilder(
                exclusions: [
                        URI_ALIAS_FAVICON,
                        URI_PATTERN_SETUP,
                        URI_PATTERN_STATIC
                ],
                name: 'index-page-forward',
                order: FILTER_ORDER_INDEX_PAGE_FORWARD,
                scope: URI_ALIAS_INDEX,
                target: URI_INDEX
        ).build()
    }

    private static CacheControl cacheControl(AssetCacheLayout layout) {
        layout.enabled ? maxAge(layout.expiration) : CacheControl.noCache()
    }

    private static CacheControl maxAge(Duration expiration) {
        CacheControl.maxAge(expiration.get(ChronoUnit.SECONDS), TimeUnit.SECONDS)
    }
}
