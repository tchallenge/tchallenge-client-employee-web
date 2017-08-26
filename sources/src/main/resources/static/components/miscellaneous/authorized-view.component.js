(function (angular) {

    'use strict';

    angular
        .module('application.miscellaneous')
        .component('authorizedView', {
            controller: 'authorizedViewController',
            controllerAs: 'self',
            templateUrl: 'static/components/miscellaneous/authorized-view.component.html'
        });
})(window.angular);
