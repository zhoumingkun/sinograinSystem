package com.toughguy.sinograin.service.barn.prototype;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.toughguy.sinograin.model.barn.SafetyReport;
import com.toughguy.sinograin.service.prototype.IGenericService;

public interface ISafetyReportService extends IGenericService<SafetyReport, Integer>{
	public void ExportSafetyReport(HttpServletResponse response,int[] ids);
	//根据样品id查询监督检测报告
	public List<SafetyReport> findBySampleId(int sampleId);
}
