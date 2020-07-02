// 创建一个controller
app.controller('sellerController', function ($scope,$controller, sellerService) {
    // 让该controller继承另一个Controller
    $controller('baseController',{$scope:$scope})

    $scope.getPage = (page, size) => {
        sellerService.findAll(page,size,$scope.searchEntity).success(res=>{
            $scope.list = res.list;
            $scope.paginationConf.totalItems = res.total
        })
    }

    // 添加/修改数据
    $scope.save = () => {
        sellerService.add($scope.entity).success(res=>{
            if(res.success){
                location.href="shoplogin.html"
            }else{
                alert(res.message)
            }
        })
    }

    // 根据ID查询
    $scope.findById = id => {
        sellerService.findById(id).success(res => {
            $scope.entity = res
        })
    }

    $scope.delete = () => {
        sellerService.delete($scope.selectIds).success(res=>{
            if(res.success){
                $scope.getPage(1,10)
            }else{
                alert(res.message);
            }
        })
    }

})