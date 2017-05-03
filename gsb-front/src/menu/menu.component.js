class MenuController{
    constructor($cookies, $location, $rootScope){
        console.log('menucontroller')
       this.$cookies = $cookies;
       this.$location = $location;
    //     this.$rootScope= $rootScope;
    //     this.$rootScope.$on("status", (event, isAuth) => {
    //     console.log('rootscope con', isAuth);  
    //     this.isAuth = isAuth;
    //     this.currentUser = this.$cookies.get('user');
    // })
    this.checkIfLogin();
      console.log('rootscope con', this.isAuth); 
  
    }

    logout(){
        if(this.$cookies.get('user')){
        this.$cookies.remove('user');
        this.isAuth = false;
        this.$location.path("/");
        }
      
    }

     checkIfLogin(){
         if(this.$cookies.get('user'))
              this.isAuth = true;
    }
   
    
}

export const Menu = {
    template : require('./menu.html'),
    controller: MenuController
}