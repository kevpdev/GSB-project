import angular from 'angular'
import {Login} from './login.component'

export default angular.module('login', [])
.component('login', Login)
.name;
