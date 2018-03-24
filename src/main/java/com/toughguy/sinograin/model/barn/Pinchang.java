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
	private Date riqi;				    //日期
	private String table_version;		//表格版本
	private String pinchangpingfenzhi;  //品尝评分值
	
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
	public Date getRiqi() {
		return riqi;
	}
	public void setRiqi(Date riqi) {
		this.riqi = riqi;
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
