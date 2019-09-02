package cn.itheima.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.itheima.domain.Customer;
import cn.itheima.utils.PageBean;

public interface CustomerService {
	//分页业务方法
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	//保存客户方法
	void save(Customer customer);
	//根据id获得客户对象
	Customer getById(Long cust_id);

}
