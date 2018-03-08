package com.toughguy.sinograin.model.barn;

import java.util.Date;

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
	//private double grainQuality;	//实际粮食质量（同 保管账数量）
	//private double verageDensity;	//平均密度
	private double unQuality;		//测量计算数（计算粮食数量）
	private String leader;			//被检查企业负责人
	private String rummager;		//检查人
	private String custodian;		//保管责任人
	private String remark;			//备注
	private int sampleId;			//样品id
	private double correctioFactor; //修正系数
	private double storageCapacity;	//入库容重（g/l）
	private double storageImpurity; //入库杂质（%）
	private double storageWater;	//入库水分含量（%）
	private double realCapacity;	//实际容重（g/l，实测粮食质量与标准容重器法中粮食容重  相同）
	private double realImpurity;    //实际杂质（%）
	private double realWater;       //实际水分含量（%）
	private int storge;				//储存形式（1 常规  2 非常规）
	private int qualityGrade;		//质量等级（1 一等  2 二等  3 三等）
	private int putWay;				//入仓方式（1 机械入仓  2人工入仓）
	private String barnType;		//仓房类型
	private String isMatch;			//账实是否相符
	
	private double lossWater; 		//水分减量
	private double lossNature;		//自然损耗
	private double checkNum;		//检查计算数
	private double difference;		//差数
	private double slip;			//差率
	private String result;			//不符原因
	private double measuredVolume ; //测量体积（ 粮堆测量体积）
	private double realVolume ;     //真实体积（粮堆实际体积）
	private double aveDensity;		//平均密度（标准容器法   kg/m³）
	private Date realCheckedTime;	//检查时间
	
	private double loss;          	//合计损耗（页面）
	
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
	
	public int getStorge() {
		return storge;
	}
	public void setStorge(int storge) {
		this.storge = storge;
	}
	public int getQualityGrade() {
		return qualityGrade;
	}
	public void setQualityGrade(int qualityGrade) {
		this.qualityGrade = qualityGrade;
	}
	public int getPutWay() {
		return putWay;
	}
	public void setPutWay(int putWay) {
		this.putWay = putWay;
	}
	
	public double getCorrectioFactor() {
		return correctioFactor;
	}
	public void setCorrectioFactor(double correctioFactor) {
		this.correctioFactor = correctioFactor;
	}
	public double getLossWater() {
		return lossWater;
	}
	public void setLossWater(double lossWater) {
		this.lossWater = lossWater;
	}
	public double getLossNature() {
		return lossNature;
	}
	public void setLossNature(double lossNature) {
		this.lossNature = lossNature;
	}
	public double getCheckNum() {
		return checkNum;
	}
	public void setCheckNum(double checkNum) {
		this.checkNum = checkNum;
	}
	public double getDifference() {
		return difference;
	}
	public void setDifference(double difference) {
		this.difference = difference;
	}
	public double getSlip() {
		return slip;
	}
	public void setSlip(double slip) {
		this.slip = slip;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public double getMeasuredVolume() {
		return measuredVolume;
	}
	public void setMeasuredVolume(double measuredVolume) {
		this.measuredVolume = measuredVolume;
	}
	public double getAveDensity() {
		return aveDensity;
	}
	public void setAveDensity(double aveDensity) {
		this.aveDensity = aveDensity;
	}
	public double getUnQuality() {
		return unQuality;
	}
	
	
	public String getBarnType() {
		return barnType;
	}
	public void setBarnType(String barnType) {
		this.barnType = barnType;
	}
	public double getRealVolume() {
		return realVolume;
	}
	public void setRealVolume(double realVolume) {
		this.realVolume = realVolume;
	}
	public double getLoss() {
		return lossWater+lossNature;
	}
	public void setLoss() {
		this.loss = lossWater+lossNature;
	}
	public Date getRealCheckedTime() {
		return realCheckedTime;
	}
	public void setRealCheckedTime(Date realCheckedTime) {
		this.realCheckedTime = realCheckedTime;
	}
	
	public String getIsMatch() {
		return isMatch;
	}
	public void setIsMatch(String isMatch) {
		this.isMatch = isMatch;
	}
	@Override
	public String toString(){
		return JsonUtil.objectToJson(this);
	}

}
