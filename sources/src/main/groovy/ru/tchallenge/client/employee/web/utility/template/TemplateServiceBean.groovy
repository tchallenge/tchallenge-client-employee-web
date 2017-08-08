package ru.tchallenge.client.employee.web.utility.template

import groovy.transform.PackageScope
import groovy.transform.TypeChecked

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@TypeChecked
@PackageScope
@Service
class TemplateServiceBean implements TemplateService {

    @Autowired
    TemplateCache cache

    @Override
    String render(String name, Object model) {
        cache.get(name).apply(model)
    }
}
