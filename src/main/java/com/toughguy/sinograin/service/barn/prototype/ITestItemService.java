package com.toughguy.sinograin.service.barn.prototype;

import java.util.List;

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
}
