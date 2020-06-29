package com.zephon.sellergoods.service;

import com.github.pagehelper.PageInfo;
import com.zephon.pojo.TbSpecification;

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
}
