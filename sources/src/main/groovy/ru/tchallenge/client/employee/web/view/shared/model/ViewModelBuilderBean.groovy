package ru.tchallenge.client.employee.web.view.shared.model

import groovy.transform.PackageScope
import groovy.transform.TypeChecked

import javax.annotation.PostConstruct

import org.springframework.context.annotation.Scope
import org.springframework.context.annotation.ScopedProxyMode
import org.springframework.stereotype.Component

@TypeChecked
@PackageScope
@Component
@Scope(scopeName = 'request', proxyMode = ScopedProxyMode.INTERFACES)
class ViewModelBuilderBean implements ViewModelBuilder {

    private Map<String, ?> attributes

    @Override
    Object attribute(String name, Object value) {
        attributes.put(name, value)
    }

    @Override
    Map<String, ?> build() {
        attributes
    }

    @PostConstruct
    protected void init() {
        attributes = [:]
        // TODO: add default & system attributes (title, version, build, e.t.c.)
    }
}
