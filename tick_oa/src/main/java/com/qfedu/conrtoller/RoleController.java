package com.qfedu.conrtoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qfedu.service.IRoleService;

@Controller
@RequestMapping("/Ticktack_Office")
public class RoleController {

	@Autowired
	private IRoleService roleService;
	
	
}
