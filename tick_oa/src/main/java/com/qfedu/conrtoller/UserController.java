package com.qfedu.conrtoller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qfedu.entity.User;
import com.qfedu.service.IUserService;

@Controller
@RequestMapping("/Ticktack_Office")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@RequestMapping("/login")
	@ResponseBody
	public Map<String, Object> login(String no, String password) {
		SimpleHash sh = new SimpleHash("MD5", password, null, 1);
		UsernamePasswordToken token = new UsernamePasswordToken(no, sh.toString().trim());
		Subject subject = SecurityUtils.getSubject();
		Map<String, Object> map = new HashMap<>();
		
		try {
			subject.login(token);
			map.put("code", 0);
			map.put("msg", "");
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("code", 1);
			map.put("msg", e.getMessage());
		}
		
		return map;
	}
	
	@ResponseBody
	@RequestMapping("/qxSys")
	public List<Map<String,Object>> qxSys() {
		String no = (String) SecurityUtils.getSubject().getPrincipal();
		Map<String, Object> map = new HashMap<>();
		
		try {
			List<Map<String,Object>> list = userService.QXGL(no);
			return list;
		} catch (Exception e) {
			
			return null;
		}
	}
	
	@ResponseBody
	@RequestMapping("/findUserByPage")
	public Map<String, Object> findUserByPageAndSize(int page, int limit) {
		Map<String, Object> map = new HashMap<>();
		
		try {
			List<Map<String,Object>> list = userService.findUserByPageAndSize(page, limit);
			int count = userService.findUserCount();
			map.put("code", 0);
			map.put("msg", null);
			map.put("count", count);
			map.put("data", list);
			
			return map;
		} catch (Exception e) {
		
			map.put("code", 1);
			map.put("msg", e.getMessage());
			
			return map;
		}
	}

//	@ResponseBody
//	@RequestMapping("/userroleedit.do")
//	public Map<String, Object> findAllCompilePage(int page){
//		Map<String,Object> map = new HashMap<>();
//		
//		try {
//			List<Map<String,Object>> list = userService.findAllCompilePage(page);
//			map.put("code", 0);
//			map.put("msg", null);
//			map.put("data", list);
//			
//			return map;
//		} catch (Exception e) {
//			map.put("code", 1);
//			map.put("msg", e.getMessage());
//			return map;
//		}
		
		
//	}
}





















