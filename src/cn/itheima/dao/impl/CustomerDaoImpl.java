package cn.itheima.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itheima.dao.CustomerDao;
import cn.itheima.domain.Customer;

public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {

	@Override
	@SuppressWarnings("all")
	public List<Object[]> getIndustryCount() {
		//原生SQL查询
		List<Object[]> list = getHibernateTemplate().execute(new HibernateCallback<List>() {
			String sql = " SELECT                             "+
					"  bd.`dict_item_name`,                   "+
					"  COUNT(*) total                         "+
					" FROM                                    "+
					"  cst_customer c,                        "+
					"  base_dict bd                           "+
					" WHERE c.`cust_industry` = bd.`dict_id`  "+
					" GROUP BY c.`cust_industry`              ";
			@Override
			public List doInHibernate(Session session) throws HibernateException {
				SQLQuery query = session.createSQLQuery(sql);
				return query.list();
			}
		});
		return list;
	}

//	@Override
//	public Integer getTotalCount(DetachedCriteria dc) {
//		//设置查询的聚合函数，总记录数
//		dc.setProjection(Projections.rowCount());
//		
//		List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(dc);
//		
//		//清空之前设置的聚合函数
//		dc.setProjection(null);
//		
//		if(list != null && list.size()>0) {
//			Long count = list.get(0);
//			return count.intValue();
//		}else {
//			return null;
//			
//		}
//	}
//
//	@Override
//	public List<Customer> getPageList(DetachedCriteria dc, int start, Integer pageSize) {
//		List<Customer> list = (List<Customer>) getHibernateTemplate().findByCriteria(dc, start, pageSize);
//		return list;
//	}

}
