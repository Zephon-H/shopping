package com.zephon.sellergoods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zephon.pojo.TbSpecification;
import com.zephon.pojo.TbSpecificationExample;
import com.zephon.pojo.TbSpecificationOption;
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
}
