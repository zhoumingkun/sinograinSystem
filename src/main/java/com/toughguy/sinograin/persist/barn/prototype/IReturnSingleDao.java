package com.toughguy.sinograin.persist.barn.prototype;

import com.toughguy.sinograin.model.barn.ReturnSingle;
import com.toughguy.sinograin.persist.prototype.IGenericDao;

public interface IReturnSingleDao extends IGenericDao<ReturnSingle, Integer>  {
	/**
	 * 修改归还单（包含sampleIds为空）
	 */
	public void updateSampleIdsOfNull(ReturnSingle returnSingle);
	
	/**
	 * 查询某个样品对应的归还单
	 */
	public ReturnSingle findBySampleId(int sampleId);
	
}
