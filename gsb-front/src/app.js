import angular from 'angular'
import ngRoute from 'angular-route'
import ngCookies from 'angular-cookies'
import uiBoostrap from 'angular-ui-bootstrap'
import login from './login'
import menu from './menu'
import main from './main'
import {LoginService} from './service/login.service.js'
import {MenuService} from './service/menu.service.js'

angular.module('app', [ngRoute, uiBoostrap, login, menu, main, ngCookies])
    .service('LoginService', LoginService)
    .service('MenuService', MenuService)
    .config(function($routeProvider, $locationProvider) {
    $locationProvider.html5Mode(true);
    $routeProvider
        .when('/', {
            template: '<main></main>'
        })
         .when('/cr', {
            templateUrl: 'accueil.html'
        })
        .otherwise('/');



})
    .run(function(){
})