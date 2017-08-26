(function (angular) {

    'use strict';

    angular
        .module('application.menu', [
            'ui.router',
            'application.security',
            'application.utility'
        ]);
})(window.angular);
