package com.zephon.sellergoods.service;

import com.github.pagehelper.PageInfo;
import com.zephon.pojo.TbSpecification;
import com.zephon.pojo.TbSpecificationOption;

import java.util.List;
import java.util.Map;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.sellergoods.service
 * @date 2020/6/29 下午4:15
 * @Copyright ©
 */
public interface SpecificationService {
    PageInfo<TbSpecification> findAll(Integer page, Integer size, TbSpecification specification);

    int add(TbSpecification specification);

    TbSpecification findById(Long id);

    int updateById(TbSpecification specification);

    int deleteByIds(List<Long> ids);

    List<Map<String, Object>> selectOptionList();
}
