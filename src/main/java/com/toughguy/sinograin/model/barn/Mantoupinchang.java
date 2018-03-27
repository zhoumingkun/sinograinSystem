package com.toughguy.sinograin.model.barn;

import java.util.Date;

import com.toughguy.sinograin.model.AbstractModel;
import com.toughguy.sinograin.util.JsonUtil;
/* 
 * 馒头品尝评分记录表
 * 
 */
public class Mantoupinchang extends AbstractModel{

	private static final long serialVersionUID = -6212354827065877094L;
	
	private int smallSampleId;          //小样id
	private Date riqi;				    //时间
	private String pinpingyuan;			//品评员
	private String table_version;		//表格版本
	private String birong;		        //比容
	private String biaomianseze;		//色泽表面
	private String tanxing;		        //弹性
	private String qiwei;		        //气味
	private String shiwei;		        //食味
	private String renxing;		        //韧性
	private String nianxing;		    //粘性
	private String pinchangpingfenzhi;	//品尝评分值
	public int getSmallSampleId() {
		return smallSampleId;
	}
	public void setSmallSampleId(int smallSampleId) {
		this.smallSampleId = smallSampleId;
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
	public String getBirong() {
		return birong;
	}
	public void setBirong(String birong) {
		this.birong = birong;
	}
	public String getTanxing() {
		return tanxing;
	}
	public void setTanxing(String tanxing) {
		this.tanxing = tanxing;
	}
	public String getQiwei() {
		return qiwei;
	}
	public void setQiwei(String qiwei) {
		this.qiwei = qiwei;
	}
	public String getShiwei() {
		return shiwei;
	}
	public void setShiwei(String shiwei) {
		this.shiwei = shiwei;
	}
	public String getRenxing() {
		return renxing;
	}
	public void setRenxing(String renxing) {
		this.renxing = renxing;
	}
	
	public String getBiaomianseze() {
		return biaomianseze;
	}
	public void setBiaomianseze(String biaomianseze) {
		this.biaomianseze = biaomianseze;
	}
	public String getNianxing() {
		return nianxing;
	}
	public void setNianxing(String nianxing) {
		this.nianxing = nianxing;
	}
	public String getPinchangpingfenzhi() {
		return pinchangpingfenzhi;
	}
	public void setPinchangpingfenzhi(String pinchangpingfenzhi) {
		this.pinchangpingfenzhi = pinchangpingfenzhi;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	@Override
	public String toString(){
		return JsonUtil.objectToJson(this);
	}

}
