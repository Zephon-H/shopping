package com.zephon.sellergoods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zephon.http.Result;
import com.zephon.pojo.TbSeller;
import com.zephon.pojo.TbSellerExample;
import com.zephon.pojo.TbSpecification;
import com.zephon.sellergoods.mapper.TbSellerMapper;
import com.zephon.sellergoods.service.SellerService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.sellergoods.service.impl
 * @date 2020/7/2 上午8:56
 * @Copyright ©
 */
@Service
public class SellerServiceImpl implements SellerService {
    @Resource
    private TbSellerMapper sellerMapper;
    @Override
    public int add(TbSeller seller) {
        // 初始化状态为0
        seller.setStatus("0");
        return sellerMapper.insert(seller);
    }

    @Override
    public PageInfo<TbSeller> findAll(int page, int size, TbSeller seller) {
        PageHelper.startPage(page, size);
        TbSellerExample example = new TbSellerExample();
        TbSellerExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(seller.getStatus())) {
            criteria.andStatusEqualTo(seller.getStatus());
        }
        List<TbSeller> sellers = sellerMapper.selectByExample(example);
        return new PageInfo<>(sellers);
    }

    @Override
    public TbSeller findById(String id) {
        return sellerMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateStatus(String id, String status) {
        TbSeller seller = sellerMapper.selectByPrimaryKey(id);
        seller.setStatus(status);
        sellerMapper.updateByPrimaryKey(seller);
    }
}
