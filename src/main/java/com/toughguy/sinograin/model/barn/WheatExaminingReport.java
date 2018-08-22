package com.toughguy.sinograin.model.barn;

import java.sql.Date;
import java.util.List;

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
	private String originPlace; //产地
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
	private String rongzhong;       //容重
	private String shuifen;         //水分
	private String zazhizongliang;   //杂质总量
	private String zazhikuangwuzhi;  //矿物质
	private String buwanshanli;      //不完善粒
	private String yingduzhishu;    //硬度指数
	private String sezeqiwei1;       //色泽气味 （质量指标）
	private String jieguopanding1;    //结果判定（质量指标）
	private String mianjinxishuiliang;  //面筋吸水量
	private String shimianjin;       //湿面筋
	private String pinchangpingfen;    //品尝评分
	private String sezeqiwei2;        //色泽气味(储存品质)
	private String jieguopanding2;    //结果判定（储存品质）
	private String jianceren;        //检测人
	private String jianceshijian;     //检测时间
//	private String shuifen_pingjunzhi; // 平均值（%）(水分)
//	private String zazhizongliang_1;  //杂质总量B（%）
//	private String kuangwuzhihanliang_pingjunzhi;//矿物质含量平均值（%）
//	private String buwanshanlihanliang_pingjunzhi_1;//不完善粒含量平均值（%）
//	private String yingduzhishu_pingjunzhi;      //硬度指数平均值
//	private String sezeqiwei_pingjunzhi;      //色泽气味平均值
//	private String pingjunzhiganmianjinzhiliang;  //平均值干面筋质量m2（g）
//	private String shimianjin_pingjunzhi;     //湿面筋平均值
//	private String pinchangpingfenzhi;  //品尝评分值
//	private String sfjiance;  //水分检测人
//	private String bwsljiance;   //不完善粒检测人
//	private String fenyangjiance;  //不完善粒的分样检测人
//	private String cdjljiance;   //测定记录表检测人
//	private String mjxsljiance;  //面筋吸水量检测人
//	private String mtpfjiance;   //馒头评分检测人
//	private String inspectors;   //检测人集合
//	private Date sfriqi;        //水分日期
//	private Date bwslriqi;      //不完善粒日期
//	private Date cdjlriqi;       //测定记录日期
//	private Date mjxslriqi;     //面筋吸水量日期
//	private Date mtpfriqi;       //馒头评分日期
//	private String inspectionTime;  //检测日期
//	private String smallSampleNum; //小样编号
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
	public String getOriginPlace() {
		return originPlace;
	}
	public void setOriginPlace(String originPlace) {
		this.originPlace = originPlace;
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
	public String getRongzhong() {
		return rongzhong;
	}
	public void setRongzhong(String rongzhong) {
		this.rongzhong = rongzhong;
	}
	public String getShuifen() {
		return shuifen;
	}
	public void setShuifen(String shuifen) {
		this.shuifen = shuifen;
	}
	public String getZazhizongliang() {
		return zazhizongliang;
	}
	public void setZazhizongliang(String zazhizongliang) {
		this.zazhizongliang = zazhizongliang;
	}
	public String getZazhikuangwuzhi() {
		return zazhikuangwuzhi;
	}
	public void setZazhikuangwuzhi(String zazhikuangwuzhi) {
		this.zazhikuangwuzhi = zazhikuangwuzhi;
	}
	public String getBuwanshanli() {
		return buwanshanli;
	}
	public void setBuwanshanli(String buwanshanli) {
		this.buwanshanli = buwanshanli;
	}
	public String getYingduzhishu() {
		return yingduzhishu;
	}
	public void setYingduzhishu(String yingduzhishu) {
		this.yingduzhishu = yingduzhishu;
	}
	public String getSezeqiwei1() {
		return sezeqiwei1;
	}
	public void setSezeqiwei1(String sezeqiwei1) {
		this.sezeqiwei1 = sezeqiwei1;
	}
	public String getJieguopanding1() {
		return jieguopanding1;
	}
	public void setJieguopanding1(String jieguopanding1) {
		this.jieguopanding1 = jieguopanding1;
	}
	public String getMianjinxishuiliang() {
		return mianjinxishuiliang;
	}
	public void setMianjinxishuiliang(String mianjinxishuiliang) {
		this.mianjinxishuiliang = mianjinxishuiliang;
	}
	public String getShimianjin() {
		return shimianjin;
	}
	public void setShimianjin(String shimianjin) {
		this.shimianjin = shimianjin;
	}
	public String getPinchangpingfen() {
		return pinchangpingfen;
	}
	public void setPinchangpingfen(String pinchangpingfen) {
		this.pinchangpingfen = pinchangpingfen;
	}
	public String getSezeqiwei2() {
		return sezeqiwei2;
	}
	public void setSezeqiwei2(String sezeqiwei2) {
		this.sezeqiwei2 = sezeqiwei2;
	}
	public String getJieguopanding2() {
		return jieguopanding2;
	}
	public void setJieguopanding2(String jieguopanding2) {
		this.jieguopanding2 = jieguopanding2;
	}
	public String getJianceren() {
		return jianceren;
	}
	public void setJianceren(String jianceren) {
		this.jianceren = jianceren;
	}
	public String getJianceshijian() {
		return jianceshijian;
	}
	public void setJianceshijian(String jianceshijian) {
		this.jianceshijian = jianceshijian;
	}
	
	
}
