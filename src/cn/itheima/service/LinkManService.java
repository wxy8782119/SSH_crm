package cn.itheima.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.itheima.domain.LinkMan;
import cn.itheima.utils.PageBean;

public interface LinkManService {
	//保存联系人
	void save(LinkMan linkMan);

	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

}
