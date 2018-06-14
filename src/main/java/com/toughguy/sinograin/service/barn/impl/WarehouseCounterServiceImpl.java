package com.toughguy.sinograin.service.barn.impl;

import org.springframework.stereotype.Service;

import com.toughguy.sinograin.model.barn.WarehouseCounter;
import com.toughguy.sinograin.service.barn.prototype.IWarehouseCounterService;
import com.toughguy.sinograin.service.impl.GenericServiceImpl;
@Service
public class WarehouseCounterServiceImpl extends GenericServiceImpl<WarehouseCounter, Integer> implements IWarehouseCounterService{

}
