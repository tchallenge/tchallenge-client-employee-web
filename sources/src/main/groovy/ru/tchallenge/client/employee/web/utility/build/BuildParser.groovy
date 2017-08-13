package ru.tchallenge.client.employee.web.utility.build

import groovy.transform.TypeChecked

import java.time.Instant

@TypeChecked
class BuildParser {

    static Build load(String filename) {
        Properties properties = new Properties()
        File file = new File(path(filename))
        properties.load(file.newInputStream())
        parse(properties)
    }

    static Build parse(Properties properties) {
        new Build(
                id: properties.getProperty('id'),
                timestamp: Instant.parse(properties.getProperty('timestamp')),
                version: properties.getProperty('version')
        )
    }

    private static String path(String filename) {
        Thread.currentThread()
                .getContextClassLoader()
                .getResource(filename)
                .getPath()
    }
}
