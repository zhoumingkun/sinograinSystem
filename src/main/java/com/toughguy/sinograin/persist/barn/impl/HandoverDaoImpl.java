package com.toughguy.sinograin.persist.barn.impl;

import org.springframework.stereotype.Repository;

import com.toughguy.sinograin.model.barn.Handover;
import com.toughguy.sinograin.persist.barn.prototype.IHandoverDao;
import com.toughguy.sinograin.persist.impl.GenericDaoImpl;

@Repository
public class HandoverDaoImpl extends GenericDaoImpl<Handover, Integer> implements IHandoverDao {

}
