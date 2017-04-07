export class MenuService {
constructor(LoginService){
    console.log(LoginService)
    this.connected = LoginService.connected;

}
}