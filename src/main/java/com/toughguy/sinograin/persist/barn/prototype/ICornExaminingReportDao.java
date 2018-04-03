package com.toughguy.sinograin.persist.barn.prototype;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.toughguy.sinograin.model.barn.Cedingjilu;
import com.toughguy.sinograin.model.barn.CornExaminingReport;
import com.toughguy.sinograin.persist.prototype.IGenericDao;

public interface ICornExaminingReportDao extends IGenericDao<CornExaminingReport, Integer>{

	
	public CornExaminingReport findBasicSituation(@Param("id") int id);
	public List<CornExaminingReport> findQualityAcceptance(@Param("id") int id);
	
}
