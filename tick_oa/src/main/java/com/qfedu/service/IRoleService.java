package com.qfedu.service;

import java.util.List;

import com.qfedu.entity.Role;

public interface IRoleService {
	
	/**
	 * 查询全部角色
	 * @return list
	 */
	public List<Role> findAllRole();
	
	public List<Role> findRoleByCPageAndSize(int page, int size);
	
	public int countToRole();
	
	public void updateRoleAuth(Integer id, String aids);
	
	public void deleteRoleAuth(Integer id);

}
