(function (angular) {

    'use strict';

    angular
        .module('application.account')
        .controller('accountSectionViewController', [
            'menuConfiguratorService',
            AccountSectionViewController
        ]);

    function AccountSectionViewController(menuConfiguratorService) {

        var self = this;

        self.$onInit = function () {
            menuConfiguratorService.updateMenuState('accountSection');
        };
    }
})(window.angular);
