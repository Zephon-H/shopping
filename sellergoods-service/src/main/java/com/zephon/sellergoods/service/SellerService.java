package com.zephon.sellergoods.service;

import com.github.pagehelper.PageInfo;
import com.zephon.http.Result;
import com.zephon.pojo.TbSeller;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.sellergoods.service
 * @date 2020/7/2 上午8:55
 * @Copyright ©
 */
public interface SellerService {
    int add(TbSeller seller);

    PageInfo<TbSeller> findAll(int page, int size, TbSeller seller);

    TbSeller findById(String id);

    void updateStatus(String id,String status);
}
