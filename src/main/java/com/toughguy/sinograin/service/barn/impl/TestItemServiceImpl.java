package com.toughguy.sinograin.service.barn.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.toughguy.sinograin.model.barn.TestItem;
import com.toughguy.sinograin.persist.barn.prototype.ITestItemDao;
import com.toughguy.sinograin.service.barn.prototype.ITestItemService;
import com.toughguy.sinograin.service.impl.GenericServiceImpl;

@Service
public class TestItemServiceImpl extends GenericServiceImpl<TestItem, Integer> implements ITestItemService {

	@Override
	public List<TestItem> findResult(int sampleId) {
		// TODO Auto-generated method stub
		return ((ITestItemDao)dao).findResult(sampleId);
	}
	
}
