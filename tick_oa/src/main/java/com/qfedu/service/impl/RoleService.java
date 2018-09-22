package com.qfedu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qfedu.dao.RoleMapper;
import com.qfedu.dao.UserRoleMapper;
import com.qfedu.entity.Role;
import com.qfedu.entity.RoleauthorityKey;
import com.qfedu.service.IRoleService;

@Service
public class RoleService implements IRoleService {

	@Autowired
	private RoleMapper roleMapper;
	
	private UserRoleMapper userRole;

	@Override
	public List<Role> findAllRole() {

		List<Role> list = null;

		try {
			list = roleMapper.findAllRole();
		} catch (Exception e) {
			throw e;
		}

		return list;
	}

	@Override
	public List<Role> findRoleByCPageAndSize(int page, int size) {
		int cpage = (page - 1) * size;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cpage", cpage);
		map.put("size", size);
		List<Role> list = null;
		try {
			list = roleMapper.findRoleByCPageAndSize(map);
		} catch (Exception e) {
			throw e;
		}

		return list;
	}

	@Override
	public int countToRole() {
		try {
			return roleMapper.countToRole();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}

	}

	@Override
	public void updateRoleAuth(Integer id, String aids) {

		List<Map<String, Object>> list = new ArrayList<>();

		try {
			List<RoleauthorityKey> ra = userRole.findRAKByRId(id);
			Iterator<RoleauthorityKey> iterator = ra.iterator();
			while (iterator.hasNext()) {
				RoleauthorityKey r = iterator.next();
				int i = 0;
				if (null == aids) {
					break;
				}
				if ((i = aids.indexOf(r.getAid().toString())) > -1) {
					aids = aids.replace(aids.charAt(i), ' ');
					iterator.remove();
				}
			}
			if (!ra.isEmpty()) {
				for (RoleauthorityKey rat : ra) {
					Map<String, Object> map = new HashMap<>();
					map.put("aid", rat.getAid());
					list.add(map);
				}
				Map<String, Object> map = new HashMap<>();
				map.put("id", id);
				map.put("list", list);
				userRole.deleteRoleAuth(map);
			}
			List<Map<String, Object>> list1 = new ArrayList<>();
			if (null != aids && !aids.trim().equals("")) {
				String[] split = aids.trim().split(",");

				for (String s : split) {
					if (s.trim().equals("")) {
						continue;
					}
					Map<String, Object> map = new HashMap<>();
					map.put("rid", id);
					map.put("aid", s);
					list1.add(map);
				}
				if (!list1.isEmpty()) {
					userRole.addRoleAuth(list1);
				}

			}

		} catch (Exception e) {

			throw e;
		}

	}

	@Override
	public void deleteRoleAuth(Integer id) {
		try {
			userRole.deleteRoleAuth1(id);
			roleMapper.deleteRole(id);
		} catch (Exception e) {
			throw e;
		}


	}

}
