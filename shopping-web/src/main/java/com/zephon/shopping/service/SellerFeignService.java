package com.zephon.shopping.service;

import com.zephon.http.Result;
import com.zephon.pojo.TbBrand;
import com.zephon.pojo.TbSeller;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.shopping.service
 * @date 2020/7/2 上午8:53
 * @Copyright ©
 */
@Component
@FeignClient(value="SELLERGOODS-SERVICE",contextId = "seller")
public interface SellerFeignService {
    @PostMapping("/seller/add")
    Result add(@RequestBody TbSeller seller);
    @GetMapping("/seller/{id}")
    TbSeller findById(@PathVariable("id")String id);
}
