const api ='http://localhost:3000/login';

export class LoginService{
    constructor($http){
        console.log($http)
        this.$http = $http;
        this.connected = false;
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
              this.connected = true;
              console.log('succes log',this)
              return userlog;
              
          }
        } )
    }
}