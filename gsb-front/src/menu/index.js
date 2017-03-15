import angular from 'angular'
import {Menu} from './menu.component'

export default angular.module('menu', [])
    .component('menu', Menu)
    .name;