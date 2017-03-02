import angular from 'angular'
import uiBoostrap from 'angular-ui-bootstrap'
import login from './login'



angular.module('app', [uiBoostrap, login])
.run(function(){
    console.log('salut');
})