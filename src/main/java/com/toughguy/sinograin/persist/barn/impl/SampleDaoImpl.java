package com.toughguy.sinograin.persist.barn.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.pagination.PagerModel;
import com.toughguy.sinograin.persist.barn.prototype.ISampleDao;
import com.toughguy.sinograin.persist.impl.GenericDaoImpl;
import com.toughguy.sinograin.system.SystemContext;

@Repository
public class SampleDaoImpl extends GenericDaoImpl<Sample, Integer> implements ISampleDao {

	@Override
	public PagerModel<Sample> findPaginatedMobile(Map<String, Object> params) {
		// -- 1. 不管传或者不传参数都会追加至少两个分页参数
		if (params == null)
		params = new HashMap<String, Object>();
		params.put("offset", SystemContext.getOffset());
		params.put("limit", SystemContext.getPageSize());
		PagerModel<Sample> pm = new PagerModel<Sample>();
		int total = getTotalNumOfItemsMobile(params);
		List<Sample> entitys = sqlSessionTemplate.selectList(typeNameSpace + ".findPaginatedMobile", params);
		pm.setTotal(total);
		pm.setData(entitys);
		return pm;
	}
	/**
	 * 获取扦样数量（移动端）
	 * 
	 * */
	private int getTotalNumOfItemsMobile(Map<String, Object> params){
		int count = (Integer) sqlSessionTemplate.selectOne(typeNameSpace + ".getTotalOfItemsMobile", params);
		return count;
	}
	@Override
	public void findBySampleNo(String sampleNo) {
		sqlSessionTemplate.update(typeNameSpace + ".findBySampleNo", sampleNo);
		
	}
}
