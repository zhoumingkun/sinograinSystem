package com.toughguy.sinograin.dto;

import java.util.ArrayList;
import java.util.List;

public class RegisterDTO {
	
	private String id;                                //序号
	private String sampleNo;                          //扦样编号
	private String libraryName;                       //被查库点
	private String position;                          //货物号
	private String sort;                              //品种
	private String quality;                           //性质
	private String amount;                            //代表数量（吨）  
	private String originPlace;                       //产地
	private String gainTime;                          //收获年度
	private String barnTime;                          //入库时间
	private String autograph;                         //扦样员签字
	private String peitongrenSign;                    //现场陪同人员签字
	private String sampleTime;   	                  //扦样日期
	private String remark;                             //备注
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSampleNo() {
		return sampleNo;
	}
	public void setSampleNo(String sampleNo) {
		this.sampleNo = sampleNo;
	}
	public String getLibraryName() {
		return libraryName;
	}
	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getOriginPlace() {
		return originPlace;
	}
	public void setOriginPlace(String originPlace) {
		this.originPlace = originPlace;
	}
	public String getGainTime() {
		return gainTime;
	}
	public void setGainTime(String gainTime) {
		this.gainTime = gainTime;
	}
	public String getBarnTime() {
		return barnTime;
	}
	public void setBarnTime(String barnTime) {
		this.barnTime = barnTime;
	}
	public String getAutograph() {
		return autograph;
	}
	public void setAutograph(String autograph) {
		this.autograph = autograph;
	}
	public String getPeitongrenSign() {
		return peitongrenSign;
	}
	public void setPeitongrenSign(String peitongrenSign) {
		this.peitongrenSign = peitongrenSign;
	}
	public String getSampleTime() {
		return sampleTime;
	}
	public void setSampleTime(String sampleTime) {
		this.sampleTime = sampleTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
	
}
