package ru.tchallenge.client.employee.web.view.shared.render

import groovy.transform.PackageScope
import groovy.transform.TypeChecked

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import ru.tchallenge.client.employee.web.utility.template.TemplateService

@TypeChecked
@PackageScope
@Service
class ViewRenderServiceBean implements ViewRenderService {

    private static final String VIEW_TEMPLATE_FOLDER = 'view'

    @Autowired
    TemplateService templateService

    @Override
    String render(String template, Object model) {
        String templateName = viewTemplateName(template)
        templateService.render(templateName, model)
    }

    private static String viewTemplateName(String name) {
        [VIEW_TEMPLATE_FOLDER, name].join('/')
    }
}
