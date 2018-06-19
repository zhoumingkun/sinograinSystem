package com.toughguy.sinograin.persist.barn.prototype;

import com.toughguy.sinograin.model.barn.WarehouseCounterPlace;
import com.toughguy.sinograin.persist.prototype.IGenericDao;

public interface IWarehouseCounterPlaceDao extends IGenericDao<WarehouseCounterPlace, Integer>{
	
	/**
	 * 根据placeId查询存放位置
	 * @param placeId
	 * @return
	 */
	public WarehouseCounterPlace findDepotAndCounterByPlaceId(int placeId);
}
