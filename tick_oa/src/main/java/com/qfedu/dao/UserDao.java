package com.qfedu.dao;

import java.util.List;
import java.util.Map;

import com.qfedu.entity.User;

public interface UserDao {

	/**
	 * 
	 * @param no
	 * @return
	 */
	public User findByNo(String no);
	
	/**
	 * 
	 * @param no
	 * @return
	 */
	public List<Map<String, Object>> findQXByUserNo(String no);
	/**
	 * 
	 * @param map
	 * @return
	 */
	public List<Map<String,Object>> findAllUserByCPageAndSize(Map<String, Integer> map);

	/**
	 * 
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> findAllCompilePage();
	
	/**
	 * 
	 * @return
	 */
	public int countToUser();
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<Map<String, Object>> findUserRoleByUserId(int id);

	public void deleteUser(int id);

}