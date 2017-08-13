package ru.tchallenge.client.employee.web

import groovy.transform.PackageScope
import groovy.transform.TypeChecked

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import com.github.jknack.handlebars.Handlebars
import com.github.jknack.handlebars.io.ClassPathTemplateLoader
import com.github.jknack.handlebars.io.TemplateLoader

import ru.tchallenge.client.employee.web.utility.template.TemplateCacheLayout
import ru.tchallenge.client.employee.web.utility.template.TemplateService
import ru.tchallenge.client.employee.web.utility.template.TemplateServiceBean

@TypeChecked
@PackageScope
@Configuration
class TemplateConfigurationBean {

    @Value('${tchallenge.template.cache.enabled}')
    Boolean cacheEnabled

    @Bean
    TemplateService templateService(Handlebars handlebars, TemplateCacheLayout cacheLayout) {
        new TemplateServiceBean(
                cacheLayout: cacheLayout,
                handlebars: handlebars
        )
    }

    @Bean
    TemplateCacheLayout templateCacheLayout() {
        new TemplateCacheLayout(
                enabled: cacheEnabled
        )
    }

    @Bean
    Handlebars handlebars(TemplateLoader loader) {
        new Handlebars(loader)
    }

    @Bean
    TemplateLoader templateLoader() {
        new ClassPathTemplateLoader()
    }
}
