package com.zephon.sellergoods.service;

import com.github.pagehelper.PageInfo;
import com.zephon.pojo.TbBrand;

import java.util.List;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.sellergoods.service
 * @date 2020/6/24 下午7:01
 * @Copyright ©
 */
public interface BrandService {
    List<TbBrand> findAll();

    PageInfo<TbBrand> findAll(int page, int size,TbBrand brand);


    int add(TbBrand brand);

    TbBrand findById(Long id);

    int updateById(TbBrand brand);

    int deleteByIds(List<Long> ids);
}
