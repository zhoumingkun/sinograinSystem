package com.toughguy.sinograin.persist.barn.impl;

import org.springframework.stereotype.Repository;

import com.toughguy.sinograin.model.barn.Warehouse;
import com.toughguy.sinograin.persist.barn.prototype.IWarehouseDao;
import com.toughguy.sinograin.persist.impl.GenericDaoImpl;
@Repository
public class WarehouseDaoImpl  extends GenericDaoImpl<Warehouse, Integer> implements IWarehouseDao{

}
