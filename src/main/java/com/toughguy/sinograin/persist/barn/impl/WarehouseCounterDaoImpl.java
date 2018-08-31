package com.toughguy.sinograin.persist.barn.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.toughguy.sinograin.model.barn.Sample;
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

	@Override
	public List<Sample> findSample(int counterId) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(typeNameSpace + ".findSample", counterId);
	}

}
