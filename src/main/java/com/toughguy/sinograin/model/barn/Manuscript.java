package com.toughguy.sinograin.model.barn;

import com.toughguy.sinograin.model.AbstractModel;
import com.toughguy.sinograin.util.JsonUtil;


/**
 * 底稿实体类
 */
public class Manuscript extends AbstractModel {
	
	private static final long serialVersionUID = -197840779923600921L;
	
	private double length;        	//长度
	private double wide;			//宽度
	private double high;			//高度	
	private double deductVolume;	//扣除体积
	private double grainQuality;	//实际粮食质量
	private double capacity;		//容量
	private double verageDensity;	//平均密度
	private double unQuality;		//测量计算数
	private String leader;			//被检查企业负责人
	private String rummager;		//监察人
	private String custodian;		//保管责任人
	private String remark;			//备注
	private int sampleId;			//样品id
	
	
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getWide() {
		return wide;
	}
	public void setWide(double wide) {
		this.wide = wide;
	}
	public double getHigh() {
		return high;
	}
	public void setHigh(double high) {
		this.high = high;
	}
	public double getDeductVolume() {
		return deductVolume;
	}
	public void setDeductVolume(double deductVolume) {
		this.deductVolume = deductVolume;
	}
	public double getGrainQuality() {
		return grainQuality;
	}
	public void setGrainQuality(double grainQuality) {
		this.grainQuality = grainQuality;
	}
	public double getCapacity() {
		return capacity;
	}
	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}
	public double getVerageDensity() {
		return verageDensity;
	}
	public void setVerageDensity(double verageDensity) {
		this.verageDensity = verageDensity;
	}
	public double getUnQuality() {
		return unQuality;
	}
	public void setUnQuality(double unQuality) {
		this.unQuality = unQuality;
	}
	public String getLeader() {
		return leader;
	}
	public void setLeader(String leader) {
		this.leader = leader;
	}
	public String getRummager() {
		return rummager;
	}
	public void setRummager(String rummager) {
		this.rummager = rummager;
	}
	public String getCustodian() {
		return custodian;
	}
	public void setCustodian(String custodian) {
		this.custodian = custodian;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getSampleId() {
		return sampleId;
	}
	public void setSampleId(int sampleId) {
		this.sampleId = sampleId;
	}
	
	@Override
	public String toString(){
		return JsonUtil.objectToJson(this);
	}

}
