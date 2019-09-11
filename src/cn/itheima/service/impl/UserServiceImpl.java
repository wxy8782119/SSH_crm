package cn.itheima.service.impl;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.itheima.dao.UserDao;
import cn.itheima.domain.User;
import cn.itheima.service.UserService;
import cn.itheima.utils.MD5Utils;
@Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,readOnly = true)
public class UserServiceImpl implements UserService {
	
	private UserDao ud;
	
	@Override
	public User getUserByCodePassword(User u) {
		//1.根据登录名称查询登录用户
		User existU = ud.getByUserCode(u.getUser_code());
		//2.判断用户是否存在，不存在=>抛出异常，提示用户不存在
		if(existU==null) {
			throw new RuntimeException("用户名不存在！");
		}
		//3.判断用户密码是否正确，不正确=>抛出异常，提示密码错误
		if(!existU.getUser_password().equals(MD5Utils.md5(u.getUser_password()))) {
			throw new RuntimeException("密码错误！");
		}
		//4.返回查询到的用户
		return existU;
	}

	@Override
	@Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,readOnly = false)
	public void saveUser(User u) {
		//1.调用Dao根据注册的登录名获得用户对象
		User existU = ud.getByUserCode(u.getUser_code());
		if(existU!=null) {
			//2.如果获得user对象，用户名已存在，抛出异常
			throw new RuntimeException("用户名已存在！");
		}
		
		//使用MD5对密码进行加密
		u.setUser_password(MD5Utils.md5(u.getUser_password()));
		
		//3.调用Dao执行保存
		ud.save(u);
	}

	public void setUd(UserDao ud) {
		this.ud = ud;
	}
	
	
	
}
