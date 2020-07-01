// 创建一个controller
app.controller('indexController', function ($scope, loginService) {
    $scope.info = function () {
        loginService.getInfo().success(res=>{
            $scope.loginName = res.loginName
            $scope.loginTime = res.loginTime
        })
    }

})