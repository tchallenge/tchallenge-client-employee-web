(function () {

    'use strict';

    angular
        .module('application.security')
        .service('authenticationService', [
            '$q',
            '$http',
            'applicationConfigurationService',
            'loggerService',
            'urlResolverService',
            'homeStateContextService',
            'authenticationContextService',
            AuthenticationService
        ]);

    function AuthenticationService($q,
                                   $http,
                                   applicationConfigurationService,
                                   loggerService,
                                   urlResolverService,
                                   homeStateContextService,
                                   authenticationContextService) {

        var self = this;

        self.authenticate = function (credential) {
            if (applicationConfigurationService.isSandboxMode()) {
                return authenticateInSandbox(credential)
            } else {
                return authenticateViaHttp(credential)
            }
        };

        self.deauthenticate = function () {
            authenticationContextService.reset();
            homeStateContextService.reset();
        };

        function authenticateInSandbox(credential) {

            var authentication = {
                account: {
                    employee: {
                        roles: [
                            'ADMIN'
                        ]
                    },
                    person: {
                        quickname: 'Имя пользователя'
                    }
                },
                token: {
                    id: 'PREDEFINED-EMPLOYEE-TOKEN'
                }
            };

            loggerService.info('authentication attempt succeeded');
            authenticationContextService.setAuthentication(authentication);

            return $q.when(authentication);
        }

        function authenticateViaHttp(credential) {

            var url = urlResolverService.resolveKernelServiceUrl('authentication');

            return $http

                .post(url, credential)

                .then(function (response) {
                    var authentication = response.data;
                    loggerService.info('authentication attempt succeeded');
                    authenticationContextService.setAuthentication(authentication);
                    return authentication;
                })

                .catch(function (response) {
                    loggerService.warn('authentication attempt failed');
                    throw response;
                });
        }
    }
})();
