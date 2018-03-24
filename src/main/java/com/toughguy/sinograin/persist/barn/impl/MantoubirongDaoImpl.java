package com.toughguy.sinograin.persist.barn.impl;

import org.springframework.stereotype.Repository;

import com.toughguy.sinograin.model.barn.Mantoubirong;
import com.toughguy.sinograin.persist.barn.prototype.IMantoubirongDao;
import com.toughguy.sinograin.persist.impl.GenericDaoImpl;

@Repository
public class MantoubirongDaoImpl extends GenericDaoImpl<Mantoubirong, Integer> implements IMantoubirongDao{

}
