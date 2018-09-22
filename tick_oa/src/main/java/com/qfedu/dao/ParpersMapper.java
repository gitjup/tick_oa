package com.qfedu.dao;

import com.qfedu.entity.Parpers;

public interface ParpersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Parpers record);

    int insertSelective(Parpers record);

    Parpers selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Parpers record);

    int updateByPrimaryKey(Parpers record);
}