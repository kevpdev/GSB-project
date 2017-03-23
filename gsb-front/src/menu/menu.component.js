class MenuController{
    constructor($cookieStore){
       this.$cookieStore = $cookieStore;
       console.log(this.$cookieStore)
    }
    
}

export const Menu = {
    template : require('./menu.html'),
    controller: MenuController
}