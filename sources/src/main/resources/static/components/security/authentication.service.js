(function (angular) {

    'use strict';

    angular
        .module('application.security')
        .service('authenticationService', [
            'loggerService',
            'homeStateContextService',
            'authenticationContextService',
            'applicationConfigurationService',
            'authenticationBrokerHttpService',
            'authenticationBrokerSandboxService',
            AuthenticationService
        ]);

    function AuthenticationService(loggerService,
                                   homeStateContextService,
                                   authenticationContextService,
                                   applicationConfigurationService,
                                   authenticationBrokerHttpService,
                                   authenticationBrokerSandboxService) {

        var self = this;

        self.authenticate = function (credential) {
            return getAuthenticationBroker()
                .authenticate(credential)
                .then(function (authentication) {
                    loggerService.info('authentication attempt succeeded');
                    authenticationContextService.setAuthentication(authentication);
                    return authentication;
                })
                .catch(function (exception) {
                    loggerService.warn('authentication attempt failed');
                    throw exception;
                });
        };

        self.deauthenticate = function () {
            authenticationContextService.reset();
            homeStateContextService.reset();
        };

        function getAuthenticationBroker() {
            return applicationConfigurationService.isSandboxMode() ? authenticationBrokerSandboxService : authenticationBrokerHttpService;
        }
    }
})(window.angular);
