package com.toughguy.sinograin.model.barn;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.toughguy.sinograin.model.AbstractModel;
import com.toughguy.sinograin.util.JsonUtil;

/**
 * 交接单实体类
 * */
public class Handover extends AbstractModel{
	  
	private static final long serialVersionUID = -7766006711847226668L;
	
	private String sampleIds;			//样品id集
	private String sampleNums;			//样品编号集
	private String checkeds;			//检测项集
	private String name;				//交接单名
	private String remark;              //备注
	private int userId;                //管理员id
	private String sampleAdmin;        //样品管理员
	private String receiptor;           //领取人
	private String returnPerson;         //归还人
	private Date returnTime;             //归还日期
	private int returnState;             //归还状态
	
	private List<Sample> samples;        //样品集（页面展示）
	
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
	
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getSampleAdmin() {
		return sampleAdmin;
	}
	public void setSampleAdmin(String sampleAdmin) {
		this.sampleAdmin = sampleAdmin;
	}
	public String getReceiptor() {
		return receiptor;
	}
	public void setReceiptor(String receiptor) {
		this.receiptor = receiptor;
	}
	
	public String getReturnPerson() {
		return returnPerson;
	}
	public void setReturnPerson(String returnPerson) {
		this.returnPerson = returnPerson;
	}
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	public Date getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}
	
	public int getReturnState() {
		return returnState;
	}
	public void setReturnState(int returnState) {
		this.returnState = returnState;
	}
	@Override
	public String toString(){
		return JsonUtil.objectToJson(this);
	}
	public List<Sample> getSamples() {
		return samples;
	}
	public void setSamples(List<Sample> samples) {
		this.samples = samples;
	}
	
}
