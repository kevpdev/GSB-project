import angular from 'angular'
import uiBoostrap from 'angular-ui-bootstrap'
import login from './login'
import {LoginService} from './service/login.service.js'



angular.module('app', [uiBoostrap, login])
.service('LoginService', LoginService)

.run(function(){
    console.log(LoginService)
    console.log('salut');
})