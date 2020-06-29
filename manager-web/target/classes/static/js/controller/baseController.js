app.controller('baseController',function($scope){
    $scope.selectIds = []
    $scope.searchEntity = {}

    $scope.updateSelection = ($event,id) => {
        if($event.target.checked){
            $scope.selectIds.push(id);
        }else{
            let index = $scope.selectIds.indexOf(id)
            $scope.selectIds.splice(index,1);
        }
    }

    // 分页控件配置
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function () {
            // 监控paginationConf参数的变化，当分页参数发生变化，可执行分页查询
            $scope.getPage($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage)
        }
    }
})