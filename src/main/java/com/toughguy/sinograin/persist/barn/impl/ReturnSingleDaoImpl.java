package com.toughguy.sinograin.persist.barn.impl;


import org.springframework.stereotype.Repository;

import com.toughguy.sinograin.model.barn.ReturnSingle;
import com.toughguy.sinograin.persist.barn.prototype.IReturnSingleDao;
import com.toughguy.sinograin.persist.impl.GenericDaoImpl;

@Repository
public class ReturnSingleDaoImpl extends GenericDaoImpl<ReturnSingle, Integer> implements IReturnSingleDao {

	@Override
	public void updateSampleIdsOfNull(ReturnSingle returnSingle) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.update(typeNameSpace + ".updateSampleIdsOfNull",returnSingle);
	}

}
