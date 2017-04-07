
class LoginController{
    constructor(LoginService, $location, $cookies, $rootScope){
        this.LoginService = LoginService;
        this.$location = $location;
        this.$cookies = $cookies;
        this.isAuth = false;
        this.checkIfLogin();
        this.$rootScope = $rootScope;

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
               let userCookie = { id : user.id, nom : user.nom, prenom : user.prenom}
               this.$cookies.putObject('user', userCookie)
               this.isAuth = true;
               this.$rootScope.$emit("status", this.isAuth)
               this.$location.path('/cr')
           }

         
     })
     
    }

    checkIfLogin(){
         if(this.$cookies.get('user')){
            // this.$rootScope.$emit("status", this.isAuth)
             this.$location.path('/cr')
         }
               
    }
}

export const Login = {
    template : require("./login.html"),
    controller : LoginController
}