package com.zephon.manager.service;

import com.github.pagehelper.PageInfo;
import com.zephon.http.Result;
import com.zephon.pojo.TbBrand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.manager.service
 * @date 2020/6/24 下午7:11
 * @Copyright ©
 */
@Component
@FeignClient(value="SELLERGOODS-SERVICE",contextId = "brand")
public interface BrandFeignService {
    @GetMapping("/brand/list")
    List<TbBrand> list();

    @PostMapping("/brand/list")
    PageInfo<TbBrand> list(@RequestParam(value = "page",required = false,defaultValue = "1")int page,
                              @RequestParam(value = "size",required = false,defaultValue = "0")int size,
                              @RequestBody TbBrand brand);
    @PostMapping("/brand/add")
    Result add(@RequestBody TbBrand brand);

    @GetMapping("/brand/{id}")
    TbBrand findById(@PathVariable("id")Long id);

    @PostMapping("/brand/modify")
    Result modify(@RequestBody TbBrand brand);

    @PostMapping("/brand/delete")
    Result delete(@RequestBody List<Long> ids);
}