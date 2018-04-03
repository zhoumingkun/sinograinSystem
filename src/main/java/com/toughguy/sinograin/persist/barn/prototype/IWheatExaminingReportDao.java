package com.toughguy.sinograin.persist.barn.prototype;

import org.apache.ibatis.annotations.Param;

import com.toughguy.sinograin.model.barn.CornExaminingReport;
import com.toughguy.sinograin.model.barn.WheatExaminingReport;

public interface IWheatExaminingReportDao {

	/*
	 * 查询基本情况
	 */
	public WheatExaminingReport findBasicSituation(@Param("sampleNum")String sampleNum);
	
	/*
	 * 查询质量验收情况（根据小样编号
	 */
	public WheatExaminingReport findQualityAcceptance(@Param("id")String id);
}
