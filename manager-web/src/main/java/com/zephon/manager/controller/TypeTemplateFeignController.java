package com.zephon.manager.controller;

import com.github.pagehelper.PageInfo;
import com.zephon.http.Result;
import com.zephon.manager.service.TypeTemplateFeignService;
import com.zephon.pojo.TbTypeTemplate;
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
 * @date 2020/6/30 上午10:52
 * @Copyright ©
 */
@RestController
@RequestMapping("/typeTemplate")
public class TypeTemplateFeignController {
    @Resource
    private TypeTemplateFeignService typeTemplateFeignService;

    @PostMapping("/list")
    PageInfo<TbTypeTemplate> list(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                  @RequestParam(value = "size", required = false, defaultValue = "10") Integer size,
                                  @RequestBody(required = false) TbTypeTemplate typeTemplate) {
        return typeTemplateFeignService.list(page, size, typeTemplate);
    }

    @PostMapping("/add")
    Result add(@RequestBody Map<String, Object> map) {
        return typeTemplateFeignService.add(map);
    }

    @GetMapping("/{id}")
    TbTypeTemplate findById(@PathVariable("id") Long id) {
        return typeTemplateFeignService.findById(id);
    }

    @PostMapping("/modify")
    public Result modify(@RequestBody Map<String, Object> map){
        return typeTemplateFeignService.modify(map);
    }
    @PostMapping("/delete")
    public Result delete(@RequestBody List<Long> ids){
        return typeTemplateFeignService.delete(ids);
    }
    @GetMapping("/list")
    public List<TbTypeTemplate> list(){
        return typeTemplateFeignService.list();
    }
}
