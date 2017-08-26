(function (angular) {

    'use strict';

    angular
        .module('application')
        .factory('jQuery', [
            '$window',
            jQueryFactory]);

    function jQueryFactory($window) {
        return $window.jQuery
    }
})(window.angular);
