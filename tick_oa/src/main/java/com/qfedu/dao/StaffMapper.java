package com.qfedu.dao;

import com.qfedu.entity.Staff;

public interface StaffMapper {
    int deleteByPrimaryKey(String no);

    int insert(Staff record);

    int insertSelective(Staff record);

    Staff selectByPrimaryKey(String no);

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKey(Staff record);
}