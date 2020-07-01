package com.zephon.sellergoods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zephon.pojo.TbSpecification;
import com.zephon.pojo.TbTypeTemplate;
import com.zephon.pojo.TbTypeTemplateExample;
import com.zephon.sellergoods.mapper.TbTypeTemplateMapper;
import com.zephon.sellergoods.service.TypeTemplateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.sellergoods.service.impl
 * @date 2020/6/30 上午10:45
 * @Copyright ©
 */
@Service
public class TypeTemplateImpl implements TypeTemplateService {
    @Resource
    private TbTypeTemplateMapper typeTemplateMapper;
    @Override
    public PageInfo<TbTypeTemplate> findAll(Integer page, Integer size, TbTypeTemplate typeTemplate) {
        PageHelper.startPage(page, size);

        List<TbTypeTemplate> typeTemplates = typeTemplateMapper.selectByExample(null);

        return new PageInfo<>(typeTemplates);
    }

    @Override
    public int add(TbTypeTemplate typeTemplate) {
        return typeTemplateMapper.insert(typeTemplate);
    }

    @Override
    public TbTypeTemplate findById(Long id) {
        return typeTemplateMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateById(TbTypeTemplate typeTemplate) {
        return typeTemplateMapper.updateByPrimaryKey(typeTemplate);
    }

    @Override
    public int deleteByIds(List<Long> ids) {
        TbTypeTemplateExample example = new TbTypeTemplateExample();
        TbTypeTemplateExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        return typeTemplateMapper.deleteByExample(example);
    }

    @Override
    public List<TbTypeTemplate> findAll() {
        return typeTemplateMapper.selectByExample(null);
    }
}
