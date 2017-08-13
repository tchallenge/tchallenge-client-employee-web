(function () {

    'use strict';

    angular
        .module('application.utility')
        .service('loggerService', [
            'applicationConfigurationService',
            LoggerService
        ]);

    function LoggerService(applicationConfigurationService) {

        var self = this;

        var levels = ['DEBUG, INFO, WARN, ERROR'];

        var defaultConfiguration = {
            level: 'INFO'
        };

        self.debug = function (message) {
            self.log('DEBUG', message);
        };

        self.info = function (message) {
            self.log('INFO', message);
        };

        self.warn = function (message) {
            self.log('WARN', message);
        };

        self.error = function (message) {
            self.log('ERROR', message);
        };

        self.log = function (level, message) {
            if (shouldLog(level)) {
                if (level === 'ERROR') {
                    console.error(message);
                } else if (level === 'WARN') {
                    console.warn(message)
                } else {
                    console.info(message);
                }
            }
        };

        function shouldLog(level) {
            var configuration = applicationConfigurationService.getConfiguration().logging;
            var levelIndex = levels.indexOf(level);
            if (configuration && configuration.level) {
                return levelIndex >= levels.indexOf(configuration.level);
            } else {
                return levelIndex >= levels.indexOf(defaultConfiguration.level);
            }
        }
    }
})();
