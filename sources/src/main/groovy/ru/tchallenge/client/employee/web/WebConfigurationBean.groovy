package ru.tchallenge.client.employee.web

import groovy.transform.PackageScope
import groovy.transform.TypeChecked

import org.springframework.context.annotation.Configuration
import org.springframework.http.CacheControl
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

@TypeChecked
@PackageScope
@Configuration
class WebConfigurationBean extends WebMvcConfigurerAdapter {

    private final static String PATH_STATIC = 'classpath:/static/'
    private final static String URI_PATTERN_ANY = '/**'
    private final static String URI_PATTERN_STATIC = '/**'

    @Override
    void addCorsMappings(CorsRegistry registry) {
        registry.addMapping(URI_PATTERN_ANY)
    }

    @Override
    void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler(URI_PATTERN_STATIC)
                .addResourceLocations(PATH_STATIC)
                .setCacheControl(CacheControl.noCache())
    }

    @Override
    void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false)
    }
}
