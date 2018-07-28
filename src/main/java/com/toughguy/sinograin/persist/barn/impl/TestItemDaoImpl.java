package com.toughguy.sinograin.persist.barn.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.toughguy.sinograin.model.barn.TestItem;
import com.toughguy.sinograin.persist.barn.prototype.ITestItemDao;
import com.toughguy.sinograin.persist.impl.GenericDaoImpl;

@Repository
public class TestItemDaoImpl extends GenericDaoImpl<TestItem, Integer> implements ITestItemDao {

	@Override
	public List<TestItem> findResult(int sampleId) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(typeNameSpace + ".findResult",sampleId);
	}

}
