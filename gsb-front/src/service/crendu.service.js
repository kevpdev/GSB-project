const api ="http://localhost:3001/crendus"
  
export class CrenduService{
    constructor($http){
        this.$http = $http;
    }

    findAll(){
        return this.$http.get(api)
        .then((response)=> response.data)
    }
}