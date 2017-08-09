package ru.tchallenge.client.employee.web.view.setup

import groovy.transform.PackageScope
import groovy.transform.TypeChecked

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

import ru.tchallenge.client.employee.web.view.shared.GenericViewRouterBean

@TypeChecked
@PackageScope
@RestController
@RequestMapping(path = '/setup')
class SetupViewRouterBean extends GenericViewRouterBean {

    @RequestMapping(method = RequestMethod.GET)
    String get() {
        render('setup')
    }
}
