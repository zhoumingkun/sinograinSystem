package com.toughguy.sinograin.persist.barn.prototype;

import java.util.List;
import java.util.Map;

import com.toughguy.sinograin.model.barn.Switch;
import com.toughguy.sinograin.persist.prototype.IGenericDao;


public interface ISwitchDao extends IGenericDao<Switch, Integer> {
	
	/**
	 * 
	 * @param params 库id
	 */
	public Switch findSwitch();
}
