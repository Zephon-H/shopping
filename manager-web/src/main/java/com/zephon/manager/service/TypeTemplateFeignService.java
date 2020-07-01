package com.zephon.manager.service;

import com.github.pagehelper.PageInfo;
import com.zephon.http.Result;
import com.zephon.pojo.TbTypeTemplate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.manager.service
 * @date 2020/6/30 上午10:51
 * @Copyright ©
 */
@Component
@FeignClient(value = "SELLERGOODS-SERVICE",contextId = "typeTemplate")
public interface TypeTemplateFeignService {
    @PostMapping("/typeTemplate/list")
    PageInfo<TbTypeTemplate> list(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                  @RequestParam(value = "size", required = false, defaultValue = "10") Integer size,
                                  @RequestBody(required = false) TbTypeTemplate typeTemplate);
    @PostMapping("/typeTemplate/add")
    Result add(@RequestBody Map<String, Object> map);
    @GetMapping("/typeTemplate/{id}")
    TbTypeTemplate findById(@PathVariable("id") Long id);

    @PostMapping("/typeTemplate/modify")
    Result modify(@RequestBody Map<String, Object> map);

    @PostMapping("/typeTemplate/delete")
    Result delete(@RequestBody List<Long> ids);
}

