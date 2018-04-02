package com.toughguy.sinograin.persist.barn.prototype;

import com.toughguy.sinograin.model.barn.CornExaminingReport;
import com.toughguy.sinograin.model.barn.WheatExaminingReport;

public interface IWheatExaminingReportDao {

	/*
	 * 查询基本情况
	 */
	public WheatExaminingReport findBasicSituation(String sampleNum);
	
	/*
	 * 查询质量验收情况（根据小样编号
	 */
	public WheatExaminingReport findQualityAcceptance(String sampleNum);
}
