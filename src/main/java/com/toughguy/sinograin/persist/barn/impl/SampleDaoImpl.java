package com.toughguy.sinograin.persist.barn.impl;

import org.springframework.stereotype.Repository;

import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.persist.barn.prototype.ISampleDao;
import com.toughguy.sinograin.persist.impl.GenericDaoImpl;

@Repository
public class SampleDaoImpl extends GenericDaoImpl<Sample, Integer> implements ISampleDao {

}
