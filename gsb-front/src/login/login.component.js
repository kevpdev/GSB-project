
class LoginController{
    constructor(LoginService, $location, $cookieStore){
        console.log($location)
        this.LoginService = LoginService;
        this.$location = $location;
        this.$cookieStore = $cookieStore;

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
               let userCookie = { id : user.id, nom : user.nom, prenom : user.prenom}
               this.$cookieStore.put('user', userCookie)
               console.log('cookies', this.$cookieStore.get('user'))
               this.$location.path('/cr')
           }

         
     })
     
    }
}

export const Login = {
    template : require("./login.html"),
    controller : LoginController
}