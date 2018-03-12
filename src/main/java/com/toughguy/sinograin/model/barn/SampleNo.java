package com.toughguy.sinograin.model.barn;

import com.toughguy.sinograin.util.JsonUtil;

public class SampleNo {
	
	private int id;
	private String prefix;
	private int num;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	@Override
	public String toString(){
		return JsonUtil.objectToJson(this);
	}
	
	
}
