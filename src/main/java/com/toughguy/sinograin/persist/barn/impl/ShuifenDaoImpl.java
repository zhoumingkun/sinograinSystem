package com.toughguy.sinograin.persist.barn.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.toughguy.sinograin.model.barn.Shuifen;
import com.toughguy.sinograin.persist.barn.prototype.IShuifenDao;
import com.toughguy.sinograin.persist.impl.GenericDaoImpl;

@Repository
public class ShuifenDaoImpl extends GenericDaoImpl<Shuifen, Integer> implements IShuifenDao {

	@Override
	public Shuifen findBySmallSampleId(int smallSampleId) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(typeNameSpace + ".findBySmallSampleId", smallSampleId);
	}

	@Override
	public List<Shuifen> findByCheckOrderApprovalStatus(String sort) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(typeNameSpace + ".findByCheckOrderApprovalStatus", sort);
	}

}
	