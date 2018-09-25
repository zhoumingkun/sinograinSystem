package com.toughguy.sinograin.service.barn.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.toughguy.sinograin.model.barn.Yumipinchang;
import com.toughguy.sinograin.persist.barn.prototype.IYumipinchangDao;
import com.toughguy.sinograin.service.barn.prototype.IYumipinchangService;
import com.toughguy.sinograin.service.impl.GenericServiceImpl;

@Service
public class YumipinchangServiceImpl extends GenericServiceImpl<Yumipinchang, Integer> implements IYumipinchangService {

	@Override
	public Yumipinchang findBySmallSampleId(int smallSampleId) {
		// TODO Auto-generated method stub
		return ((IYumipinchangDao)dao).findBySmallSampleId(smallSampleId);
	}

	@Override
	public List<Yumipinchang> findByCheckOrderApprovalStatus(String sort) {
		// TODO Auto-generated method stub
		return ((IYumipinchangDao)dao).findByCheckOrderApprovalStatus(sort);
	}
	
}
