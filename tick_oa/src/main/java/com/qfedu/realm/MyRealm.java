package com.qfedu.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.qfedu.dao.UserDao;
import com.qfedu.entity.User;

public class MyRealm extends AuthorizingRealm{

	@Autowired
	private UserDao uDao;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		String no = (String) token.getPrincipal();
		
		User user = uDao.findByNo(no);
		
		if (user == null) {
			throw new UnknownAccountException();
		}
		
		String password = user.getPassword();
		
		SimpleAuthenticationInfo infos = new SimpleAuthenticationInfo(no, password,this.getName());
		
		return infos;
	}

}
