package com.toughguy.sinograin.service.barn.prototype;

import com.toughguy.sinograin.model.barn.WarehouseCounterPlace;
import com.toughguy.sinograin.service.prototype.IGenericService;

public interface IWarehouseCounterPlaceService extends IGenericService<WarehouseCounterPlace, Integer>{
	
	/**
	 * 根据placeId查询存放位置
	 * @param placeId
	 * @return
	 */
	public WarehouseCounterPlace findDepotAndCounterByPlaceId(int placeId);
}
