package com.toughguy.sinograin.persist.barn.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.toughguy.sinograin.model.barn.Mianjinxishuiliang;
import com.toughguy.sinograin.persist.barn.prototype.IMianjinxishuiliangDao;
import com.toughguy.sinograin.persist.impl.GenericDaoImpl;
@Repository
public class MianjinxishuiliangDaoImpl extends GenericDaoImpl<Mianjinxishuiliang, Integer> implements IMianjinxishuiliangDao{

	@Override
	public Mianjinxishuiliang findBySmallSampleId(int smallSampleId) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(typeNameSpace + ".findBySmallSampleId", smallSampleId);
	}
	@Override
	public List<Mianjinxishuiliang> findByCheckOrderApprovalStatus(String sort) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(typeNameSpace + ".findByCheckOrderApprovalStatus",sort);
	}
}
