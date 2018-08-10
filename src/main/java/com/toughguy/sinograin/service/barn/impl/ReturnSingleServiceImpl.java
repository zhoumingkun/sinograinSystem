package com.toughguy.sinograin.service.barn.impl;

import org.springframework.stereotype.Service;

import com.toughguy.sinograin.model.barn.ReturnSingle;
import com.toughguy.sinograin.persist.barn.prototype.IReturnSingleDao;
import com.toughguy.sinograin.service.barn.prototype.IReturnSingleService;
import com.toughguy.sinograin.service.impl.GenericServiceImpl;

@Service
public class ReturnSingleServiceImpl extends GenericServiceImpl<ReturnSingle, Integer> implements IReturnSingleService {

	@Override
	public void updateSampleIdsOfNull(ReturnSingle returnSingle) {
		// TODO Auto-generated method stub
		((IReturnSingleDao)dao).updateSampleIdsOfNull(returnSingle);
	}

	@Override
	public ReturnSingle findBySampleId(int sampleId) {
		// TODO Auto-generated method stub
		return ((IReturnSingleDao)dao).findBySampleId(sampleId);
	}
	
}
