package com.toughguy.sinograin.persist.barn.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;


import com.toughguy.sinograin.model.barn.Zhenjundusu;
import com.toughguy.sinograin.persist.barn.prototype.IZhenjundusuDao;
import com.toughguy.sinograin.persist.impl.GenericDaoImpl;

@Repository
public class ZhenjundusuDaoImpl extends GenericDaoImpl<Zhenjundusu, Integer> implements IZhenjundusuDao {

	@Override
	public Zhenjundusu findBySmallSampleId(int smallSampleId) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(typeNameSpace + ".findBySmallSampleId", smallSampleId);
	}
	@Override
	public List<Zhenjundusu> findByCheckOrderApprovalStatus(String sort) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(typeNameSpace + ".findByCheckOrderApprovalStatus",sort);
	}
}
