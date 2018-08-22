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
	public Sample findBySampleNum(String sampleNum);
	
	
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
//
	/**
	 * 导出小麦
	 */
	public void ExeclPOI(HttpServletResponse response,String ids,String title);
//	/**
//	 * 导出小麦质量
//	 */
//	public void ExportXMzhiliang(HttpServletResponse response,String ids,String title);
//	/**
//	 * 导出玉米质量
//	 */
//	public void ExportYMzhiliang(HttpServletResponse response,String ids,String title);

	/**
	 * 查询平台所有小麦玉米食用油库存总量
	 */
	public Sample findAllCereals();
	
	/**
	 * 移动端入库
	 * @param params
	 */
	public  int saveRuku(Sample sample);
	/**
	 * 移动端根据检测编号查找
	 * 
	 */
	public Sample findBysampleNumMobile(String sampleNum);
	public  void saveRukuXinxi(Sample sample);

	/**
	 * 导出样品登记薄
	 */
	public void ExportRegister(HttpServletResponse response, String sampleNos);
	
	/**
	 * 根据样品柜id查询所有样品
	 */
	public List<Sample> findByCounterId(Map<String, Object> params);
	
	/**
	 * 处理样品
	 */
	public void updateDispose(Sample sample);
	
	/**
	 * 根据storageTime查询导出样品登记簿
	 */
	public List<Sample> findBystorageTime(String storageTime);
	
	/**
	 * 分页查询临时钎样
	 */
	public PagerModel<Sample> findTemporaryPaginated(Map<String, Object> params);

	/**
	 * 临时扦样列表（导出按brainTime）
	 */
	public List<Sample> findAllExport(Map<String, Object> map);
	
	/**
	 * 根据任务id所有样品集（其中包括检验项目）
	 */
	public List<Sample> findByTaskId(int taskId);
	/**
	 * 根据检测状态查询检验编号
	 */
	public List<Sample> findByDetectionState(int detectionState);
}
