package com.zephon.manager.controller;

import com.zephon.http.Result;
import com.zephon.manager.service.ItemCatFeignService;
import com.zephon.pojo.TbItemCat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.manager.controller
 * @date 2020/7/1 下午3:16
 * @Copyright ©
 */
@RestController
@RequestMapping("/itemCat")
public class ItemCatFeignController {
    @Resource
    private ItemCatFeignService itemCatFeignService;
    @GetMapping("/parent/{id}")
    List<TbItemCat> findByParentId(@PathVariable("id") Long id){
        return itemCatFeignService.findByParentId(id);
    }

    @PostMapping("/add")
    Result add(@RequestBody TbItemCat itemCat){
        return itemCatFeignService.add(itemCat);
    }

    @GetMapping("/{id}")
    TbItemCat findById(@PathVariable("id")Long id){
        return itemCatFeignService.findById(id);
    }
    @PostMapping("/modify")
    Result modify(@RequestBody TbItemCat itemCat){
        return itemCatFeignService.modify(itemCat);
    }
    @PostMapping("/delete")
    Result delete(@RequestBody List<Long> ids){
        return itemCatFeignService.delete(ids);
    }
}
