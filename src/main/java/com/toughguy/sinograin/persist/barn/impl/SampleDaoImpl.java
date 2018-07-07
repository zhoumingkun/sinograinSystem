package com.toughguy.sinograin.persist.barn.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.toughguy.sinograin.model.barn.Register;
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
	public Sample findBySampleNo(String sampleNo) {		
		return sqlSessionTemplate.selectOne(typeNameSpace + ".findBySampleNo", sampleNo);
		
	}
	@Override
	public void deleteByPId(int pId) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.delete(typeNameSpace + ".deleteByPId", pId);
	}
	@Override
	public Sample findBySampleNum(String sampleNum) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(typeNameSpace + ".findBySampleNum", sampleNum);
	}
	@Override
	public List<Sample> findSamplesByTask(String taskName) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(typeNameSpace + ".findSamplesByTask", taskName);
	}
	@Override
	public Sample findAllCereals() {
		// TODO Auto-generated method stub
		return  sqlSessionTemplate.selectOne(typeNameSpace + ".findAllCereals");
	}
	@Override
	public List<Sample> findByCounterId(int counterId) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(typeNameSpace + ".findByCounterId",counterId);
	}

	@Override
	public int saveRuku(Sample sample) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert(typeNameSpace + ".saveRuku", sample);
	}
	@Override
	public Sample findBysampleNumMobile(String sampleNum) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(typeNameSpace + ".findBysampleNumMobile",sampleNum);
	}
	@Override
	public void saveRukuXinxi(Sample sample) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.update(typeNameSpace + ".saveRukuXinxi", sample);
	}
	@Override
	public void updateDispose(Sample sample) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.update(typeNameSpace + ".updateDispose", sample);
	}
	@Override
	public List<Sample> findBystorageTime(String storageTime) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(typeNameSpace + ".findBystorageTime", storageTime);
	}
	
	
		
}
