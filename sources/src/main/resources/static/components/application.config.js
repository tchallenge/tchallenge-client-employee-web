(function (angular) {

    'use strict';

    angular
        .module('application')
        .config(['$locationProvider', locationProviderConfigurer])
        .config(['$urlMatcherFactoryProvider', urlMatcherFactoryProviderConfigurer]);

    function locationProviderConfigurer($locationProvider) {
        $locationProvider.html5Mode(true);
    }

    function urlMatcherFactoryProviderConfigurer($urlMatcherFactoryProvider) {
        $urlMatcherFactoryProvider.strictMode(false);
    }
})(window.angular);
