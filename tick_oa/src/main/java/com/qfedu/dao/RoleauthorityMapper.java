package com.qfedu.dao;

import com.qfedu.entity.RoleauthorityKey;

public interface RoleauthorityMapper {
    int deleteByPrimaryKey(RoleauthorityKey key);

    int insert(RoleauthorityKey record);

    int insertSelective(RoleauthorityKey record);
}