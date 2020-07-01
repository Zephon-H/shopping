// 创建一个controller
app.controller('itemCatController', function ($scope,$controller, itemCatService,typeTemplateService) {
    // 让该controller继承另一个Controller
    $controller('baseController',{$scope:$scope})

    // 添加/修改数据
    $scope.save = () => {
        $scope.entity.parentId = $scope.parent.id;
        $scope.entity.typeId = $scope.typeTemplate.id;
        console.log($scope.entity)
        if($scope.entity.id!=null){
            result = itemCatService.update($scope.entity)
        }else{
            result = itemCatService.add($scope.entity)
        }
        result.success(res=>{
            if(res.success){
                $scope.findByParentId(0)
            }else{
                alert(res.message)
            }
        })
    }

    // 根据ID查询
    $scope.findById = id => {
        itemCatService.findById(id).success(res => {
            $scope.entity = res
            $scope.typeTemplate = $scope.typeTemplateOptionList.data.find(x=>x.id===res.typeId)
        })
    }

    $scope.delete = () => {
        itemCatService.delete($scope.selectIds).success(res=>{
            if(res.success){
                $scope.findByParentId(0)
            }else{
                alert(res.message);
            }
        })
    }

    // 分类等级
    $scope.grand = 1;
    // 面包屑
    $scope.entity_1 = {name:'顶级分类',id:0}
    $scope.entity_2 = null
    $scope.entity_3 = null

    $scope.loadChild = function(itemCat){
        $scope.grand++;
        if($scope.grand===2){
            $scope.entity_2 = itemCat
        }else if($scope.grand === 3){
            $scope.entity_3 = itemCat
        }
    }

    // 根据父ID查询所有子类
    $scope.findByParentId = parentId =>{
        itemCatService.findByParentId(parentId).success(res => {
            $scope.list = res
        })
        $scope.findParentById(parentId)
    }
    $scope.parent = {name:"顶级分类",id:0}
    $scope.findParentById = id => {
        if(id===0) {
            $scope.parent.name = "顶级分类"
            return
        }
        itemCatService.findById(id).success(res => {
            $scope.parent = res;
        })
    }

    $scope.typeTemplateOptionList = {data:[]}
    $scope.findTypeTemplateOptionList = () => {
        typeTemplateService.findOptionList().success(res=>{
            for (let i = 0; i < res.length; i++) {
                $scope.typeTemplateOptionList.data.push({id:res[i].id,text:res[i].name})

            }
        })
    }

})