(function (angular) {

    'use strict';

    angular
        .module('application.account')
        .service('accountBrokerSandboxService', [
            '$q',
            'jQuery',
            'loggerService',
            AccountBrokerSandboxService
        ]);

    function AccountBrokerSandboxService($q,
                                         jQuery,
                                         loggerService) {

        var self = this;

        var sandbox = [
            {
                id: 1,
                login: 'ipetrov',
                email: 'ipetrov@some-mail.net',
                person: {
                    quickname: 'Иван'
                },
                employee: {
                    roles: [
                        'ADMIN'
                    ]
                },
                realm: 'EMPLOYEE',
                status: 'APPROVED'
            }
        ];

        self.create = function (invoice) {
            throw 'not implemented'
        };

        self.get = function (id) {
            var result = sandbox[0];
            return $q.when(deepCopy(result));
        };

        self.search = function (invoice) {
            var result = {
                items: sandbox,
                total: sandbox.size
            };
            return $q.when(deepCopy(result));
        };

        function deepCopy(object) {
            return jQuery.extend(true, {}, object)
        }
    }
})(window.angular);
