import angular from 'angular'
import {Login} from './login'

export default angular.module('login', [])
.component('login', Login)
.name;
