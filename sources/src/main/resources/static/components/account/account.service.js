(function (angular) {

    'use strict';

    angular
        .module('application.account')
        .service('accountService', [
            'applicationConfigurationService',
            'accountBrokerHttpService',
            'accountBrokerSandboxService',
            AccountService
        ]);

    function AccountService(applicationConfigurationService,
                            accountBrokerHttpService,
                            accountBrokerSandboxService) {

        var self = this;

        self.get = function (id) {
            return getAccountBroker().get(id);
        };

        self.search = function (invoice) {
            return getAccountBroker().search(invoice);
        };

        function getAccountBroker() {
            return applicationConfigurationService.isSandboxMode() ? accountBrokerSandboxService : accountBrokerHttpService;
        }
    }
})(window.angular);
