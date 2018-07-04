package com.toughguy.sinograin.persist.barn.impl;

import org.springframework.stereotype.Repository;

import com.toughguy.sinograin.model.barn.WarehouseCounter;
import com.toughguy.sinograin.persist.barn.prototype.IWarehouseCounterDao;
import com.toughguy.sinograin.persist.impl.GenericDaoImpl;
@Repository
public class WarehouseCounterDaoImpl  extends GenericDaoImpl<WarehouseCounter, Integer> implements IWarehouseCounterDao{

	@Override
	public WarehouseCounter findByCounter(String counter) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(typeNameSpace + ".findByCounter", counter);
	}

}
