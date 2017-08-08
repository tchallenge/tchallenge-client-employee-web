package ru.tchallenge.client.employee.web.view.shared.model

import groovy.transform.PackageScope
import groovy.transform.TypeChecked

import javax.annotation.PostConstruct

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.context.annotation.ScopedProxyMode
import org.springframework.stereotype.Component

import ru.tchallenge.client.employee.web.setup.SetupProvider

@TypeChecked
@PackageScope
@Component
@Scope(scopeName = 'request', proxyMode = ScopedProxyMode.INTERFACES)
class ViewModelBuilderBean implements ViewModelBuilder {

    @Autowired
    SetupProvider setupProvider

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
        attributes = [
                setup: setupProvider.value
        ]
    }
}
