package com.toughguy.sinograin.persist.barn.impl;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.toughguy.sinograin.model.barn.Zhifangsuanzhi;
import com.toughguy.sinograin.persist.barn.prototype.IZhifangsuanzhiDao;
import com.toughguy.sinograin.persist.impl.GenericDaoImpl;
@Repository
public class ZhifangsuanzhiDaoImpl extends GenericDaoImpl<Zhifangsuanzhi, Integer> implements IZhifangsuanzhiDao{

	@Override
	public Zhifangsuanzhi findBySmallSampleId(int smallSampleId) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(typeNameSpace + ".findBySmallSampleId", smallSampleId);
	}
	@Override
	public List<Zhifangsuanzhi> findByCheckOrderApprovalStatus(String sort) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(typeNameSpace + ".findByCheckOrderApprovalStatus",sort);
	}
}
