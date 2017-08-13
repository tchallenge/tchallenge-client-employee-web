package ru.tchallenge.client.employee.web.view.shared.model

import groovy.transform.PackageScope
import groovy.transform.TypeChecked

import javax.annotation.PostConstruct

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.context.annotation.ScopedProxyMode
import org.springframework.stereotype.Component

import com.fasterxml.jackson.databind.ObjectMapper

import ru.tchallenge.client.employee.web.setup.SetupLayout
import ru.tchallenge.client.employee.web.setup.SetupLayoutProviderService

@TypeChecked
@PackageScope
@Component
@Scope(scopeName = 'request', proxyMode = ScopedProxyMode.INTERFACES)
class ViewModelBuilderBean implements ViewModelBuilder {

    @Autowired
    SetupLayoutProviderService setupLayoutProviderService

    @Autowired
    ObjectMapper objectMapper

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
        SetupLayout setupLayout = setupLayoutProviderService.layout
        attributes = [
                setup: setupLayout,
                setupSerialized: objectMapper.writeValueAsString(setupLayout)
        ]
    }
}
