const visiteurs ={
    "email" : "d",
    "motDePasse" : "hello"
};
class LoginController{
    constructor(LoginService){
        console.log('je suis ici')
        this.LoginService = LoginService;
        this.test = 'test';

    }

    authForm(form, user){
        if(form.$invalid){
            console.log('erreur')
            return;
        } 

     this.LoginService.siginIn(user)
     .then(user => {
           if(!user)
           this.message ="utilisateur ou mot de passe incorrecte";
          console.log('----> erreur')
         
     })
     
    }
}

export const Login = {
    template : require("./login.html"),
    controller : LoginController
}