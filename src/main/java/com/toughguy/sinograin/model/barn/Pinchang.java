package com.toughguy.sinograin.model.barn;

import java.util.Date;

import com.toughguy.sinograin.model.AbstractModel;
import com.toughguy.sinograin.util.JsonUtil;
/*
 * 馒头品尝评分记录表
 * 
 */
public class Pinchang extends AbstractModel{

	private static final long serialVersionUID = 7697008272607613700L;
	
	private String content;				//内容
	private Date pc_riqi;				    //日期
	private String pc_table_version;		//表格版本
	private String pinchangpingfenzhi;  //品尝评分值
	private int smallSampleId;         //小样id
	
	public String getContent() {
		return content;
	}
	public String getPinchangpingfenzhi() {
		return pinchangpingfenzhi;
	}
	public void setPinchangpingfenzhi(String pinchangpingfenzhi) {
		this.pinchangpingfenzhi = pinchangpingfenzhi;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getPc_riqi() {
		return pc_riqi;
	}
	public void setPc_riqi(Date pc_riqi) {
		this.pc_riqi = pc_riqi;
	}
	public String getPc_table_version() {
		return pc_table_version;
	}
	public void setPc_table_version(String pc_table_version) {
		this.pc_table_version = pc_table_version;
	}
	public int getSmallSampleId() {
		return smallSampleId;
	}
	public void setSmallSampleId(int smallSampleId) {
		this.smallSampleId = smallSampleId;
	}
	@Override
	public String toString(){
		return JsonUtil.objectToJson(this);
	}

}
