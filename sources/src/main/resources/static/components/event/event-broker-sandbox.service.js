(function (angular) {

    'use strict';

    angular
        .module('application.event')
        .service('eventBrokerSandboxService', [
            '$q',
            'jQuery',
            'loggerService',
            EventBrokerSandboxService
        ]);

    function EventBrokerSandboxService($q,
                                       jQuery,
                                       loggerService) {

        var self = this;

        var sandbox = [
            {
                id: 1
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
