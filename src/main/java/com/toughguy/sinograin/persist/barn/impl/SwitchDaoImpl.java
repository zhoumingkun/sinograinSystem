package com.toughguy.sinograin.persist.barn.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.toughguy.sinograin.model.barn.Switch;
import com.toughguy.sinograin.persist.barn.prototype.ISwitchDao;
import com.toughguy.sinograin.persist.impl.GenericDaoImpl;

@Repository
public class SwitchDaoImpl extends GenericDaoImpl<Switch, Integer> implements ISwitchDao {

	@Override
	public Switch findSwitch() {
		return sqlSessionTemplate.selectOne(typeNameSpace + ".findSwitch");
	}

}
