package com.zephon.manager.service;

import com.github.pagehelper.PageInfo;
import com.zephon.http.Result;
import com.zephon.pojo.TbSeller;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.manager.service
 * @date 2020/7/2 上午9:26
 * @Copyright ©
 */
@Component
@FeignClient(value="SELLERGOODS-SERVICE",contextId = "seller")
public interface SellerFeignService {
    @PostMapping("/seller/list")
    PageInfo<TbSeller> list(@RequestParam(value = "page",required = false,defaultValue = "1")int page,
                                   @RequestParam(value = "size",required = false,defaultValue = "0")int size,
                                   @RequestBody TbSeller seller);
    @GetMapping("/seller/{id}")
    TbSeller findById(@PathVariable("id")String id);

    @GetMapping("/seller/updateStatus")
    Result updateStatus(@RequestParam("sellerId") String sellerId,@RequestParam("status") String status);
}
