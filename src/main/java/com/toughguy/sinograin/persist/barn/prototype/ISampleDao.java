package com.toughguy.sinograin.persist.barn.prototype;

import java.util.Map;

import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.pagination.PagerModel;
import com.toughguy.sinograin.persist.prototype.IGenericDao;

public interface ISampleDao extends IGenericDao<Sample, Integer>{
	
	/**
	 * 获取扦样信息（移动端）
	 * 
	 * */
	public PagerModel<Sample> findPaginatedMobile(Map<String, Object> params);
}
