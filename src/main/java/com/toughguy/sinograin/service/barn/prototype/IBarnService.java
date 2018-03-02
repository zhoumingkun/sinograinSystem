package com.toughguy.sinograin.service.barn.prototype;

import com.toughguy.sinograin.dto.SamplingDTO;

public interface IBarnService {
	
	/**
	 * 保存扦样表及表数据
	 * 
	 * */
	public void saveSampleAndRegister(SamplingDTO sampleDTO);
	/**
	 * 修改或保存扦样表及表数据
	 * 
	 * */
	public void saveOrEditAll(SamplingDTO sampleDTO);
}
