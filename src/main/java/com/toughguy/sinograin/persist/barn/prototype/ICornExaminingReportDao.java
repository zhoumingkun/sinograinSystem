package com.toughguy.sinograin.persist.barn.prototype;

import org.apache.ibatis.annotations.Param;

import com.toughguy.sinograin.model.barn.Cedingjilu;
import com.toughguy.sinograin.model.barn.CornExaminingReport;
import com.toughguy.sinograin.persist.prototype.IGenericDao;

public interface ICornExaminingReportDao extends IGenericDao<CornExaminingReport, Integer>{

	
	public CornExaminingReport findReportAll(@Param("sampleNum") String sampleNum);
	public CornExaminingReport findReportAllBysmall(@Param("id") String id);
}
