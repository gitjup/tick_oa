package com.qfedu.conrtoller;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qfedu.service.ILoginlogService;

@Controller
@RequestMapping("/Ticktack_Office")
public class LoginlogController {
	
	@Autowired
	private ILoginlogService loginlog;
	
	@ResponseBody
	@RequestMapping("/findLoginlog")
	public Map<String, Object> findLoginByPageAndSize(int page, int limit) {
		
		String no = (String) SecurityUtils.getSubject().getPrincipal();
		Map<String, Object> map = null;
		
		try {
			map = loginlog.findLoginByPageAndSize(no, page, limit);
			
			map.put("code", 0);
			
			return map;
			
		} catch (Exception e) {
			map = new HashMap<>();
			
			map.put("code", 1);
			map.put("msg", e.getMessage());
			
			return map;
		}
	}
}
