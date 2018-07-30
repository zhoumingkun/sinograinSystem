package com.toughguy.sinograin.persist.barn.prototype;

import java.util.List;

import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.model.barn.TestItem;
import com.toughguy.sinograin.persist.barn.impl.TestItemDaoImpl;
import com.toughguy.sinograin.persist.prototype.IGenericDao;

/**
 * 检测项目Dao层
 * @author BOBO
 *
 */
public interface ITestItemDao extends IGenericDao<TestItem, Integer>  {
	
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
}
