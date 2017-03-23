import angular from 'angular'
import ngRoute from 'angular-route'
import ngCookies from 'angular-cookies'
import uiBoostrap from 'angular-ui-bootstrap'
import login from './login'
import menu from './menu'
import {LoginService} from './service/login.service.js'

angular.module('app', [ngRoute, uiBoostrap, login, menu, ngCookies])
    .service('LoginService', LoginService)
    .config(function($routeProvider, $locationProvider) {
    $locationProvider.html5Mode(true);
    $routeProvider
        .when('/', {
            template: '<login></login>'
        })
         .when('/cr', {
            templateUrl: 'accueil.html'
        })
        .otherwise('/');



})
    .run(function(){
    console.log(LoginService)
    console.log('salut');
})