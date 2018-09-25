package com.toughguy.sinograin.service.barn.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.toughguy.sinograin.model.barn.Mianjinxishuiliang;
import com.toughguy.sinograin.persist.barn.prototype.IMianjinxishuiliangDao;
import com.toughguy.sinograin.service.barn.prototype.IMianjinxishuiliangService;
import com.toughguy.sinograin.service.impl.GenericServiceImpl;
@Service
public class MianjinxishuiliangServiceImpl extends GenericServiceImpl<Mianjinxishuiliang, Integer> implements IMianjinxishuiliangService{

	@Override
	public Mianjinxishuiliang findBySmallSampleId(int smallSampleId) {
		// TODO Auto-generated method stub
		return ((IMianjinxishuiliangDao)dao).findBySmallSampleId(smallSampleId);
	}
	@Override
	public List<Mianjinxishuiliang> findByCheckOrderApprovalStatus(String sort) {
		// TODO Auto-generated method stub
		return ((IMianjinxishuiliangDao)dao).findByCheckOrderApprovalStatus(sort);
	}
}
