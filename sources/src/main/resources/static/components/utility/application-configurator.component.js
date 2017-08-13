(function () {

    'use strict';

    angular
        .module('application.utility')
        .component('applicationConfigurator', {
            bindings: {
                setupSerialized: '@'
            },
            controller: 'applicationConfiguratorController',
            controllerAs: 'self'
        });
})();
