// 创建一个controller
app.controller('brandController', function ($scope,$controller, brandService) {
    // 让该controller继承另一个Controller
    $controller('baseController',{$scope:$scope})

    $scope.getPage = (page, size) => {
        brandService.findAll(page,size,$scope.searchEntity).success(res=>{
            $scope.list = res.list;
            $scope.paginationConf.totalItems = res.total
        })
    }

    // 添加/修改数据
    $scope.save = () => {
        console.log($scope.entity.id)
        if($scope.entity.id!=null){
            result = brandService.update($scope.entity)
        }else{
            result = brandService.add($scope.entity)
        }
        result.success(res=>{
            if(res.success){
                $scope.getPage(1,10)
            }else{
                alert(res.message)
            }
        })
    }

    // 根据ID查询
    $scope.findById = id => {
        brandService.findById(id).success(res => {
            $scope.entity = res
        })
    }

    $scope.delete = () => {
        brandService.delete($scope.selectIds).success(res=>{
            if(res.success){
                $scope.getPage(1,10)
            }else{
                alert(res.message);
            }
        })
    }

})