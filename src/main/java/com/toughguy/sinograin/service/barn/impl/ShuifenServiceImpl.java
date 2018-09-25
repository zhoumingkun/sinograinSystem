package com.toughguy.sinograin.service.barn.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.toughguy.sinograin.model.barn.Shuifen;
import com.toughguy.sinograin.persist.barn.prototype.IShuifenDao;
import com.toughguy.sinograin.service.barn.prototype.IShuifenService;
import com.toughguy.sinograin.service.impl.GenericServiceImpl;

@Service
public class ShuifenServiceImpl extends GenericServiceImpl<Shuifen, Integer> implements IShuifenService {

	@Override
	public Shuifen findBySmallSampleId(int smallSampleId) {
		// TODO Auto-generated method stub
		return ((IShuifenDao)dao).findBySmallSampleId(smallSampleId);
	}

	@Override
	public List<Shuifen> findByCheckOrderApprovalStatus(String sort) {
		// TODO Auto-generated method stub
		return ((IShuifenDao)dao).findByCheckOrderApprovalStatus(sort);
	}
	
}
