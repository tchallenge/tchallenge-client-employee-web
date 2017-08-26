(function (angular) {

    'use strict';

    angular
        .module('application.security')
        .service('authenticationBrokerSandboxService', [
            '$q',
            'jQuery',
            'loggerService',
            AuthenticationBrokerSandboxService
        ]);

    function AuthenticationBrokerSandboxService($q,
                                                jQuery,
                                                loggerService) {

        var self = this;

        var sandbox = {
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

        self.authenticate = function (creadentials) {
            return $q.when(deepCopy(sandbox));
        };

        function deepCopy(object) {
            return jQuery.extend(true, {}, object)
        }
    }
})(window.angular);
