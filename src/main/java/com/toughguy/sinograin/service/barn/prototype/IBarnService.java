package com.toughguy.sinograin.service.barn.prototype;

import com.toughguy.sinograin.dto.SamplingDTO;
import com.toughguy.sinograin.model.barn.Handover;
import com.toughguy.sinograin.model.barn.Sample;

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
	 * deleteIds 修改交接单时，删除的样品id
	 * */
	public void dealCheck(Handover handover,int flag,String[] deleteIds);
	
	/**
	 * 实现扫码将样品分小样
	 * sample  样品实体
	 * */
	public void saveSmallSample(Sample sample);

}
