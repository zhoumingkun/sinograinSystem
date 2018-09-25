package com.toughguy.sinograin.service.barn.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.toughguy.sinograin.model.barn.Pinchang;
import com.toughguy.sinograin.persist.barn.prototype.IPinchangDao;
import com.toughguy.sinograin.service.barn.prototype.IPinchangService;
import com.toughguy.sinograin.service.impl.GenericServiceImpl;

@Service
public class PinchangServiceImpl extends GenericServiceImpl<Pinchang, Integer> implements IPinchangService {

	@Override
	public Pinchang findBySmallSampleId(int smallSampleId) {
		// TODO Auto-generated method stub
		return ((IPinchangDao)dao).findBySmallSampleId(smallSampleId);
	}

	@Override
	public List<Pinchang> findByCheckOrderApprovalStatus(String sort) {
		// TODO Auto-generated method stub
		return ((IPinchangDao)dao).findByCheckOrderApprovalStatus(sort);
	}
	
}
