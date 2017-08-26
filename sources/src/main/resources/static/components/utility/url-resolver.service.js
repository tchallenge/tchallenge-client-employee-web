(function (angular) {

    'use strict';

    angular
        .module('application.utility')
        .service('urlResolverService', [
            'applicationConfigurationService',
            UrlResolverService
        ]);

    function UrlResolverService(applicationConfigurationService) {

        var self = this;

        self.resolveKernelServiceUrl = function () {
            var configuration = applicationConfigurationService.getConfiguration();
            var url = [];
            url.push(configuration.location.service.complex);
            for (var i = 0; i < arguments.length; i++) {
                url.push(arguments[i]);
            }
            return url.join('/');
        };

        self.resolveUrl = function () {
            var configuration = applicationConfigurationService.getConfiguration();
            var url = [];
            url.push(configuration.location.client);
            for (var i = 0; i < arguments.length; i++) {
                url.push(arguments[i]);
            }
            return url.join('/');
        };
    }
})(window.angular);
