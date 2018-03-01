package com.toughguy.sinograin.model.barn;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.toughguy.sinograin.model.AbstractModel;
import com.toughguy.sinograin.util.JsonUtil;

/**
 * 扦样实体类
 * 
 */
public class Sample extends AbstractModel{

	private static final long serialVersionUID = -3867394433717405144L;
	
	private String sampleNo;  	//扦样编号
	private String sampleNum;	//样品编号
	private String samplePic;	//扦样编号条形码
	private String depot;     	//仓位号（入库后）
	private String position ;   //货位号（申请扦样）
	private String sort;    	//分类(品种)
	private String originPlace; //产地
	private String quality;    	//性质
	private String amount;   	//数量
	private String remark;  	//备注
	private int sampleState;    //状态    （-1 未扦样， 1 已扦样 ,2 入库）
	private String autograph; 	//签名
	private String  gainTime;  	//收获年度
	private Date sampleTime;   	//扦样时间
	private int pId;          	//扦样登记表id
	private String enterprise;	//被检查企业
	
	private String formName;	//扦样登记表名（页面展示）
	private String libraryName;	//被查库名（页面展示）
	private int mId;			//工作底稿id（页面）
	private int srId;			//安全报告id （页面）
	
	public String getFormName() {
		return formName;
	}
	public void setFormName(String formName) {
		this.formName = formName;
	}
	public String getLibraryName() {
		return libraryName;
	}
	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}
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
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	public Date getSampleTime() {
		return sampleTime;
	}
	public void setSampleTime(Date sampleTime) {
		this.sampleTime = sampleTime;
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
	
	public int getSampleState() {
		return sampleState;
	}
	public void setSampleState(int sampleState) {
		this.sampleState = sampleState;
	}
	public String getAutograph() {
		return autograph;
	}
	public void setAutograph(String autograph) {
		this.autograph = autograph;
	}
	public String getGainTime() {
		return gainTime;
	}
	public void setGainTime(String gainTime) {
		this.gainTime = gainTime;
	}
	
	public String getEnterprise() {
		return enterprise;
	}
	public void setEnterprise(String enterprise) {
		this.enterprise = enterprise;
	}
	
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}
	public int getSrId() {
		return srId;
	}
	public void setSrId(int srId) {
		this.srId = srId;
	}
	
	public String getSampleNum() {
		return sampleNum;
	}
	public void setSampleNum(String sampleNum) {
		this.sampleNum = sampleNum;
	}
	public String getSamplePic() {
		return samplePic;
	}
	public void setSamplePic(String samplePic) {
		this.samplePic = samplePic;
	}
	@Override
	public String toString(){
		return JsonUtil.objectToJson(this);
	}
}
