package ru.tchallenge.client.employee.web.utility.template

import groovy.transform.TypeChecked

@TypeChecked
interface TemplateService {

    String render(String name, Object model)
}
