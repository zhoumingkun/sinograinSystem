package com.toughguy.sinograin.persist.barn.impl;

import org.springframework.stereotype.Repository;

import com.toughguy.sinograin.model.barn.Pinchang;
import com.toughguy.sinograin.persist.barn.prototype.IPinchangDao;
import com.toughguy.sinograin.persist.impl.GenericDaoImpl;

@Repository
public class PinchangDaoImpl extends GenericDaoImpl<Pinchang, Integer> implements IPinchangDao {

}
