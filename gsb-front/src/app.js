import angular from 'angular'
import ngRoute from 'angular-route'
import ngCookies from 'angular-cookies'
import uiBoostrap from 'angular-ui-bootstrap'
import login from './login'
import menu from './menu'
import main from './main'
import moment from 'moment'
import compteRendu from './cr'
import {LoginService} from './service/login.service.js'
import {MenuService} from './service/menu.service.js'
import {CrenduService} from './service/crendu.service.js'
import {MedocService} from './service/medoc.service.js'

angular.module('app', [ngRoute, uiBoostrap, login, menu, main, compteRendu, ngCookies])
    .service('LoginService', LoginService)
    .service('MenuService', MenuService)
    .service('CrenduService', CrenduService)
    .service('MedocService', MedocService)
    .config(function($routeProvider, $locationProvider) {
    $locationProvider.html5Mode(true);
    $routeProvider
        .when('/', {
            template: '<main></main>'
        })
         .when('/cr', {
            template: '<cr></cr>'
        })
        // .when('/cr/add',{
        //     template:'<crform></crform>'
        // })
        .when('/cr/edit/:id',{
            template:'Salut'
        })
        .otherwise('/');



})
    .constant('moment', require('moment-timezone'))
    .run(function(){
     
       var moment = require('moment');
      
       console.log( moment().format())
})