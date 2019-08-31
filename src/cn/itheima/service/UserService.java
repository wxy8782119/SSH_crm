package cn.itheima.service;

import cn.itheima.domain.User;

public interface UserService {
	//登录方法
	User getUserByCodePassword(User u);
	//注册用户方法
	void saveUser(User u);
}
