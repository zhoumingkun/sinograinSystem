package com.toughguy.sinograin.persist.barn.prototype;

import java.util.List;

import com.toughguy.sinograin.model.barn.TestItem;
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
}
