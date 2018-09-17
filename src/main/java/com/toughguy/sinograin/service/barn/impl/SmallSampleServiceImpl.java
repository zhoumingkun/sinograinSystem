package com.toughguy.sinograin.service.barn.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.model.barn.SmallSample;
import com.toughguy.sinograin.persist.barn.prototype.ISampleDao;
import com.toughguy.sinograin.persist.barn.prototype.ISmallSampleDao;
import com.toughguy.sinograin.service.barn.prototype.ISmallSampleService;
import com.toughguy.sinograin.service.impl.GenericServiceImpl;

@Service
public class SmallSampleServiceImpl extends GenericServiceImpl<SmallSample, Integer> implements ISmallSampleService{
	@Override
	public SmallSample findBySmallSampleNum(String smallSampleNum) {
		return ((ISmallSampleDao)dao).findBySmallSampleNum(smallSampleNum);	
	}

	@Override
	public List<SmallSample> findBySampleId(int sampleId) {
		// TODO Auto-generated method stub
		return ((ISmallSampleDao)dao).findBySampleId(sampleId);
	}

	@Override
	public List<SmallSample> findBySampleNum(String sampleNum) {
		// TODO Auto-generated method stub
		return ((ISmallSampleDao)dao).findBySampleNum(sampleNum);
	}
}
