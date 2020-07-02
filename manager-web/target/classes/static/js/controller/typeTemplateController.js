// 创建一个controller
app.controller('typeTemplateController', function ($scope, $controller, typeTemplateService, brandService, specificationService) {
    // 让该controller继承另一个Controller
    $controller('baseController', {$scope: $scope})

    // 准备select2的数据
    // $scope.brandList = {
    //     data: [{id:1,text:'华为'},{id:2,text:'小米'}]
    // }
    console.log("before")
    // 获取所有品牌
    $scope.brandList = {data: []}
    $scope.findBrandList = () => {
        brandService.findBrandList().success(res => {
            $scope.brandList = {
                data: res
            }
            console.log($scope.brandList)
        })
    }
    $scope.specOptionList = {data: []}
    $scope.specList = function () {
        specificationService.findOptionList().success(res => {
            console.log(res)
            $scope.specOptionList = {
                data: res
            }
            console.log($scope.specOptionList)
        })
    }

    $scope.entity = {customAttributeItems: []}


    // 新增一行规格属性
    $scope.addTableRow = () => {
        $scope.entity.customAttributeItems.push({})
    }

    // 删除一行
    $scope.deleteTableRow = (index) => {
        $scope.entity.customAttributeItems.splice(index, 1)
    }

    $scope.getPage = (page, size) => {
        typeTemplateService.findAll(page, size, $scope.searchEntity).success(res => {
            $scope.list = res.list;
            console.log(res)
            $scope.paginationConf.totalItems = res.total
        })
    }
    console.log($scope.list)


    // 添加/修改数据
    $scope.save = () => {
        if ($scope.entity.id != null) {
            result = typeTemplateService.update($scope.entity)
        } else {
            result = typeTemplateService.add($scope.entity)
        }
        result.success(res => {
            if (res.success) {
                $scope.getPage(1, 10)
            } else {
                alert(res.message)
            }
        })
    }

    // 根据ID查询
    $scope.findById = id => {
        typeTemplateService.findById(id).success(res => {
            $scope.entity = res
            // 品牌转JSON
            $scope.entity.brandIds = angular.fromJson($scope.entity.brandIds)
            // 规格转JSON
            $scope.entity.specIds = angular.fromJson($scope.entity.specIds)
            // 扩展转JSON
            $scope.entity.customAttributeItems = angular.fromJson($scope.entity.customAttributeItems)
        })
    }

    $scope.delete = () => {
        typeTemplateService.delete($scope.selectIds).success(res => {
            if (res.success) {
                $scope.getPage(1, 10)
            } else {
                alert(res.message);
            }
        })
    }

    // 讲JSON数据提取拼接一个字符串
    $scope.json2str = jsonstr=>{
        let json = JSON.parse(jsonstr);
        let res = ''
        // 循环提取
        for (let i = 0; i < json.length; i++) {
            if(i>0) res += ","
            res += json[i]['text']
        }
        return res;
    }

})