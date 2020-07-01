package com.zephon.manager.controller;

import com.github.pagehelper.PageInfo;
import com.zephon.http.Result;
import com.zephon.manager.service.BrandFeignService;
import com.zephon.pojo.TbBrand;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.manager.controller
 * @date 2020/6/24 下午7:11
 * @Copyright ©
 */
@RestController
@RequestMapping("/brand")
public class BrandFeignController {
    @Resource
    private BrandFeignService brandService;

    @GetMapping("/list")
    public List<TbBrand> list(){
        return brandService.list();
    }

    @PostMapping("/list")
    public PageInfo<TbBrand> list(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                  @RequestParam(value = "size",required = false,defaultValue = "0")int size,
                                  @RequestBody TbBrand brand){
        System.out.println(brand);
        return brandService.list(page, size,brand);
    }

    @PostMapping("/add")
    public Result add(@RequestBody TbBrand brand) {
        return brandService.add(brand);
    }

    @GetMapping("/{id}")
    public TbBrand findById(@PathVariable("id")Long id){
        return brandService.findById(id);
    }

    @PostMapping("/modify")
    public Result modify(@RequestBody TbBrand brand){
        return brandService.modify(brand);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody List<Long> ids){
        return brandService.delete(ids);
    }
}