package com.zephon.shopping.controller;

import com.zephon.http.Result;
import com.zephon.pojo.TbBrand;
import com.zephon.pojo.TbSeller;
import com.zephon.shopping.service.SellerFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.shopping.controller
 * @date 2020/7/2 上午8:53
 * @Copyright ©
 */
@RestController
@RequestMapping("/seller")
public class SellerFeignController {
    @Resource
    private SellerFeignService sellerFeignService;

    @PostMapping("/add")
    public Result add(@RequestBody TbSeller seller) {
        return sellerFeignService.add(seller);
    }

    @GetMapping("/{id}")
    public TbSeller findById(@PathVariable("id")String id){
        return sellerFeignService.findById(id);
    }
}
