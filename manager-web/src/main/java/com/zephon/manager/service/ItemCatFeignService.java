package com.zephon.manager.service;

import com.zephon.http.Result;
import com.zephon.pojo.TbItemCat;
import com.zephon.pojo.TbTypeTemplate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.manager.service
 * @date 2020/7/1 下午3:16
 * @Copyright ©
 */
@Component
@FeignClient(value="SELLERGOODS-SERVICE",contextId = "itemCat")
public interface ItemCatFeignService {
    @GetMapping("/itemCat/parent/{id}")
    List<TbItemCat> findByParentId(@PathVariable("id") Long id);

    @PostMapping("/itemCat/add")
    Result add(@RequestBody TbItemCat itemCat);

    @GetMapping("/itemCat/{id}")
    TbItemCat findById(@PathVariable("id")Long id);
    @PostMapping("/itemCat/modify")
    Result modify(@RequestBody TbItemCat itemCat);
    @PostMapping("/itemCat/delete")
    Result delete(@RequestBody List<Long> ids);

}