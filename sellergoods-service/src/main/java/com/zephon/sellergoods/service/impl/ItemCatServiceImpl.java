package com.zephon.sellergoods.service.impl;

import com.zephon.pojo.TbItemCat;
import com.zephon.pojo.TbItemCatExample;
import com.zephon.sellergoods.mapper.TbItemCatMapper;
import com.zephon.sellergoods.service.ItemCatService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.sellergoods.service.impl
 * @date 2020/7/1 下午3:15
 * @Copyright ©
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {
    @Resource
    private TbItemCatMapper itemCatMapper;

    @Override
    public List<TbItemCat> findByParentId(Long id) {
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(id);
        return itemCatMapper.selectByExample(example);
    }

    @Override
    public int add(TbItemCat itemCat) {
        return itemCatMapper.insert(itemCat);
    }

    @Override
    public TbItemCat findById(Long id) {
        return itemCatMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateById(TbItemCat itemCat) {
        return itemCatMapper.updateByPrimaryKeySelective(itemCat);
    }

    @Override
    public int deleteByIds(List<Long> ids) {
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        return itemCatMapper.deleteByExample(example);
    }
}
