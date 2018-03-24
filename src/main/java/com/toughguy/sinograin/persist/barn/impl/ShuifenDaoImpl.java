package com.toughguy.sinograin.persist.barn.impl;

import org.springframework.stereotype.Repository;

import com.toughguy.sinograin.model.barn.Shuifen;
import com.toughguy.sinograin.persist.barn.prototype.IShuifenDao;
import com.toughguy.sinograin.persist.impl.GenericDaoImpl;

@Repository
public class ShuifenDaoImpl extends GenericDaoImpl<Shuifen, Integer> implements IShuifenDao {

}
	