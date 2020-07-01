package com.zephon.sellergoods.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.github.pagehelper.PageInfo;
import com.zephon.http.Result;
import com.zephon.pojo.TbSpecification;
import com.zephon.pojo.TbTypeTemplate;
import com.zephon.sellergoods.service.TypeTemplateService;
import lombok.extern.slf4j.Slf4j;
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
 * @Package com.zephon.sellergoods.controller
 * @date 2020/6/30 上午10:43
 * @Copyright ©
 */
@RestController
@Slf4j
@RequestMapping("/typeTemplate")
public class TypeTemplateController {
    @Resource
    private TypeTemplateService typeTemplateService;

    @PostMapping("/list")
    public PageInfo<TbTypeTemplate> list(@RequestParam(value="page",required = false,defaultValue = "1") Integer page,
                                          @RequestParam(value = "size",required = false,defaultValue = "10")Integer size,
                                          @RequestBody(required = false) TbTypeTemplate typeTemplate){
        return typeTemplateService.findAll(page,size,typeTemplate);
    }
    @PostMapping("/add")
    public Result add(@RequestBody Map<String, Object> map){
        TbTypeTemplate typeTemplate = new TbTypeTemplate();
        typeTemplate.setName(map.get("name").toString());
        typeTemplate.setBrandIds(JSONUtils.toJSONString(map.get("brandIds")));
        typeTemplate.setCustomAttributeItems(JSONUtils.toJSONString(map.get("customAttributeItems")));
        typeTemplate.setSpecIds(JSONUtils.toJSONString(map.get("specIds")));
        try {
            int count = typeTemplateService.add(typeTemplate);
            if(count>0){
                return new Result(true);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return new Result(false,"增加失败");
    }
    @PostMapping("/modify")
    public Result modify(@RequestBody Map<String, Object> map){
        TbTypeTemplate typeTemplate = new TbTypeTemplate();
        try {
            typeTemplate.setId(Long.parseLong(map.get("id").toString()));
            typeTemplate.setName(map.get("name").toString());
            typeTemplate.setBrandIds(JSONUtils.toJSONString(map.get("brandIds")));
            typeTemplate.setCustomAttributeItems(JSONUtils.toJSONString(map.get("customAttributeItems")));
            typeTemplate.setSpecIds(JSONUtils.toJSONString(map.get("specIds")));
            int count = typeTemplateService.updateById(typeTemplate);
            if(count>0){
                return new Result(true);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return new Result(false,"修改失败");
    }
    @GetMapping("/{id}")
    public TbTypeTemplate findById(@PathVariable("id") Long id){
        return typeTemplateService.findById(id);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody List<Long> ids){
        try {
            int count = typeTemplateService.deleteByIds(ids);
            if(count>0){
                return new Result(true);
            }
        } catch (Exception e) {
        }
        return new Result(false,"删除失败");
    }
}
