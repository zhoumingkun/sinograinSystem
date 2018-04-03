package com.toughguy.sinograin.persist.barn.prototype;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.toughguy.sinograin.model.barn.CornExaminingReport;
import com.toughguy.sinograin.model.barn.WheatExaminingReport;

public interface IWheatExaminingReportDao {

	/*
	 * 查询基本情况
	 */
	public WheatExaminingReport findBasicSituation(@Param("id")int id);
	
	/*
	 * 查询质量验收情况（根据小样编号
	 */
	public List<WheatExaminingReport> findQualityAcceptance(@Param("id") int id);
}
