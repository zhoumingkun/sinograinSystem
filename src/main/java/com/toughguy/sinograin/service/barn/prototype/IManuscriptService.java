package com.toughguy.sinograin.service.barn.prototype;

import javax.servlet.http.HttpServletResponse;

import com.toughguy.sinograin.model.barn.Manuscript;
import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.service.prototype.IGenericService;

public interface IManuscriptService extends IGenericService<Manuscript, Integer> {
	
	/**
	 * 导出工作底稿（长方体）
	 * */
	public void exportExcelCFT(HttpServletResponse response,Sample sample, Manuscript manuscript) throws Exception;
	/**
	 * 导出工作底稿（圆柱体）
	 * */
	public void exportExcelYZT(HttpServletResponse response,Sample sample, Manuscript manuscript) throws Exception;
	/**
	 * 导出工作底稿（长方截锥体）
	 * */
	public void exportExcelCFJZT(HttpServletResponse response,Sample sample, Manuscript manuscript) throws Exception;
	/**
	 * 导出工作底稿（其他）
	 * */
	public void exportExcelQT(HttpServletResponse response,Sample sample, Manuscript manuscript) throws Exception;
}
