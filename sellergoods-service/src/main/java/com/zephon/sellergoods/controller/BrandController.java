package com.zephon.sellergoods.controller;

import com.github.pagehelper.PageInfo;
import com.zephon.http.Result;
import com.zephon.pojo.TbBrand;
import com.zephon.sellergoods.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.sellergoods.controller
 * @date 2020/6/24 下午3:04
 * @Copyright ©
 */
@RestController
@Slf4j
@RequestMapping("/brand")
public class BrandController {
    @Resource
    private BrandService brandService;


    @GetMapping("/list")
    public List<TbBrand> list(){
        return brandService.findAll();
    }

    @PostMapping("/list")
    public PageInfo<TbBrand> list(@RequestParam(value = "page",required = false,defaultValue = "1")int page,
                                  @RequestParam(value = "size",required = false,defaultValue = "0")int size,
                                  @RequestBody TbBrand brand){
        return brandService.findAll(page,size,brand);
    }

    @PostMapping("/add")
    public Result add(@RequestBody TbBrand brand){
        Map<String,Object> result = new HashMap<>();
        try {
            int count = brandService.add(brand);
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
    public TbBrand findById(@PathVariable("id")Long id){
        return brandService.findById(id);
    }

    @PostMapping("/modify")
    public Result modify(@RequestBody TbBrand brand){
        try {
            int count = brandService.updateById(brand);
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
            int count = brandService.deleteByIds(ids);
            if(count>0){
                return new Result(true);
            }
        } catch (Exception e) {
        }
        return new Result(false,"删除失败");
    }

}