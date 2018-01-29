package com.toughguy.sinograin.model.barn;

import com.toughguy.sinograin.model.AbstractModel;

/**
 * 扦样实体类
 * 
 */
public class Sample extends AbstractModel{

	private static final long serialVersionUID = -3867394433717405144L;
	
	private String sampleNo;  //样品编号
	private String depot;     //仓库号
	private String position ;   // 货位号
	private String sort;     // 分类(品种)
	private String originPlace;   //产地
	private String quality;    //性质
	private String amount;   //数量
	private String remark;   //备注
	private String state;    //状态
	private String autograph; //签名
	private String source;    //来源（被查库点）
	private String  gainTime;  //收获年度
	private int pId;          //扦样登记表id
	
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getSampleNo() {
		return sampleNo;
	}
	public void setSampleNo(String sampleNo) {
		this.sampleNo = sampleNo;
	}
	public String getDepot() {
		return depot;
	}
	public void setDepot(String depot) {
		this.depot = depot;
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
	public String getOriginPlace() {
		return originPlace;
	}
	public void setOriginPlace(String originPlace) {
		this.originPlace = originPlace;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getAutograph() {
		return autograph;
	}
	public void setAutograph(String autograph) {
		this.autograph = autograph;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getGainTime() {
		return gainTime;
	}
	public void setGainTime(String gainTime) {
		this.gainTime = gainTime;
	}

}
