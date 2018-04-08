package com.toughguy.sinograin.model.barn;

import java.sql.Date;

/**
 * 小麦检测报告实体类 （用与页面展示）
 * @author BOBO
 *
 */
public class WheatExaminingReport {

	private String pLibraryName;	//直属库
	private String libraryName; 	//库点
	private String sampleNum;	//检测编号
	private String sampleNo;  	//扦样编号
	private String position ;   //货位号（申请扦样）
	private String sort;    	//分类(品种)
	private String amount;   	//数量
	private String  gainTime;  	//收获年度(生产年份)
	private Date storageTime;	//入库时间（样品室）
	private Date checkApplyTime; //验收申请时间(表的创建时间)
	private Date assignMissionTime; //任务下达时间(表的状态为2的修改时间)
	private Date sampleTime;   	//扦样时间
	private String remark;      //备注
	private double length;        	//长度
	private double wide;			//宽度
	private double high;			//高度	
	private double deductVolume;	//扣除体积（计算粮堆体积）
	private double realVolume ;     //真实体积（粮堆实际体积）
	private double realCapacity;	//实际容重（g/l，实测粮食质量与标准容重器法中粮食容重  相同）
	private double correctioFactor; //修正系数
	private double aveDensity;		//平均密度（标准容器法   kg/m³）
	private double unQuality;		//测量计算数（计算粮食数量）
	private double grainQuality;	//实际粮食质量（同 保管账数量）
	private double slip;			//差率
	private int qualityGrade;		//质量等级（1 一等  2 二等  3 三等）
	private String shuifen_pingjunzhi; // 平均值（%）(水分)
	private String zazhizongliang_1;  //杂质总量B（%）
	private String kuangwuzhihanliang_pingjunzhi;//矿物质含量平均值（%）
	private String buwanshanlihanliang_pingjunzhi_1;//不完善粒含量平均值（%）
	private String yingduzhishu_pingjunzhi;      //硬度指数平均值
	private String sezeqiwei_pingjunzhi;      //色泽气味平均值
	private String pingjunzhiganmianjinzhiliang;  //平均值干面筋质量m2（g）
	private String shimianjin_pingjunzhi;     //湿面筋平均值
	private String pinchangpingfenzhi;  //品尝评分值
	
	private int sampleId;   //样品id（页面展示）
	private String smallSampleNum; //小样编号
	private String taskName; //任务名称（页面展示）
	public String getpLibraryName() {
		return pLibraryName;
	}
	public void setpLibraryName(String pLibraryName) {
		this.pLibraryName = pLibraryName;
	}
	public String getLibraryName() {
		return libraryName;
	}
	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}
	public String getSampleNum() {
		return sampleNum;
	}
	public void setSampleNum(String sampleNum) {
		this.sampleNum = sampleNum;
	}
	public String getSampleNo() {
		return sampleNo;
	}
	public void setSampleNo(String sampleNo) {
		this.sampleNo = sampleNo;
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
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getGainTime() {
		return gainTime;
	}
	public void setGainTime(String gainTime) {
		this.gainTime = gainTime;
	}
	public Date getStorageTime() {
		return storageTime;
	}
	public void setStorageTime(Date storageTime) {
		this.storageTime = storageTime;
	}
	
	public Date getCheckApplyTime() {
		return checkApplyTime;
	}
	public void setCheckApplyTime(Date checkApplyTime) {
		this.checkApplyTime = checkApplyTime;
	}
	public Date getAssignMissionTime() {
		return assignMissionTime;
	}
	public void setAssignMissionTime(Date assignMissionTime) {
		this.assignMissionTime = assignMissionTime;
	}
	public Date getSampleTime() {
		return sampleTime;
	}
	public void setSampleTime(Date sampleTime) {
		this.sampleTime = sampleTime;
	}
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	public double getRealVolume() {
		return realVolume;
	}
	public void setRealVolume(double realVolume) {
		this.realVolume = realVolume;
	}
	public double getRealCapacity() {
		return realCapacity;
	}
	public void setRealCapacity(double realCapacity) {
		this.realCapacity = realCapacity;
	}
	public double getCorrectioFactor() {
		return correctioFactor;
	}
	public void setCorrectioFactor(double correctioFactor) {
		this.correctioFactor = correctioFactor;
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
	public void setUnQuality(double unQuality) {
		this.unQuality = unQuality;
	}
	public double getGrainQuality() {
		return grainQuality;
	}
	public void setGrainQuality(double grainQuality) {
		this.grainQuality = grainQuality;
	}
	public double getSlip() {
		return slip;
	}
	public void setSlip(double slip) {
		this.slip = slip;
	}
	public int getQualityGrade() {
		return qualityGrade;
	}
	public void setQualityGrade(int qualityGrade) {
		this.qualityGrade = qualityGrade;
	}
	public String getShuifen_pingjunzhi() {
		return shuifen_pingjunzhi;
	}
	public void setShuifen_pingjunzhi(String shuifen_pingjunzhi) {
		this.shuifen_pingjunzhi = shuifen_pingjunzhi;
	}
	public String getZazhizongliang_1() {
		return zazhizongliang_1;
	}
	public void setZazhizongliang_1(String zazhizongliang_1) {
		this.zazhizongliang_1 = zazhizongliang_1;
	}
	public String getBuwanshanlihanliang_pingjunzhi_1() {
		return buwanshanlihanliang_pingjunzhi_1;
	}
	public void setBuwanshanlihanliang_pingjunzhi_1(String buwanshanlihanliang_pingjunzhi_1) {
		this.buwanshanlihanliang_pingjunzhi_1 = buwanshanlihanliang_pingjunzhi_1;
	}
	public String getSezeqiwei_pingjunzhi() {
		return sezeqiwei_pingjunzhi;
	}
	public void setSezeqiwei_pingjunzhi(String sezeqiwei_pingjunzhi) {
		this.sezeqiwei_pingjunzhi = sezeqiwei_pingjunzhi;
	}
	public String getPinchangpingfenzhi() {
		return pinchangpingfenzhi;
	}
	public void setPinchangpingfenzhi(String pinchangpingfenzhi) {
		this.pinchangpingfenzhi = pinchangpingfenzhi;
	}
	public String getKuangwuzhihanliang_pingjunzhi() {
		return kuangwuzhihanliang_pingjunzhi;
	}
	public void setKuangwuzhihanliang_pingjunzhi(String kuangwuzhihanliang_pingjunzhi) {
		this.kuangwuzhihanliang_pingjunzhi = kuangwuzhihanliang_pingjunzhi;
	}
	public String getYingduzhishu_pingjunzhi() {
		return yingduzhishu_pingjunzhi;
	}
	public void setYingduzhishu_pingjunzhi(String yingduzhishu_pingjunzhi) {
		this.yingduzhishu_pingjunzhi = yingduzhishu_pingjunzhi;
	}
	public String getPingjunzhiganmianjinzhiliang() {
		return pingjunzhiganmianjinzhiliang;
	}
	public void setPingjunzhiganmianjinzhiliang(String pingjunzhiganmianjinzhiliang) {
		this.pingjunzhiganmianjinzhiliang = pingjunzhiganmianjinzhiliang;
	}
	public String getShimianjin_pingjunzhi() {
		return shimianjin_pingjunzhi;
	}
	public void setShimianjin_pingjunzhi(String shimianjin_pingjunzhi) {
		this.shimianjin_pingjunzhi = shimianjin_pingjunzhi;
	}
	public String getSmallSampleNum() {
		return smallSampleNum;
	}
	public void setSmallSampleNum(String smallSampleNum) {
		this.smallSampleNum = smallSampleNum;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public int getSampleId() {
		return sampleId;
	}
	public void setSampleId(int sampleId) {
		this.sampleId = sampleId;
	}
	
	
}
