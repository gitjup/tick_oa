package com.qfedu.dao;

import java.util.List;
import java.util.Map;

import com.qfedu.entity.RoleauthorityKey;
import com.qfedu.entity.UserRoleKey;


public interface UserRoleMapper {
    
	public void addUserRole(Map<String, Integer> map);
	
	public void deleteUserRole(Map<String, Integer> map);
	
	public List<UserRoleKey> findeUserRoleByNo(String no);
	
	public void addRoleAuth(List<Map<String, Object>> list);
	
	public List<RoleauthorityKey> findRAKByRId(int id);
	
	public void deleteRoleAuth(Map<String, Object> map);
	
	public void deleteRoleAuth1(int id);
}