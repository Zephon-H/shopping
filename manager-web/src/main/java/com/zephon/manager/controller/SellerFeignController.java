package com.zephon.manager.controller;

import com.github.pagehelper.PageInfo;
import com.zephon.http.Result;
import com.zephon.manager.service.SellerFeignService;
import com.zephon.pojo.TbSeller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.manager.controller
 * @date 2020/7/2 上午9:26
 * @Copyright ©
 */
@RestController
@RequestMapping("/seller")
public class SellerFeignController {
    @Resource
    private SellerFeignService sellerFeignService;
    @PostMapping("/list")
    public PageInfo<TbSeller> list(@RequestParam(value = "page",required = false,defaultValue = "1")int page,
                                   @RequestParam(value = "size",required = false,defaultValue = "0")int size,
                                   @RequestBody TbSeller seller){
        return sellerFeignService.list(page,size,seller);
    }

    @GetMapping("/{id}")
    public TbSeller findById(@PathVariable("id")String id){
        return sellerFeignService.findById(id);
    }

    @GetMapping("/updateStatus")
    public Result updateStatus(@RequestParam("sellerId") String sellerId,@RequestParam("status") String status){
        return sellerFeignService.updateStatus(sellerId,status);
    }
}
