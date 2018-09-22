package com.qfedu.dao;

import java.util.List;
import java.util.Map;

import com.qfedu.entity.Role;

public interface RoleMapper {
    
	public List<Role> findAllRole();


	public int countToRole();

	public List<Role> findRoleByCPageAndSize(Map<String, Object> map);


	public void deleteRole(Integer id);
}