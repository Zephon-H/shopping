// service层
// 创建一个service，名字叫brandService
app.service('typeTemplateService',function($http){
    // 增加
    this.add = entity=>{
        return $http.post('/typeTemplate/add',entity)
    }
    // 修改
    this.update = entity =>{
        return $http.post('/typeTemplate/modify',entity)
    }
    // 删除
    this.delete = ids => {
        return $http.post('/typeTemplate/delete',ids)
    }
    // 根据ID查询
    this.findById = id => {
        return $http.get(`/typeTemplate/${id}`)
    }
    // 分页查询所有
    this.findAll = (page,size,searchEntity)=>{
        return $http.post(`/typeTemplate/list?page=${page}&size=${size}`,searchEntity)
    }
    this.findOptionList = ()=>{
        return $http.get("/typeTemplate/list")
    }
})