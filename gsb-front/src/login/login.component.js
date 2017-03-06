
class LoginController{
    constructor(LoginService, $location){
        console.log($location)
        this.LoginService = LoginService;
        this.$location = $location;

    }

    authForm(form, user){
        console.log(user)
        if(form.$invalid){
            console.log('erreur')
            return;
        } 

     this.LoginService.siginIn(user)
     .then(user => {
         console.log(user)
           if(!user){
            this.message ="utilisateur ou mot de passe incorrecte";
            console.log('----> erreur')
           }else{
               console.log('connecté')
               this.$location.path('/accueil')
           }

         
     })
     
    }
}

export const Login = {
    template : require("./login.html"),
    controller : LoginController
}