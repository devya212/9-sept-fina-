package com.nucleus.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nucleus.dao.IUserDao;
import com.nucleus.model.Role;
import com.nucleus.model.User;
import com.nucleus.utility.PasswordEncode;
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	
	IUserDao iudao;
	@Autowired
	PasswordEncode encodepwd;
	
	boolean check;
	@Transactional
	public void saveUser(User user, String[] role) {
		List<Role> list=new ArrayList<Role>();
		for(int i=0;i<role.length;i++)
		{
	
			if(role[i].equals("ROLE_ADMIN"))
			{
				Role role1=new Role();
				role1.setRolename(role[i]);
				role1.setRoleid(iudao.retrieveRoleId(role[i]));
				list.add(role1);
			}
			if(role[i].equals("ROLE_USER"))
			{
				Role role2=new Role();
				role2.setRolename(role[i]);
				role2.setRoleid(iudao.retrieveRoleId(role[i]));
				list.add(role2);
			}
		}
		user.setRole(list);
		user.setCheckEnable(1);
		user.setPassword(encodepwd.encodePwd(user.getPassword()));
	    iudao.saveUser(user);
	}

	@Transactional
	public void addRole(Role role) {
		iudao.addrole(role);		
	}

	@Transactional
	public boolean checkPrimaryKeyViolationUser(String roleid) {
		check=iudao.checkPrimaryKeyViolationUser(roleid);
		return check;
	}

	@Transactional
	public boolean checkUser(String userid) {
		check=iudao.checkUser(userid);
		return check;
	}

	@Transactional
	public List<String> getRoles(String userid) {
		List<String> lis=iudao.getRoles(userid);
		return lis;
	}
	
	
}
