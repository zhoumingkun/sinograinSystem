package com.toughguy.sinograin.service.barn.prototype;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.model.barn.TestItem;
import com.toughguy.sinograin.service.prototype.IGenericService;

/**
 * 项目检测Service层
 * @author BOBO
 *
 */
public interface ITestItemService extends IGenericService<TestItem, Integer> {
	/**
	 * 根据样品id查询检测项目
	 * @return
	 */
	public List<TestItem> findResult(int sampleId);
	
	/**
	 * 根据品种和检验项目查询已检测的样品集
	 * @return
	 */
	public List<Sample> getSampleBySortAndTestItem(TestItem testItem);
	/**
	 * 根据品种和检验项目查询全部的样品集
	 * @return
	 */
	public List<Sample> getAllSampleBySortAndTestItem();
	/**
	 * 导出样品确认单
	 */
	public	void expotexpotTestItem(HttpServletResponse response,int sampleId);
}
