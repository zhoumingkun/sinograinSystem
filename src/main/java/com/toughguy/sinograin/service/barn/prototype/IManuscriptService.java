package com.toughguy.sinograin.service.barn.prototype;

import javax.servlet.http.HttpServletResponse;

import com.toughguy.sinograin.model.barn.Manuscript;
import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.service.prototype.IGenericService;

public interface IManuscriptService extends IGenericService<Manuscript, Integer> {
	
	/**
	 * 导出工作底稿
	 * */
	public void expertExcel(HttpServletResponse response,Sample sample, Manuscript manuscript);
}
