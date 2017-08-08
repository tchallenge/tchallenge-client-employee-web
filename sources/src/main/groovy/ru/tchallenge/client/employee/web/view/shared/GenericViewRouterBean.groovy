package ru.tchallenge.client.employee.web.view.shared

import groovy.transform.TypeChecked

import org.springframework.beans.factory.annotation.Autowired

import ru.tchallenge.client.employee.web.view.shared.model.ViewModelBuilder
import ru.tchallenge.client.employee.web.view.shared.render.ViewRenderService

@TypeChecked
abstract class GenericViewRouterBean {

    @Autowired
    ViewModelBuilder viewModelBuilder

    @Autowired
    ViewRenderService viewRenderService

    protected Object attribute(String name, Object value) {
        viewModelBuilder.attribute(name, value)
    }

    protected String render(String template) {
        Object model = viewModelBuilder.build()
        viewRenderService.render(template, model)
    }
}
