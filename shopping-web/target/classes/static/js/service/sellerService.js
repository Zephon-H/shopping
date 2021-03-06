// service层
// 创建一个service，名字叫brandService
app.service('sellerService',function($http){
    // 增加
    this.add = entity=>{
        return $http.post('/seller/add',entity)
    }
    // 修改
    this.update = entity =>{
        return $http.post('/seller/modify',entity)
    }
    // 删除
    this.delete = ids => {
        return $http.post('/seller/delete',ids)
    }
    // 根据ID查询
    this.findById = id => {
        return $http.get(`/seller/${id}`)
    }
    // 分页查询所有
    this.findAll = (page,size,searchEntity)=>{
        return $http.post(`/seller/list?page=${page}&size=${size}`,searchEntity)
    }
    // 查询所有
    this.findBrandList = () => {
        return $http.get("/seller/list")
    }
})