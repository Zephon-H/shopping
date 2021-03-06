package com.zephon.sellergoods.controller;

import com.zephon.http.Result;
import com.zephon.pojo.TbBrand;
import com.zephon.pojo.TbItemCat;
import com.zephon.sellergoods.service.ItemCatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.sellergoods.controller
 * @date 2020/7/1 下午3:14
 * @Copyright ©
 */
@RestController
@RequestMapping("/itemCat")
public class ItemCatController {
    @Resource
    private ItemCatService itemCatService;

    @GetMapping("/parent/{id}")
    public List<TbItemCat> findByParentId(@PathVariable("id") Long id){
        return  itemCatService.findByParentId(id);
    }
    @PostMapping("/add")
    public Result add(@RequestBody TbItemCat itemCat){
        Map<String,Object> result = new HashMap<>();
        try {
            int count = itemCatService.add(itemCat);
            if(count>0){
                // 添加成功
                return new Result(true,"增加成功");
            }
        } catch (Exception e) {
        }
        // 添加失败
        return new Result(false,"增加失败");
    }
    @GetMapping("/{id}")
    public TbItemCat findById(@PathVariable("id")Long id){
        return itemCatService.findById(id);
    }

    @PostMapping("/modify")
    public Result modify(@RequestBody TbItemCat itemCat){
        try {
            int count = itemCatService.updateById(itemCat);
            if(count>0){
                return new Result(true);
            }
        } catch (Exception e) {

        }
        return new Result(false,"修改失败");
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody List<Long> ids){
        try {
            int count = itemCatService.deleteByIds(ids);
            if(count>0){
                return new Result(true);
            }
        } catch (Exception e) {
        }
        return new Result(false,"删除失败");
    }

}
