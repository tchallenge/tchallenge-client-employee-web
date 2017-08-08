package ru.tchallenge.client.employee.web.utility.template

import groovy.transform.PackageScope
import groovy.transform.TypeChecked

import java.util.concurrent.ConcurrentHashMap

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import com.github.jknack.handlebars.Handlebars
import com.github.jknack.handlebars.Template
import com.github.jknack.handlebars.io.ClassPathTemplateLoader
import com.github.jknack.handlebars.io.TemplateLoader

@TypeChecked
@PackageScope
@Configuration
class TemplateConfigurationBean {

    @Value('${tchallenge.template.cache.enabled}')
    Boolean cacheEnabled

    @Bean
    Map<String, Template> predefinedCache() {
        new ConcurrentHashMap<String, Template>()
    }

    @Bean
    TemplateLoader loader() {
        new ClassPathTemplateLoader()
    }

    @Bean
    Handlebars compiler(TemplateLoader loader) {
        new Handlebars(loader)
    }

    @Bean
    TemplateCacheLayout layout() {
        new TemplateCacheLayout(
                enabled: cacheEnabled
        )
    }
}
