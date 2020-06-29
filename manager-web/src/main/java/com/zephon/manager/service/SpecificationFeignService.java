package com.zephon.manager.service;

import com.github.pagehelper.PageInfo;
import com.zephon.http.Result;
import com.zephon.pojo.TbBrand;
import com.zephon.pojo.TbSpecification;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.manager.service
 * @date 2020/6/29 下午4:24
 * @Copyright ©
 */
@Component
@FeignClient(value = "SELLERGOODS-SERVICE",contextId = "specification")
public interface SpecificationFeignService {
    @PostMapping("/specification/list")
    PageInfo<TbSpecification> findAll(@RequestParam(value = "page",required = false,defaultValue = "1")int page,
                              @RequestParam(value = "size",required = false,defaultValue = "0")int size,
                              @RequestBody TbSpecification specification);
    @PostMapping("/specification/add")
    Result add(@RequestBody TbSpecification specification);
}