package com.toughguy.sinograin.persist.barn.prototype;

import com.toughguy.sinograin.model.barn.WarehouseCounter;
import com.toughguy.sinograin.persist.prototype.IGenericDao;

public interface IWarehouseCounterDao extends IGenericDao<WarehouseCounter, Integer>{
	
	/**
	 * 根据柜号查询柜
	 */
	public WarehouseCounter findByCounter(String counter);
}
