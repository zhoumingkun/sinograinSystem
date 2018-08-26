package com.toughguy.sinograin.persist.barn.prototype;

import java.util.List;

import com.toughguy.sinograin.model.barn.SafetyReport;
import com.toughguy.sinograin.persist.prototype.IGenericDao;

public interface ISafetyReportDao extends IGenericDao<SafetyReport, Integer> {
	//根据样品id查询监督检测报告
	public List<SafetyReport> findBySampleId(int sampleId);
}
