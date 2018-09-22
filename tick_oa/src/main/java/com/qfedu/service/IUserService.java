package com.qfedu.service;

import java.util.List;
import java.util.Map;

import com.qfedu.entity.User;

public interface IUserService {
	/**
	 * 权限管理
	 * @param no 账号
	 * @return
	 */
	public List<Map<String,Object>> QXGL(String no);
	
	/**
	 * 
	 * @param page 页数
	 * @param size 分页
	 * @return
	 */
	public List<Map<String,Object>> findUserByPageAndSize(int page, int size);

	/**
	 * 
	 * @return
	 */
	public int findUserCount();
	
	
	public void deleteUserAndRole(int id);
	

	
}
