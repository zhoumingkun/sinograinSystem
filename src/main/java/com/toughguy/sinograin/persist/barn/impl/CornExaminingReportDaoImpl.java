package com.toughguy.sinograin.persist.barn.impl;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.toughguy.sinograin.model.barn.CornExaminingReport;
import com.toughguy.sinograin.persist.barn.prototype.ICornExaminingReportDao;
import com.toughguy.sinograin.persist.impl.GenericDaoImpl;

@Repository
public class CornExaminingReportDaoImpl   extends GenericDaoImpl<CornExaminingReport, Integer> implements ICornExaminingReportDao{

	
	@Autowired
	SqlSessionTemplate sessionTemplate;
	
	@Override
	public CornExaminingReport findBasicSituation(@Param("sampleNum") String sampleNum) {
		return sessionTemplate.selectOne("com.toughguy.sinograin.model.barn.CornExaminingReport.findBasicSituation",sampleNum);
	}
	
	@Override
	public CornExaminingReport findQualityAcceptance(@Param("id") String id) {
		return sessionTemplate.selectOne("com.toughguy.sinograin.model.barn.CornExaminingReport.findQualityAcceptance",id);
	}

}
