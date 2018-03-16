package com.toughguy.sinograin.model.barn;

import com.toughguy.sinograin.util.JsonUtil;

/**
 * 交接单实体类
 * */
public class Handover {
	
	private String sampleIds;			//样品id集
	private String sampleNums;			//样品编号集
	private String checkeds;			//检测项集
	private String name;				//交接单名
	
	public String getSampleIds() {
		return sampleIds;
	}
	public void setSampleIds(String sampleIds) {
		this.sampleIds = sampleIds;
	}
	public String getSampleNums() {
		return sampleNums;
	}
	public void setSampleNums(String sampleNums) {
		this.sampleNums = sampleNums;
	}
	public String getCheckeds() {
		return checkeds;
	}
	public void setCheckeds(String checkeds) {
		this.checkeds = checkeds;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString(){
		return JsonUtil.objectToJson(this);
	}
}
