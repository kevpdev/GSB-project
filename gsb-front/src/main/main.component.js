class MainController{

    constructor($cookies){
        this.$cookies = $cookies;
    
      this.isAuth = false;
         this.checkIsAuth();
    }
    // $onInit(){
    //         this.isAuth = false;
    //      this.checkIsAuth();
    // }

     checkIsAuth(){
           console.log('auth chek', this.isAuth)
         if(this.$cookies.get('user')){
            this.isAuth = true;
            console.log('auth check', this.isAuth)
         }

     }
}

export const Main = {
  template : require("./main.html"),
controller : MainController
}