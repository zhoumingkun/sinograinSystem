package com.toughguy.sinograin.service.barn.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;


import com.toughguy.sinograin.model.barn.Zhenjundusu;
import com.toughguy.sinograin.persist.barn.prototype.IZhenjundusuDao;
import com.toughguy.sinograin.service.barn.prototype.IZhenjundusuService;
import com.toughguy.sinograin.service.impl.GenericServiceImpl;

@Service
public class ZhenjundusuServiceImpl extends GenericServiceImpl<Zhenjundusu, Integer> implements IZhenjundusuService {

	@Override
	public Zhenjundusu findBySmallSampleId(int smallSampleId) {
		// TODO Auto-generated method stub
		return ((IZhenjundusuDao)dao).findBySmallSampleId(smallSampleId);
	}

	@Override
	public List<Zhenjundusu> findByCheckOrderApprovalStatus(String sort) {
		// TODO Auto-generated method stub
		return ((IZhenjundusuDao)dao).findByCheckOrderApprovalStatus(sort);
	}

}
