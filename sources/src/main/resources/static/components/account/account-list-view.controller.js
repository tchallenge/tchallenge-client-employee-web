(function (angular) {

    'use strict';

    angular
        .module('application.account')
        .controller('accountListViewController', [
            'accountService',
            AccountListViewController
        ]);

    function AccountListViewController(accountService) {

        var self = this;

        var defaultFilter = {

        };

        var emptySearchResult = {

        };

        function init() {
            reset();
            search();
        }

        function reset() {
            self.filter = defaultFilter;
            self.searchResult = emptySearchResult;
        }

        function search() {
            accountService
                .search(self.filter)
                .then(function (result) {
                    self.searchResult = result;
                });
        }

        self.$onInit = function () {
            init();
        };

        self.reset = function () {
            reset();
        };

        self.search = function () {
            search();
        };
    }
})(window.angular);
