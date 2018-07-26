package com.toughguy.sinograin.persist.barn.prototype;

import java.util.List;

import com.toughguy.sinograin.model.barn.Handover;
import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.persist.prototype.IGenericDao;

public interface IHandoverDao extends IGenericDao<Handover, Integer>  {
	/**
	 * 
	 * @param sampleNums
	 * @return
	 */
	public Handover findsampleNums(String sampleNums);
	/**
	 * 根据检验项目查询样品集
	 * @param checkPoint
	 * @return
	 */
	public List<Sample> findSampleByCheckPoint(int checkPoint);
}
