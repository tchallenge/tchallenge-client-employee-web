(function (angular) {

    'use strict';

    angular
        .module('application.account')
        .service('accountBrokerHttpService', [
            '$http',
            'loggerService',
            'urlResolverService',
            AccountBrokerHttpService
        ]);

    function AccountBrokerHttpService($http,
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
