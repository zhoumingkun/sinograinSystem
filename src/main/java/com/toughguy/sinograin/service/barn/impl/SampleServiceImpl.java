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
	public void updateBySampleNo(Sample sample) {
		((ISampleDao)dao).updateBySampleNo(sample);	
	}

}
