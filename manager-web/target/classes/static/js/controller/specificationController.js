// 创建一个controller
app.controller('specificationController', function ($scope,$controller, specificationService) {
    // 让该controller继承另一个Controller
    $controller('baseController',{$scope:$scope})

    // 定义一个集合，用于存储所有规格选项存入entity对象中
    // $scope.specList = [{},{}]
    // $scope.entity = {specificationOptionList:[]}

    // 新增一行规格属性
    $scope.addTableRow = () => {
        $scope.entity.specificationOptionList.push({})
    }

    // 删除一行
    $scope.deleteTableRow = (index) => {
        $scope.entity.specificationOptionList.splice(index,1)
    }

    $scope.getPage = (page, size) => {
        specificationService.findAll(page,size,$scope.searchEntity).success(res=>{
            $scope.list = res.list;
            console.log(res)
            $scope.paginationConf.totalItems = res.total
        })
    }

    // 添加/修改数据
    $scope.save = () => {
        console.log($scope.entity)
        if($scope.entity.id!=null){
            result = specificationService.update($scope.entity)
        }else{
            result = specificationService.add($scope.entity)
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
        specificationService.findById(id).success(res => {
            $scope.entity = res
        })
    }

    $scope.delete = () => {
        specificationService.delete($scope.selectIds).success(res=>{
            if(res.success){
                $scope.getPage(1,10)
            }else{
                alert(res.message);
            }
        })
    }

})