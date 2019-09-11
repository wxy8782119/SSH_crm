package cn.itheima.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.itheima.domain.SaleVisit;
import cn.itheima.utils.PageBean;

public interface SaleVisitService {
	//保存客户拜访记录
	void save(SaleVisit saleVisit);
	//客户拜访记录的分页列表
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

}
