const api ='http://localhost:3001/medicaments';

export class MedocService{

    constructor($http){

   this.$http = $http;

    }
    
    findAllMedoc(){
        return this.$http.get(api)
        .then((response) => response.data)
    }
}