package com.toughguy.sinograin.service.barn.prototype;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.toughguy.sinograin.model.barn.Handover;
import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.service.prototype.IGenericService;

public interface IHandoverService extends IGenericService<Handover, Integer> {

	/**
	 * 导出样品交接单
	 */
	void expotHandover(HttpServletResponse response,Handover handover,boolean isStorage);
	
	/**
	 * 根据检测项目查询样品集
	 * @param checkPoint
	 * @return
	 */
	public List<Sample> findSampleByCheckPoint(int checkPoint);
	
	/**
	 * 根据样品id查询检验项目
	 * @param checkPoint
	 * @return
	 */
	public Handover findCheckedBySampleId(int sampleId);
}
