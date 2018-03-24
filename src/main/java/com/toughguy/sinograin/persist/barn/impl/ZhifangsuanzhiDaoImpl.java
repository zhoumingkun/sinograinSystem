package com.toughguy.sinograin.persist.barn.impl;


import org.springframework.stereotype.Repository;

import com.toughguy.sinograin.model.barn.Zhifangsuanzhi;
import com.toughguy.sinograin.persist.barn.prototype.IZhifangsuanzhiDao;
import com.toughguy.sinograin.persist.impl.GenericDaoImpl;
@Repository
public class ZhifangsuanzhiDaoImpl extends GenericDaoImpl<Zhifangsuanzhi, Integer> implements IZhifangsuanzhiDao{

}
