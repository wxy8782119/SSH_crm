package cn.itheima.dao;

import cn.itheima.domain.User;

public interface UserDao {
	//根据登录名称查询user对象
	User getByUserCode(String user_code);
	//保存用户
	void save(User u);
}
