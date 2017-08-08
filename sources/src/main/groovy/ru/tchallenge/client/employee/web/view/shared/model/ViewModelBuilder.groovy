package ru.tchallenge.client.employee.web.view.shared.model

import groovy.transform.TypeChecked

@TypeChecked
interface ViewModelBuilder {

    Object attribute(String name, Object value)

    Map<String, ?> build()
}
