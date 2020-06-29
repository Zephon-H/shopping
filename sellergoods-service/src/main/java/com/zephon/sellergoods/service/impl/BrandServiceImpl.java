package com.zephon.sellergoods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zephon.pojo.TbBrand;
import com.zephon.pojo.TbBrandExample;
import com.zephon.sellergoods.mapper.TbBrandMapper;
import com.zephon.sellergoods.service.BrandService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.sellergoods.service.impl
 * @date 2020/6/24 下午7:02
 * @Copyright ©
 */
@Service
public class BrandServiceImpl implements BrandService {
    @Resource
    private TbBrandMapper brandMapper;

    @Override
    public TbBrand findById(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateById(TbBrand brand) {
        return brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public List<TbBrand> findAll() {
        return brandMapper.selectByExample(null);
    }

    @Override
    public PageInfo<TbBrand> findAll(int page, int size,TbBrand brand) {
        PageHelper.startPage(page,size);
        TbBrandExample example = new TbBrandExample();
        TbBrandExample.Criteria criteria = example.createCriteria();
        if(brand!=null){
            if(StringUtils.isNotBlank(brand.getName())){
                criteria.andNameLike("%"+brand.getName()+"%");
            }
            if(StringUtils.isNotBlank(brand.getFirstChar())){
                criteria.andFirstCharEqualTo(brand.getFirstChar());
            }
        }
        List<TbBrand> brands = brandMapper.selectByExample(example);
        return new PageInfo<>(brands);
    }

    @Override
    public int add(TbBrand brand) {
        return brandMapper.insertSelective(brand);
    }

    @Override
    public int deleteByIds(List<Long> ids) {
        // 批量删除
        TbBrandExample example = new TbBrandExample();
        TbBrandExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        return brandMapper.deleteByExample(example);
    }
}
