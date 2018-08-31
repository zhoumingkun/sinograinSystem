package com.toughguy.sinograin.persist.barn.prototype;

import java.util.List;

import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.model.barn.WarehouseCounter;
import com.toughguy.sinograin.persist.prototype.IGenericDao;

public interface IWarehouseCounterDao extends IGenericDao<WarehouseCounter, Integer>{
	
	/**
	 * 根据柜号查询柜
	 */
	public WarehouseCounter findByCounter(String counter);
	/**
	 * 根据柜id查询所有样品
	 */
	public List<Sample> findSample(int counterId);
}
