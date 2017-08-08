package ru.tchallenge.client.employee.web.utility.template

import groovy.transform.PackageScope
import groovy.transform.TypeChecked

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import com.github.jknack.handlebars.Handlebars
import com.github.jknack.handlebars.Template

@TypeChecked
@PackageScope
@Component
class TemplateCacheLocalBean implements TemplateCache {

    @Autowired
    Map<String, Template> items

    @Autowired
    Handlebars compiler

    @Autowired
    TemplateCacheLayout layout

    @Override
    Template get(String name) {
        layout.enabled ? items.computeIfAbsent(name, this.&compile) : compile(name)
    }

    private Template compile(final String name) {
        try {
            compiler.compile(name)
        } catch (final Exception exception) {
            throw new RuntimeException(exception)
        }
    }
}
