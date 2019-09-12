package cn.itheima.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itheima.domain.Customer;

public interface CustomerDao extends BaseDao<Customer>{
//	//查询总记录数
//	Integer getTotalCount(DetachedCriteria dc);
//	//查询分页列表数据
//	List<Customer> getPageList(DetachedCriteria dc, int start, Integer pageSize);

	//按照行业统计客户数量
	List<Object[]> getIndustryCount();
}
