package com.toughguy.sinograin.model.barn;

import com.toughguy.sinograin.util.JsonUtil;

/**
 * 交接单实体类
 * */
public class Handover {
	
	private String sampleIds;			//样品id集
	private String sampleNums;			//样品检测编号集
	private String checkeds;			//检测项集
	
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
	
	@Override
	public String toString(){
		return JsonUtil.objectToJson(this);
	}
}
