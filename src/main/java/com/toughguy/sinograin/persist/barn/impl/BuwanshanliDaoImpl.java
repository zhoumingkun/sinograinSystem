package com.toughguy.sinograin.persist.barn.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.toughguy.sinograin.model.barn.Buwanshanli;
import com.toughguy.sinograin.persist.barn.prototype.IBuwanshanliDao;
import com.toughguy.sinograin.persist.impl.GenericDaoImpl;

@Repository
public class BuwanshanliDaoImpl extends GenericDaoImpl<Buwanshanli, Integer> implements IBuwanshanliDao {

	@Override
	public Buwanshanli findBySmallSampleId(int smallSampleId) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(typeNameSpace + ".findBySmallSampleId", smallSampleId);
	}

	@Override
	public List<Buwanshanli> findByCheckOrderApprovalStatus(String sort) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(typeNameSpace + ".findByCheckOrderApprovalStatus", sort);
	}

}
