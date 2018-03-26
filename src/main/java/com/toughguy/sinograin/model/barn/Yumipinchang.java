package com.toughguy.sinograin.model.barn;

import java.util.Date;

import com.toughguy.sinograin.model.AbstractModel;
import com.toughguy.sinograin.util.JsonUtil;
/*
 * 馒头品尝评分记录表
 * 
 */
public class Yumipinchang extends AbstractModel{

	
	private static final long serialVersionUID = 4139049675415615508L;
	
	private int smallSampleId;           //小样id
	private String content;				//内容
	private Date riqi;				    //日期
	private String pinpingyuan;			//品评员
	private String table_version;		//表格版本
	
	
	
	public int getSmallSampleId() {
		return smallSampleId;
	}
	public void setSmallSampleId(int smallSampleId) {
		this.smallSampleId = smallSampleId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRiqi() {
		return riqi;
	}
	public void setRiqi(Date riqi) {
		this.riqi = riqi;
	}
	public String getPinpingyuan() {
		return pinpingyuan;
	}
	public void setPinpingyuan(String pinpingyuan) {
		this.pinpingyuan = pinpingyuan;
	}
	public String getTable_version() {
		return table_version;
	}
	public void setTable_version(String table_version) {
		this.table_version = table_version;
	}
	
	
	@Override
	public String toString(){
		return JsonUtil.objectToJson(this);
	}

}
