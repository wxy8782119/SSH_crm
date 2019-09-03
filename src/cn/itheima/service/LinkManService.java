package cn.itheima.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.itheima.domain.LinkMan;
import cn.itheima.utils.PageBean;

public interface LinkManService {
	//保存联系人
	void save(LinkMan linkMan);
	//联系人列表
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	//根据id获得LinkMan对象
	LinkMan getById(Long lkm_id);

}
