package com.toughguy.sinograin.service.barn.impl;

import org.springframework.stereotype.Service;

import com.toughguy.sinograin.model.barn.TestItem;
import com.toughguy.sinograin.service.barn.prototype.ITestItemService;
import com.toughguy.sinograin.service.impl.GenericServiceImpl;

@Service
public class TestItemServiceImpl extends GenericServiceImpl<TestItem, Integer> implements ITestItemService {
	
}
