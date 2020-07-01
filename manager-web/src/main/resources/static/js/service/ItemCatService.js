// service层
// 创建一个service，名字叫brandService
app.service('itemCatService',function($http){
    // 增加
    this.add = entity=>{
        return $http.post('/itemCat/add',entity)
    }
    // 修改
    this.update = entity =>{
        return $http.post('/itemCat/modify',entity)
    }
    // 删除
    this.delete = ids => {
        return $http.post('/itemCat/delete',ids)
    }
    // 根据ID查询
    this.findById = id => {
        return $http.get(`/itemCat/${id}`)
    }
    // 分页查询所有
    this.findAll = (page,size,searchEntity)=>{
        return $http.post(`/itemCat/list?page=${page}&size=${size}`,searchEntity)
    }
    // 根据父ID查询所有子分类
    this.findByParentId = parentId => {
        return $http.get("/itemCat/parent/"+parentId)
    }
})