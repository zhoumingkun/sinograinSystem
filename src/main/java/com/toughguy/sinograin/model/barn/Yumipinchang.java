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
	private Date ym_riqi;				    //日期
	private String ym_pinpingyuan;			//品评员
	private String ym_table_version;		//表格版本
	private String wotouqiwei;          //窝头气味
	private String wotouseze;           //窝头色泽
	private String waiguanxingzhuang;   //外观形状
	private String neibuxingzhuang;     //内部形状
	private String ziwei;               //滋味
	private String pinchangpingfenzhi;  //品尝评分值
	
	public int getSmallSampleId() {
		return smallSampleId;
	}
	public void setSmallSampleId(int smallSampleId) {
		this.smallSampleId = smallSampleId;
	}
	
	public Date getYm_riqi() {
		return ym_riqi;
	}
	public void setYm_riqi(Date ym_riqi) {
		this.ym_riqi = ym_riqi;
	}
	public String getYm_pinpingyuan() {
		return ym_pinpingyuan;
	}
	public void setYm_pinpingyuan(String ym_pinpingyuan) {
		this.ym_pinpingyuan = ym_pinpingyuan;
	}
	public String getYm_table_version() {
		return ym_table_version;
	}
	public void setYm_table_version(String ym_table_version) {
		this.ym_table_version = ym_table_version;
	}
	public String getWotouqiwei() {
		return wotouqiwei;
	}
	public void setWotouqiwei(String wotouqiwei) {
		this.wotouqiwei = wotouqiwei;
	}
	public String getWotouseze() {
		return wotouseze;
	}
	public void setWotouseze(String wotouseze) {
		this.wotouseze = wotouseze;
	}
	public String getWaiguanxingzhuang() {
		return waiguanxingzhuang;
	}
	public void setWaiguanxingzhuang(String waiguanxingzhuang) {
		this.waiguanxingzhuang = waiguanxingzhuang;
	}
	public String getNeibuxingzhuang() {
		return neibuxingzhuang;
	}
	public void setNeibuxingzhuang(String neibuxingzhuang) {
		this.neibuxingzhuang = neibuxingzhuang;
	}
	public String getZiwei() {
		return ziwei;
	}
	public void setZiwei(String ziwei) {
		this.ziwei = ziwei;
	}
	public String getPinchangpingfenzhi() {
		return pinchangpingfenzhi;
	}
	public void setPinchangpingfenzhi(String pinchangpingfenzhi) {
		this.pinchangpingfenzhi = pinchangpingfenzhi;
	}
	@Override
	public String toString(){
		return JsonUtil.objectToJson(this);
	}

}
