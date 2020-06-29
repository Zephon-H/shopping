// service层
// 创建一个service，名字叫brandService
app.service('brandService',function($http){
    // 增加
    this.add = entity=>{
        return $http.post('/brand/add',entity)
    }
    // 修改
    this.update = entity =>{
        return $http.post('/brand/modify',entity)
    }
    // 删除
    this.delete = ids => {
        return $http.post('/brand/delete',ids)
    }
    // 根据ID查询
    this.findById = id => {
        return $http.get(`/brand/${id}`)
    }
    // 分页查询所有
    this.findAll = (page,size,searchEntity)=>{
        return $http.post(`/brand/list?page=${page}&size=${size}`,searchEntity)
    }
})