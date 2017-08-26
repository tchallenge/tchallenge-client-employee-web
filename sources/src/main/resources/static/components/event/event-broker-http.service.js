(function (angular) {

    'use strict';

    angular
        .module('application.event')
        .service('eventBrokerHttpService', [
            '$http',
            'loggerService',
            'urlResolverService',
            EventBrokerHttpService
        ]);

    function EventBrokerHttpService($http,
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
