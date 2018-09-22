package com.qfedu.dao;

import java.util.List;
import java.util.Map;

import com.qfedu.entity.Loginlog;

public interface LoginlogMapper {
    
	public int countToLogin(String no);
	
	public List<Loginlog> findLoginByPageAndSize(Map<String, Object> map);
}