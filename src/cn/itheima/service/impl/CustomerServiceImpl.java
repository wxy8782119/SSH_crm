package cn.itheima.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itheima.dao.CustomerDao;
import cn.itheima.domain.Customer;
import cn.itheima.service.CustomerService;
import cn.itheima.utils.PageBean;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDao cd;
	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//1.调用Dao查询总记录数
		Integer totalCount = cd.getTotalCount(dc);
		//2.创建PageBean对象
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		//3.调用Dao查询分页列表数据
		List<Customer> list = cd.getPageList(dc,pb.getStart(),pb.getPageSize());
		//4.列表数据放入pageBean中，并返回
		pb.setList(list);
		return pb;
	}
	
	@Override
	public void save(Customer customer) {
		cd.saveOrUpdate(customer);
	}

	@Override
	public Customer getById(Long cust_id) {
		return cd.getById(cust_id);
	}
	
	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}

}
