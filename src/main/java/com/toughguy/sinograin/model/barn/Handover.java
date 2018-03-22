package com.toughguy.sinograin.model.barn;

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
	@Override
	public String toString(){
		return JsonUtil.objectToJson(this);
	}
}
