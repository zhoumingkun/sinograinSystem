package com.toughguy.sinograin.service.barn.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.toughguy.sinograin.model.barn.Buwanshanli;
import com.toughguy.sinograin.persist.barn.prototype.IBuwanshanliDao;
import com.toughguy.sinograin.service.barn.prototype.IBuwanshanliService;
import com.toughguy.sinograin.service.impl.GenericServiceImpl;

@Service
public class BuwanshanliServiceImpl extends GenericServiceImpl<Buwanshanli, Integer> implements IBuwanshanliService {

	@Override
	public Buwanshanli findBySmallSampleId(int smallSampleId) {
		// TODO Auto-generated method stub
		return ((IBuwanshanliDao)dao).findBySmallSampleId(smallSampleId);
	}

	@Override
	public List<Buwanshanli> findByCheckOrderApprovalStatus(String sort) {
		// TODO Auto-generated method stub
		return ((IBuwanshanliDao)dao).findByCheckOrderApprovalStatus(sort);
	}
	
}
