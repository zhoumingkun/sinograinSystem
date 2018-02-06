package com.toughguy.sinograin.dto;

import java.util.List;

import com.toughguy.sinograin.model.barn.Register;
import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.util.JsonUtil;

/**
 * 用于将扦样表与表中数据进行转换
 * 表信息
 * 样品信息集合
 * */
public class SamplingDTO {
	
	private Register register;
	private List<Sample> list;
		
	public Register getRegister() {
		return register;
	}
	public void setRegister(Register register) {
		this.register = register;
	}
	public List<Sample> getList() {
		return list;
	}
	public void setList(List<Sample> list) {
		this.list = list;
	}
	
	@Override
	public String toString() {
		return JsonUtil.objectToJson(this);
	}
	
}
