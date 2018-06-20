package com.toughguy.sinograin.service.barn.prototype;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

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
	
	/**
	 * 导出玉米
	 */
	public void Export(HttpServletResponse response,String ids,String title);

	/**
	 * 导出小麦
	 */
	public void ExeclPOI(HttpServletResponse response,String ids,String title);
	/**
	 * 导出小麦质量
	 */
	public void ExportXMzhiliang(HttpServletResponse response,String ids,String title);
	/**
	 * 导出玉米质量
	 */
	public void ExportYMzhiliang(HttpServletResponse response,String ids,String title);

	/**
	 * 查询平台所有小麦玉米食用油库存总量
	 */
	public Sample findAllCereals();
	
	/**
	 * 移动端入库
	 * @param params
	 */
	public void saveRuku(Sample sample);

	

	/**
	 * 导出样品登记薄
	 */
	public void ExportRegister(HttpServletResponse response, String sampleNos);
	
	/**
	 * 根据样品柜id查询所有样品
	 */
	public List<Sample> findByCounterId(int counterId);
}
