package com.toughguy.sinograin.model.barn;

import com.toughguy.sinograin.model.AbstractModel;
import com.toughguy.sinograin.util.JsonUtil;


/**
 * 底稿实体类
 */
@SuppressWarnings("unused")
public class Manuscript extends AbstractModel {
	
	private static final long serialVersionUID = -197840779923600921L;
	
	private double length;        	//长度
	private double wide;			//宽度
	private double high;			//高度	
	private double deductVolume;	//扣除体积（计算粮堆体积）
	private double grainQuality;	//实际粮食质量（同 保管账数量）
	private double verageDensity;	//平均密度
	private double unQuality;		//测量计算数（计算粮食数量）
	private String leader;			//被检查企业负责人
	private String rummager;		//监察人
	private String custodian;		//保管责任人
	private String remark;			//备注
	private int sampleId;			//样品id
	private double correctioFactor; //修正系数
	private double storageCapacity;	//入库容重（g/l）
	private double storageImpurity; //入库杂质（%）
	private double storageWater;	//入库水分含量（%）
	private double realCapacity;	//实际容重（g/l）
	private double realImpurity;    //实际杂质（%）
	private double realWater;       //实际水分含量（%）

	private double measuredVolume ; //测量体积（页面， 粮堆测量体积）
	private double realVolume ;     //真实体积（页面，粮堆测量体积）
	private double aveDensity;		//平均密度（页面）
	
	public double getRealVolume() {
		return length*wide*high - deductVolume;
	}
	public double getMeasuredVolume() {
		return  length*wide*high;
	}
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
	public double getStorageCapacity() {
		return storageCapacity;
	}
	public void setStorageCapacity(double storageCapacity) {
		this.storageCapacity = storageCapacity;
	}
	public double getRealCapacity() {
		return realCapacity;
	}
	public void setRealCapacity(double realCapacity) {
		this.realCapacity = realCapacity;
	}
	public double getStorageImpurity() {
		return storageImpurity;
	}
	public void setStorageImpurity(double storageImpurity) {
		this.storageImpurity = storageImpurity;
	}
	public double getStorageWater() {
		return storageWater;
	}
	public void setStorageWater(double storageWater) {
		this.storageWater = storageWater;
	}
	public double getRealImpurity() {
		return realImpurity;
	}
	public void setRealImpurity(double realImpurity) {
		this.realImpurity = realImpurity;
	}
	public double getRealWater() {
		return realWater;
	}
	public void setRealWater(double realWater) {
		this.realWater = realWater;
	}
	
	@Override
	public String toString(){
		return JsonUtil.objectToJson(this);
	}

}
