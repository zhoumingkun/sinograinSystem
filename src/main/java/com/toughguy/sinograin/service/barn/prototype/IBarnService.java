package com.toughguy.sinograin.service.barn.prototype;

import com.toughguy.sinograin.dto.SamplingDTO;
import com.toughguy.sinograin.model.barn.Handover;

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
	
	/**
	 * 将检测信息保存并对对样品进行处理
	 * handover 交接单实体类
	 * flag		标志  1 增加  2修改  3 删除
	 * */
	public void dealCheck(Handover handover,int flag);

}
