package com.zephon.sellergoods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zephon.pojo.TbSpecification;
import com.zephon.pojo.TbSpecificationExample;
import com.zephon.pojo.TbSpecificationOption;
import com.zephon.pojo.TbSpecificationOptionExample;
import com.zephon.sellergoods.mapper.TbSpecificationMapper;
import com.zephon.sellergoods.mapper.TbSpecificationOptionMapper;
import com.zephon.sellergoods.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.sellergoods.service.impl
 * @date 2020/6/29 下午4:15
 * @Copyright ©
 */
@Service
public class SpecificationServiceImpl implements SpecificationService {
    @Resource
    private TbSpecificationMapper specificationMapper;

    @Override
    public PageInfo<TbSpecification> findAll(Integer page, Integer size, TbSpecification specification) {
        PageHelper.startPage(page, size);

//        criteria.andSpecNameEqualTo(specification.getSpecName());

        List<TbSpecification> specifications = specificationMapper.selectByExample(null);
        return new PageInfo<>(specifications);
    }

    @Resource
    private TbSpecificationOptionMapper specificationOptionMapper;
    @Override
    public int add(TbSpecification specification) {
        // 1.将规格信息增加到规格表
        int count = specificationMapper.insert(specification);
        // 2.获取规格的主键ID，赋值给规格选项的spec_id
        // 3.将规格选项规格选项表
        List<TbSpecificationOption> specificationOptionList = specification.getSpecificationOptionList();
        for (TbSpecificationOption tbSpecificationOption : specificationOptionList) {
            tbSpecificationOption.setSpecId(specification.getId());
            // 增加入库
            specificationOptionMapper.insertSelective(tbSpecificationOption);
        }
        return count;
    }

    @Override
    public TbSpecification findById(Long id) {
        // 规格信息
        TbSpecification specification = specificationMapper.selectByPrimaryKey(id);
        // 查询规格属性
        TbSpecificationOption specificationOption = new TbSpecificationOption();
        specificationOption.setSpecId(id);

        TbSpecificationOptionExample example = new TbSpecificationOptionExample();
        TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
        criteria.andSpecIdEqualTo(id);

        List<TbSpecificationOption> list = specificationOptionMapper.selectByExample(example);
        specification.setSpecificationOptionList(list);
        return specification;
    }

    @Override
    public int updateById(TbSpecification specification) {
        // 规格信息修改
        int count = specificationMapper.updateByPrimaryKeySelective(specification);
        TbSpecificationOptionExample example = new TbSpecificationOptionExample();
        TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
        criteria.andSpecIdEqualTo(specification.getId());
        // 删除之前的规格属性
        specificationOptionMapper.deleteByExample(example);
        // 添加新的规格属性
        List<TbSpecificationOption> specificationOptionList = specification.getSpecificationOptionList();
        for (TbSpecificationOption tbSpecificationOption : specificationOptionList) {
            tbSpecificationOption.setSpecId(specification.getId());
            specificationOptionMapper.insertSelective(tbSpecificationOption);
        }
        return count;
    }

    @Override
    public int deleteByIds(List<Long> ids) {
        TbSpecificationExample example = new TbSpecificationExample();
        TbSpecificationExample.Criteria criteria = example.createCriteria();

        criteria.andIdIn(ids);
        // 删除规格信息
        int count1 = specificationMapper.deleteByExample(example);
        // 批量删除
        TbSpecificationOptionExample ex = new TbSpecificationOptionExample();
        TbSpecificationOptionExample.Criteria cr = ex.createCriteria();
        cr.andSpecIdIn(ids);
        // 删除规格选项
        int count2 = specificationOptionMapper.deleteByExample(ex);

        return count1+count2;
    }
}
