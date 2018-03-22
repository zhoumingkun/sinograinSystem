package com.toughguy.sinograin.service.barn.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.pagination.PagerModel;
import com.toughguy.sinograin.persist.barn.prototype.ISampleDao;
import com.toughguy.sinograin.service.barn.prototype.ISampleService;
import com.toughguy.sinograin.service.impl.GenericServiceImpl;

@Service
public class SampleServiceImpl extends GenericServiceImpl<Sample, Integer> implements ISampleService {
	
	@Override
	public PagerModel<Sample> findPaginatedMobile(Map<String, Object> params) {	
		return  ((ISampleDao)dao).findPaginatedMobile(params);
	}

	@Override
	public Sample findBySampleNo(String sampleNo) {
		return ((ISampleDao)dao).findBySampleNo(sampleNo);	
	}

	@Override
	public void deleteByPId(int pId) {
		// TODO Auto-generated method stub
		((ISampleDao)dao).deleteByPId(pId);
	}

	@Override
	public Sample findBySampleNum(String sampleNum) {
		// TODO Auto-generated method stub
		return ((ISampleDao)dao).findBySampleNum(sampleNum);	
	}

}
