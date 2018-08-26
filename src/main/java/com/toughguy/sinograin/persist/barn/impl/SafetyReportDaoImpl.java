package com.toughguy.sinograin.persist.barn.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.toughguy.sinograin.model.barn.SafetyReport;
import com.toughguy.sinograin.persist.barn.prototype.ISafetyReportDao;
import com.toughguy.sinograin.persist.impl.GenericDaoImpl;

@Repository
public class SafetyReportDaoImpl extends GenericDaoImpl<SafetyReport, Integer> implements ISafetyReportDao{

	@Override
	public List<SafetyReport> findBySampleId(int sampleId) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(typeNameSpace + ".findBySampleId",sampleId);
	}

}
