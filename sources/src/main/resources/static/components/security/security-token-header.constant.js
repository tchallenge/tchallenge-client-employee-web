(function (angular) {

    'use strict';

    angular
        .module('application.security')
        .constant('securityTokenHeader', 'T-Challenge-Security-Token');
})(window.angular);
