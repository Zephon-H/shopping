package com.zephon.sellergoods.service;

import com.github.pagehelper.PageInfo;
import com.zephon.pojo.TbSpecification;
import com.zephon.pojo.TbTypeTemplate;

import java.util.List;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.sellergoods.service
 * @date 2020/6/30 上午10:44
 * @Copyright ©
 */
public interface TypeTemplateService {
    PageInfo<TbTypeTemplate> findAll(Integer page, Integer size, TbTypeTemplate typeTemplate);

    int add(TbTypeTemplate typeTemplate);

    TbTypeTemplate findById(Long id);

    int updateById(TbTypeTemplate typeTemplate);

    int deleteByIds(List<Long> ids);

    List<TbTypeTemplate> findAll();
}
