package com.qfedu.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qfedu.dao.LoginlogMapper;
import com.qfedu.entity.Loginlog;
import com.qfedu.service.ILoginlogService;

@Service
public class LoginlogService implements ILoginlogService{

	@Autowired
	private LoginlogMapper loginlogMapper;
	
	@Override
	public Map<String, Object> findLoginByPageAndSize(String no, int page, int size) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map2 = new HashMap<>();
		int currPage = (page-1) * size;
		map2.put("no", no);
		map2.put("currPage", currPage);
		map2.put("size", size);
		
		List<Loginlog> list = null;
		try {
			list = loginlogMapper.findLoginByPageAndSize(map2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int count = loginlogMapper.countToLogin(no);
		map.put("count", count);
		map.put("data", list);
		
		return map;
	}

}
