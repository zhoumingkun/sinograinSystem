package com.toughguy.sinograin.service.barn.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.toughguy.sinograin.model.barn.Cedingjilu;
import com.toughguy.sinograin.persist.barn.prototype.ICedingjiluDao;
import com.toughguy.sinograin.service.barn.prototype.ICedingjiluService;
import com.toughguy.sinograin.service.impl.GenericServiceImpl;

@Service
public class CedingjiluServiceImpl extends GenericServiceImpl<Cedingjilu, Integer> implements ICedingjiluService {

	@Override
	public Cedingjilu findBySmallSampleId(int smallSampleId) {
		// TODO Auto-generated method stub
		return ((ICedingjiluDao)dao).findBySmallSampleId(smallSampleId);
	}

	@Override
	public List<Cedingjilu> findByCheckOrderApprovalStatus(String sort) {
		// TODO Auto-generated method stub
		return ((ICedingjiluDao)dao).findByCheckOrderApprovalStatus(sort);
	}
	
}
