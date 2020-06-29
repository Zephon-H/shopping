package com.zephon.sellergoods.mapper;

import com.zephon.pojo.TbAddress;
import com.zephon.pojo.TbAddressExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TbAddressMapper {
    long countByExample(TbAddressExample example);

    int deleteByExample(TbAddressExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbAddress record);

    int insertSelective(TbAddress record);

    List<TbAddress> selectByExample(TbAddressExample example);

    TbAddress selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbAddress record, @Param("example") TbAddressExample example);

    int updateByExample(@Param("record") TbAddress record, @Param("example") TbAddressExample example);

    int updateByPrimaryKeySelective(TbAddress record);

    int updateByPrimaryKey(TbAddress record);
}