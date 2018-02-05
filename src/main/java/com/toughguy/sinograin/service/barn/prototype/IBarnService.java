package com.toughguy.sinograin.service.barn.prototype;

import com.toughguy.sinograin.model.barn.Sample;

public interface IBarnService {
	
	/**
	 * 保存扦样表及表数据
	 * 
	 * */
	public void saveSampleAndRegister(String formName,Sample sample);
}
