package com.zephon.sellergoods.controller;

import com.github.pagehelper.PageInfo;
import com.zephon.http.Result;
import com.zephon.pojo.TbSpecification;
import com.zephon.sellergoods.service.SpecificationService;
import jdk.nashorn.internal.ir.annotations.Reference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.sellergoods.controller
 * @date 2020/6/29 下午4:14
 * @Copyright ©
 */
@RestController
@Slf4j
@RequestMapping("/specification")
public class SpecificationController {
    @Resource
    private SpecificationService specificationService;

    @PostMapping("/list")
    public PageInfo<TbSpecification> list(@RequestParam(value="page",required = false,defaultValue = "1") Integer page,
                                          @RequestParam(value = "size",required = false,defaultValue = "10")Integer size,
                                          @RequestBody(required = false) TbSpecification specification){
        return specificationService.findAll(page,size,specification);
    }
    @PostMapping("/add")
    public Result add(@RequestBody TbSpecification specification){
        try {
            System.out.println(specification.getSpecName());
            int count = specificationService.add(specification);
            if(count>0){
                return new Result(true);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return new Result(false,"增加失败");
    }
    @GetMapping("/{id}")
    public List<TbSpecification> findById(){

    }
}
