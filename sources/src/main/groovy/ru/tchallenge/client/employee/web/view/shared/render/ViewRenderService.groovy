package ru.tchallenge.client.employee.web.view.shared.render

import groovy.transform.TypeChecked

@TypeChecked
interface ViewRenderService {

    String render(String template, Object model)
}
