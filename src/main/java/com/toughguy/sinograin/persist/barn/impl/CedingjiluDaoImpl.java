package com.toughguy.sinograin.persist.barn.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.toughguy.sinograin.model.barn.Cedingjilu;
import com.toughguy.sinograin.persist.barn.prototype.ICedingjiluDao;
import com.toughguy.sinograin.persist.impl.GenericDaoImpl;

@Repository
public class CedingjiluDaoImpl extends GenericDaoImpl<Cedingjilu, Integer> implements ICedingjiluDao {

	@Override
	public Cedingjilu findBySmallSampleId(int smallSampleId) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(typeNameSpace + ".findBySmallSampleId", smallSampleId);
	}

	@Override
	public List<Cedingjilu> findByCheckOrderApprovalStatus(String sort) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(typeNameSpace + ".findByCheckOrderApprovalStatus", sort);
	}

}
