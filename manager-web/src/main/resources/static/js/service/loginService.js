// service层
// 创建一个service，名字叫brandService
app.service('loginService',function($http){

    this.getInfo = ()=>{
        return $http.post('/login/info')
    }
})