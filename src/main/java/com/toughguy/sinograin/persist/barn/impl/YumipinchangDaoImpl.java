package com.toughguy.sinograin.persist.barn.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.toughguy.sinograin.model.barn.Yumipinchang;
import com.toughguy.sinograin.persist.barn.prototype.IYumipinchangDao;
import com.toughguy.sinograin.persist.impl.GenericDaoImpl;

@Repository
public class YumipinchangDaoImpl extends GenericDaoImpl<Yumipinchang, Integer> implements IYumipinchangDao {

	@Override
	public Yumipinchang findBySmallSampleId(int smallSampleId) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(typeNameSpace + ".findBySmallSampleId",smallSampleId);
	}

	@Override
	public List<Yumipinchang> findByCheckOrderApprovalStatus(String sort) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(typeNameSpace + ".findByCheckOrderApprovalStatus",sort);
	}

}
