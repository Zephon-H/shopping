package com.zephon.sellergoods.service;

import com.zephon.pojo.TbItemCat;

import java.util.List;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.sellergoods.service
 * @date 2020/7/1 下午3:15
 * @Copyright ©
 */
public interface ItemCatService {

    List<TbItemCat> findByParentId(Long id);

    int add(TbItemCat itemCat);

    TbItemCat findById(Long id);

    int updateById(TbItemCat itemCat);

    int deleteByIds(List<Long> ids);
}
