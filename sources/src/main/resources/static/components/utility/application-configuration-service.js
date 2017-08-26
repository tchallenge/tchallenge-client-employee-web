(function (angular) {

    'use strict';

    angular
        .module('application.utility')
        .service('applicationConfigurationService', [ApplicationConfigurationService]);

    function ApplicationConfigurationService() {

        var self = this;

        var configuration;

        self.getConfiguration = function () {
            return configuration;
        };

        self.setConfiguration = function (newConfiguration) {
            configuration = newConfiguration;
        };

        self.isSandboxMode = function () {
            return configuration.mode === 'sandbox'
        }
    }
})(window.angular);
