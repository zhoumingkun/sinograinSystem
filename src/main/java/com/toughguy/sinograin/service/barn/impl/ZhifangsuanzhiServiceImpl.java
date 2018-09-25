package com.toughguy.sinograin.service.barn.impl;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.toughguy.sinograin.model.barn.Zhifangsuanzhi;
import com.toughguy.sinograin.persist.barn.prototype.IZhifangsuanzhiDao;
import com.toughguy.sinograin.service.barn.prototype.IZhifangsuanzhiService;
import com.toughguy.sinograin.service.impl.GenericServiceImpl;
@Service
public class ZhifangsuanzhiServiceImpl extends GenericServiceImpl<Zhifangsuanzhi, Integer> implements IZhifangsuanzhiService{

	@Override
	public Zhifangsuanzhi findBySmallSampleId(int smallSampleId) {
		// TODO Auto-generated method stub
		return ((IZhifangsuanzhiDao)dao).findBySmallSampleId(smallSampleId);
	}

	@Override
	public List<Zhifangsuanzhi> findByCheckOrderApprovalStatus(String sort) {
		// TODO Auto-generated method stub
		return ((IZhifangsuanzhiDao)dao).findByCheckOrderApprovalStatus(sort);
	}

}
