package com.toughguy.sinograin.service.barn.prototype;

import java.util.List;
import java.util.Map;

import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.pagination.PagerModel;
import com.toughguy.sinograin.service.prototype.IGenericService;

public interface ISampleService extends IGenericService<Sample, Integer>{
	/**
	 * 获取扦样信息（移动端）
	 * 
	 * */
	public PagerModel<Sample> findPaginatedMobile(Map<String, Object> params);
	
	/**
	 * 根据扦样编号修改样品信息
	 * */
	public Sample findBySampleNo(String sampleNo);
	
	/**
	 * 根据检验编号查询样品id
	 * */
	public Sample findBySampleNum(String sampleNo);
	
	
	/**
	 * 根据PId删除样品
	 */
	public void deleteByPId(int pId);

	/**
	 * 根据任务查询样品
	 */
	public List<Sample> findSamplesByTask(String taskName);
	
	
	public void Export(String sampleNums,String ids);

	public void ExeclPOI(String sampleNums, String ids);

	
}
