(function (angular) {

    'use strict';

    angular
        .module('application.security')
        .service('authenticationBrokerHttpService', [
            '$http',
            'loggerService',
            'urlResolverService',
            AuthenticationBrokerHttpService
        ]);

    function AuthenticationBrokerHttpService($http,
                                             loggerService,
                                             urlResolverService) {

        var self = this;

        self.authenticate = function (credentials) {
            throw 'not implemented'
        };
    }
})(window.angular);
