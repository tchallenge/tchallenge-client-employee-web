(function (angular) {

    'use strict';

    angular
        .module('application.task')
        .service('taskBrokerHttpService', [
            '$http',
            'loggerService',
            'urlResolverService',
            TaskBrokerHttpService
        ]);

    function TaskBrokerHttpService($http,
                                   loggerService,
                                   urlResolverService) {

        var self = this;

        self.create = function (invoice) {
            throw 'not implemented'
        };

        self.get = function (id) {
            throw 'not implemented'
        };

        self.search = function (invoice) {
            throw 'not implemented'
        };
    }
})(window.angular);
