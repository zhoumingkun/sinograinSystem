package com.toughguy.sinograin.persist.barn.impl;


import org.springframework.stereotype.Repository;

import com.toughguy.sinograin.model.barn.TestItem;
import com.toughguy.sinograin.persist.barn.prototype.ITestItemDao;
import com.toughguy.sinograin.persist.impl.GenericDaoImpl;

@Repository
public class TestItemDaoImpl extends GenericDaoImpl<TestItem, Integer> implements ITestItemDao {

}
