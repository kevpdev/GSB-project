const api ='http://localhost:3000/visiteurs';

export class LoginService{
    constructor($http){
        this.$http = $http;
    }
  
    siginIn(user){
        console.log(user)
      return this.$http.post(api, user)
        .then(response => {
            console.log(response.data)
          if(!response.data){
              return null;
          }else{
              const userlog = response.data;
              console.log('connecté');
              return userlog;
              
          }
        } )
    }
}