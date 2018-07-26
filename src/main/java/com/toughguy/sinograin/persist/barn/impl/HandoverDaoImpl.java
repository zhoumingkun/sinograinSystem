package com.toughguy.sinograin.persist.barn.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.toughguy.sinograin.model.barn.Handover;
import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.persist.barn.prototype.IHandoverDao;
import com.toughguy.sinograin.persist.impl.GenericDaoImpl;

@Repository
public class HandoverDaoImpl extends GenericDaoImpl<Handover, Integer> implements IHandoverDao {

	@Override
	public List<Sample> findSampleByCheckPoint(int checkPoint) {
		return sqlSessionTemplate.selectList(typeNameSpace + ".findSampleByCheckPoint",checkPoint);
	}


	@Override
	public Handover findsampleNums(String sampleNums) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(typeNameSpace + ".findsampleNums", sampleNums);
	}

}
