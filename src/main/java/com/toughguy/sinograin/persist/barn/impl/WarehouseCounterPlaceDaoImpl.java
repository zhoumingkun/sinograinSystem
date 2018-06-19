package com.toughguy.sinograin.persist.barn.impl;

import org.springframework.stereotype.Repository;

import com.toughguy.sinograin.model.barn.WarehouseCounter;
import com.toughguy.sinograin.model.barn.WarehouseCounterPlace;
import com.toughguy.sinograin.persist.barn.prototype.IWarehouseCounterDao;
import com.toughguy.sinograin.persist.barn.prototype.IWarehouseCounterPlaceDao;
import com.toughguy.sinograin.persist.impl.GenericDaoImpl;
@Repository
public class WarehouseCounterPlaceDaoImpl  extends GenericDaoImpl<WarehouseCounterPlace, Integer> implements IWarehouseCounterPlaceDao{

	@Override
	public WarehouseCounterPlace findDepotAndCounterByPlaceId(int placeId) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(typeNameSpace + ".findDepotAndCounterByPlaceId", placeId);
	}

}
