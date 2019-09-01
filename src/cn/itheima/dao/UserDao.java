package cn.itheima.dao;

import cn.itheima.domain.User;

public interface UserDao extends BaseDao<User> {
	//根据登录名称查询user对象
	User getByUserCode(String user_code);
//	//保存用户
//	void save(User u);
}
