package com.toughguy.sinograin.service.barn.prototype;

import com.toughguy.sinograin.model.barn.WarehouseCounter;
import com.toughguy.sinograin.service.prototype.IGenericService;

public interface IWarehouseCounterService extends IGenericService<WarehouseCounter, Integer>{
	/**
	 * 根据柜号查询柜
	 */
	public WarehouseCounter findByCounter(String counter);
}
