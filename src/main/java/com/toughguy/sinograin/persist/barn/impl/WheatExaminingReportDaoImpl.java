package com.toughguy.sinograin.persist.barn.impl;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.toughguy.sinograin.model.barn.CornExaminingReport;
import com.toughguy.sinograin.model.barn.WheatExaminingReport;
import com.toughguy.sinograin.persist.barn.prototype.IWheatExaminingReportDao;

@Repository
public class WheatExaminingReportDaoImpl  implements IWheatExaminingReportDao{

	
	@Autowired
	SqlSessionTemplate sessionTemplate;
	
	public WheatExaminingReport findBasicSituation(@Param("sampleNum")String sampleNum){
		return sessionTemplate.selectOne("com.toughguy.sinograin.model.barn.WheatExaminingReport.findBasicSituation", sampleNum);
	}
	
	public WheatExaminingReport findQualityAcceptance(@Param("id")String id){
		return sessionTemplate.selectOne("com.toughguy.sinograin.model.barn.WheatExaminingReport.findQualityAcceptance", id);
	}
}
