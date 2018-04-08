package com.toughguy.sinograin.service.barn.prototype;

import javax.servlet.http.HttpServletResponse;

import com.toughguy.sinograin.model.barn.SafetyReport;
import com.toughguy.sinograin.service.prototype.IGenericService;

public interface ISafetyReportService extends IGenericService<SafetyReport, Integer>{
	public void ExportSafetyReport(HttpServletResponse response,int[] ids);
}
