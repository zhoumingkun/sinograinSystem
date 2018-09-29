package com.toughguy.sinograin.persist.barn.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.toughguy.sinograin.model.barn.Mantoupinchang;
import com.toughguy.sinograin.persist.barn.prototype.IMantoupinchangDao;
import com.toughguy.sinograin.persist.impl.GenericDaoImpl;

@Repository
public class MantoupinchangDaoImpl extends GenericDaoImpl<Mantoupinchang, Integer> implements IMantoupinchangDao {

	@Override
	public Mantoupinchang findBySmallSampleId(int smallSampleId) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(typeNameSpace + ".findBySmallSampleId", smallSampleId);
	}

	@Override
	public List<Mantoupinchang> findByCheckOrderApprovalStatus(String sort) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(typeNameSpace + ".findByCheckOrderApprovalStatus", sort);
	}

}
