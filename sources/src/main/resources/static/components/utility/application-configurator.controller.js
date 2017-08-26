(function (angular) {

    'use strict';

    angular
        .module('application.utility')
        .controller('applicationConfiguratorController', [
            'applicationConfigurationService',
            ApplicationConfiguratorController]);

    function ApplicationConfiguratorController(applicationConfigurationService) {

        var self = this;

        self.$onInit = function () {

            var setup = JSON.parse(self.setupSerialized);
            applicationConfigurationService.setConfiguration(setup);
        };
    }
})(window.angular);
