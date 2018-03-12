package com.toughguy.sinograin.persist.barn.impl;

import org.springframework.stereotype.Repository;

import com.toughguy.sinograin.model.barn.SampleNo;
import com.toughguy.sinograin.persist.barn.prototype.ISampleNoDao;
import com.toughguy.sinograin.persist.impl.GenericDaoImpl;

@Repository
public class SampleNoDaoImpl extends GenericDaoImpl<SampleNo, Integer> implements ISampleNoDao {

}
