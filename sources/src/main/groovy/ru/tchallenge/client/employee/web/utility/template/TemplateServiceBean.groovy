package ru.tchallenge.client.employee.web.utility.template

import groovy.transform.TypeChecked

import com.github.jknack.handlebars.Handlebars
import com.github.jknack.handlebars.Template

@TypeChecked
class TemplateServiceBean implements TemplateService {

    TemplateCacheLayout cacheLayout

    Handlebars handlebars

    private final Map<String, Template> items = [:]

    @Override
    String render(String name, Object model) {
        template(name).apply(model)
    }

    private Template template(String name) {
        cacheLayout.enabled ? items.computeIfAbsent(name, this.&compile) : compile(name)
    }

    private Template compile(String name) {
        try {
            handlebars.compile(name)
        } catch (final Exception exception) {
            throw new RuntimeException(exception)
        }
    }
}
