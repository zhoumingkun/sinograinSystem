package com.toughguy.sinograin.service.barn.prototype;

import javax.servlet.http.HttpServletResponse;

import com.toughguy.sinograin.model.barn.Handover;
import com.toughguy.sinograin.service.prototype.IGenericService;

public interface IHandoverService extends IGenericService<Handover, Integer> {

	/**
	 * 导出样品交接单
	 */
	void expotHandover(HttpServletResponse response,Handover handover);
	
}
