package cn.itheima.service.impl;

import java.util.List;

import cn.itheima.dao.BaseDictDao;
import cn.itheima.domain.BaseDict;
import cn.itheima.service.BaseDictService;

public class BaseDictServiceImpl implements BaseDictService {
	
	private BaseDictDao bdd;
	
	@Override
	public List<BaseDict> getListByTypeCode(String dict_type_code) {
		return bdd.getListByTypeCode(dict_type_code);
	}

	public void setBdd(BaseDictDao bdd) {
		this.bdd = bdd;
	}
	
}
