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

    // 根据ID查询
    $scope.findById = id => {
        sellerService.findById(id).success(res => {
            $scope.entity = res
        })
    }

    $scope.updateStatus = (sellerId,status)=>{
        sellerService.updateStatus(sellerId,status).success(res=>{
            if(res.success){
                $scope.getPage(0,10);
            }else{
                alert("失败")
            }
        })
    }

})