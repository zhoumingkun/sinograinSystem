package com.toughguy.sinograin.service.barn.prototype;

import com.toughguy.sinograin.model.barn.ReturnSingle;
import com.toughguy.sinograin.service.prototype.IGenericService;

public interface IReturnSingleService extends IGenericService<ReturnSingle, Integer> {
	/**
	 * 修改归还单（包含sampleIds为空）
	 */
	public void updateSampleIdsOfNull(ReturnSingle returnSingle);
	
	/**
	 * 查询某个样品对应的归还单
	 */
	public ReturnSingle findBySampleId(int sampleId);
}
