package com.toughguy.sinograin.persist.barn.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.toughguy.sinograin.model.barn.SmallSample;
import com.toughguy.sinograin.persist.barn.prototype.ISmallSampleDao;
import com.toughguy.sinograin.persist.impl.GenericDaoImpl;

@Repository
public class SmallSampleDaoImpl extends GenericDaoImpl<SmallSample, Integer> implements ISmallSampleDao {
	@Override
	public SmallSample findBySmallSampleNum(String smallSampleNum) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(typeNameSpace + ".findBySmallSampleNum", smallSampleNum);
	}

	@Override
	public List<SmallSample> findBySampleId(int sampleId) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(typeNameSpace + ".findBySampleId", sampleId);
	}

	@Override
	public List<SmallSample> findBySampleNum(String sampleNum) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(typeNameSpace + ".findBySampleNum", sampleNum);
	}
	
}
