(function (angular) {

    'use strict';

    angular
        .module('application.workbook')
        .service('workbookBrokerHttpService', [
            '$http',
            'loggerService',
            'urlResolverService',
            WorkbookBrokerHttpService
        ]);

    function WorkbookBrokerHttpService($http,
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
