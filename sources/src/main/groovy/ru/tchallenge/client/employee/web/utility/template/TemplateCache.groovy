package ru.tchallenge.client.employee.web.utility.template

import groovy.transform.TypeChecked

import com.github.jknack.handlebars.Template

@TypeChecked
interface TemplateCache {

    Template get(String name)
}
