import angular from 'angular'
import {Cr} from './cr.component'
import {CrForm} from './crform.component'

export default angular.module('compteRendu', [])
.component('cr', Cr)
.component('crform', CrForm)
.name;
