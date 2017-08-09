const api ="http://localhost:3001/crendus"
  
export class CrenduService{
    constructor($http){
        this.$http = $http;
    }

    findAll(){
        return this.$http.get(api)
        .then((response)=> response.data)
    }

    saveCrendu(crendu){
        return this.$http.post(api, crendu)
        .then((response) => response.data)
    }


}