package com.qfedu.service;

import java.util.Map;

public interface ILoginlogService {
	
	public Map<String, Object> findLoginByPageAndSize(String no, int page, int size);
}
