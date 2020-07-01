package com.zephon.manager.controller;

import com.github.pagehelper.PageInfo;
import com.zephon.http.Result;
import com.zephon.manager.service.BrandFeignService;
import com.zephon.manager.service.SpecificationFeignService;
import com.zephon.pojo.TbBrand;
import com.zephon.pojo.TbSpecification;
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
 * @date 2020/6/29 下午4:25
 * @Copyright ©
 */
@RestController
@RequestMapping("/specification")
public class SpecificationFeignController {
    @Resource
    private SpecificationFeignService specificationFeignService;
    @PostMapping("/list")
    public PageInfo<TbSpecification> list(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                  @RequestParam(value = "size",required = false,defaultValue = "0")int size,
                                  @RequestBody TbSpecification specification){
        System.out.println(specification);
        return specificationFeignService.findAll(page, size,specification);
    }
    @PostMapping("/add")
    public Result add(@RequestBody TbSpecification specification){
        return specificationFeignService.add(specification);
    }
    @GetMapping("/{id}")
    public TbSpecification findById(@PathVariable("id") Long id){
        return specificationFeignService.findById(id);
    }
    @PostMapping("/modify")
    public Result modify(@RequestBody TbSpecification specification){
        return specificationFeignService.modify(specification);
    }
    @PostMapping("/delete")
    public Result delete(@RequestBody List<Long> ids){
        return specificationFeignService.delete(ids);
    }
    @GetMapping("/optionlist")
    public List<Map<String,Object>> getOptionList(){
        System.out.println(specificationFeignService.getOptionList());
        return specificationFeignService.getOptionList();
    }
}
