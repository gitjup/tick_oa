package com.qfedu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qfedu.dao.UserDao;
import com.qfedu.dao.UserRoleMapper;
import com.qfedu.entity.User;
import com.qfedu.service.IUserService;

@Service
public class UserService implements IUserService{

	@Autowired
	private UserDao userDao;
	@Autowired
	private UserRoleMapper userRole;
	
	
	@Override
	public List<Map<String, Object>> QXGL(String no) {
		if (null == no) {
			throw new RuntimeException("滴滴滴");
		}
		//首先创建一个list与新数组list1ArrayList<>(),通过调用userDao里的方法，用list接收把获取到的数据保存在list中
		//判断传入在list中的数据是否为空，在
		//list1是新建立的数组，通过遍历把list中数据传入到list1中
		List<Map<String,Object>> list = null;
		List<Map<String,Object>> list1 = new ArrayList<>();
		try {
			 list = userDao.findQXByUserNo(no);
			 
			 if (null == list) {
				 throw new RuntimeException("没找到");
			 }
			 
			 int i = 0;
			 int count=0;
			 for (Map<String, Object> map : list) {
				if (0 == i || map.get("id") != list.get(i-1).get("id")) {
					Map<String,Object> head = new HashMap<>();
					head.put("id", map.get("id"));
					head.put("icon", map.get("icon"));
					head.put("title", map.get("title"));
					List<Map<String,Object>> list2 = new ArrayList<>();
					head.put("childs", list2);
					list1.add(head);
					Map<String,Object> son = new HashMap<>();
					son.put("id", map.get("parentId"));
					son.put("aurl", map.get("paurl"));
					son.put("title", map.get("ptitle"));
					list2.add(son);
					count++;
					i++;
				} else {
					Map<String,Object> son = new HashMap<>();
					son.put("id", map.get("parentId"));
					son.put("aurl", map.get("paurl"));
					son.put("title", map.get("ptitle"));
					List<Map<String,Object>> object = (List<Map<String, Object>>) list1.get(count-1).get("childs");
					object.add(son);
					i++;
				}
			}
			 
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		
		
		return list1;
	}


	@Override
	public List<Map<String,Object>> findUserByPageAndSize(int page, int size) {
		
		int curPage = (page-1) * size;
		List<Map<String, Object>> list = null;
		try {
			Map<String, Integer> map = new HashMap<>();
			map.put("curPage", curPage);
			map.put("size", size);
			list = userDao.findAllUserByCPageAndSize(map);
			int i = 0;
			Iterator<Map<String, Object>> iterator = list.iterator();
			while(iterator.hasNext()) {
				Map<String, Object> map1 = iterator.next();
				if (0 == i || !map1.get("no").equals( list.get(i-1).get("no"))) {
					i++;
					continue;
					
				} else {
					String temp = (String) map1.get("role");
					String role = (String) list.get(i-1).get("role");
					list.get(i-1).put("role", role +", " + temp);
					iterator.remove();
					
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
			
		}
		
		return list;
	}
	
	@Override
	public int findUserCount() {
		try {
			return userDao.countToUser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}


	@Override
	public void deleteUserAndRole(int id) {
		// TODO Auto-generated method stub
		
	}


//	@Override
//	public void deleteUserAndRole(int id) {
//		
//		try {
//			List<Map<String, Object>> list = userDao.findUserRoleByUserId(id);
//			
//			if (null != list) {
//				for (Map<String, Integer> map : list) {
//				userRole.deleteUserRole(map);
//				}
//			}
//			userDao.deleteUser(id);
//		} catch (Exception e) {
//			throw e;
//		}
//	}
}
