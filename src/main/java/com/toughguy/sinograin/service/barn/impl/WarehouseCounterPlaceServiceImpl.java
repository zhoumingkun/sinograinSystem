package com.toughguy.sinograin.service.barn.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toughguy.sinograin.model.barn.WarehouseCounterPlace;
import com.toughguy.sinograin.persist.barn.prototype.ITaskDao;
import com.toughguy.sinograin.persist.barn.prototype.IWarehouseCounterPlaceDao;
import com.toughguy.sinograin.service.barn.prototype.IWarehouseCounterPlaceService;
import com.toughguy.sinograin.service.impl.GenericServiceImpl;
@Service
public class WarehouseCounterPlaceServiceImpl extends GenericServiceImpl<WarehouseCounterPlace, Integer> implements IWarehouseCounterPlaceService{

	@Autowired
	IWarehouseCounterPlaceDao wcpDao;
	
	@Override
	public WarehouseCounterPlace findDepotAndCounterByPlaceId(int placeId) {
		// TODO Auto-generated method stub
		return wcpDao.findDepotAndCounterByPlaceId(placeId);
	}

}
