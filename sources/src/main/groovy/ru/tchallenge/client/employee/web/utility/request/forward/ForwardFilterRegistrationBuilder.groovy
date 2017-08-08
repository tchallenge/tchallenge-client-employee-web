package ru.tchallenge.client.employee.web.utility.request.forward

import groovy.transform.TypeChecked

import org.springframework.boot.web.servlet.FilterRegistrationBean

@TypeChecked
class ForwardFilterRegistrationBuilder {

    Collection<String> exclusions
    Integer order
    String scope
    String target

    FilterRegistrationBean build() {
        FilterRegistrationBean result = new FilterRegistrationBean()
        result.setFilter(new ForwardFilter(
                exclusions: [target] + (exclusions ?: [] as Collection<String>),
                target: target
        ))
        result.addUrlPatterns(scope)
        result.setName(UUID.randomUUID().toString())
        result.setOrder(order)
        result
    }
}
