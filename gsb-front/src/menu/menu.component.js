class MenuController{
    constructor($cookies, $location, $rootScope){
       this.$cookies = $cookies;
       this.$location = $location;
        this.$rootScope= $rootScope;
        this.$rootScope.$on("status", (event, isAuth) => {
        this.isAuth = isAuth;
        this.currentUser = this.$cookies.get('user');
        console.log('rootscope con', this.isAuth)
        })
    }

    logout(){
        if(this.$cookies.get('user')){
        this.$cookies.remove('user');
        this.isAuth = false;
        this.$location.path("/");
        }
      
    }

     checkIfLogin(){
         if(currentUser)
              this.isAuth = true;
    }
   
    
}

export const Menu = {
    template : require('./menu.html'),
    controller: MenuController
}