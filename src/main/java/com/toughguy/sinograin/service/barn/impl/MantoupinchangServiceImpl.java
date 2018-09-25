package com.toughguy.sinograin.service.barn.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.toughguy.sinograin.model.barn.Mantoupinchang;
import com.toughguy.sinograin.persist.barn.impl.MantoupinchangDaoImpl;
import com.toughguy.sinograin.persist.barn.prototype.IMantoupinchangDao;
import com.toughguy.sinograin.service.barn.prototype.IMantoupinchangService;
import com.toughguy.sinograin.service.impl.GenericServiceImpl;

@Service
public class MantoupinchangServiceImpl extends GenericServiceImpl<Mantoupinchang, Integer> implements IMantoupinchangService {

	@Override
	public Mantoupinchang findBySmallSampleId(int smallSampleId) {
		// TODO Auto-generated method stub
		return ((IMantoupinchangDao)dao).findBySmallSampleId(smallSampleId);
	}

	@Override
	public List<Mantoupinchang> findByCheckOrderApprovalStatus(String sort) {
		// TODO Auto-generated method stub
		return ((IMantoupinchangDao)dao).findByCheckOrderApprovalStatus(sort);
	}
	
}
