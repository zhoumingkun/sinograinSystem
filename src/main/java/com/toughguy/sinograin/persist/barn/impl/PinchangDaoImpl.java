package com.toughguy.sinograin.persist.barn.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.toughguy.sinograin.model.barn.Pinchang;
import com.toughguy.sinograin.persist.barn.prototype.IPinchangDao;
import com.toughguy.sinograin.persist.impl.GenericDaoImpl;

@Repository
public class PinchangDaoImpl extends GenericDaoImpl<Pinchang, Integer> implements IPinchangDao {

	@Override
	public Pinchang findBySmallSampleId(int smallSampleId) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(typeNameSpace + ".findBySmallSampleId", smallSampleId);
	}
	@Override
	public List<Pinchang> findByCheckOrderApprovalStatus(String sort) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(typeNameSpace + ".findByCheckOrderApprovalStatus",sort);
	}
}
