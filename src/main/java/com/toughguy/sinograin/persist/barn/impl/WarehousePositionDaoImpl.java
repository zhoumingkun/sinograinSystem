package com.toughguy.sinograin.persist.barn.impl;

import org.springframework.stereotype.Repository;

import com.toughguy.sinograin.model.barn.WarehousePosition;
import com.toughguy.sinograin.persist.barn.prototype.IWarehousePositionDao;
import com.toughguy.sinograin.persist.impl.GenericDaoImpl;
@Repository
public class WarehousePositionDaoImpl  extends GenericDaoImpl<WarehousePosition, Integer> implements IWarehousePositionDao{

}
