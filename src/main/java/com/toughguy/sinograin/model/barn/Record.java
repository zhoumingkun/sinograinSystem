package com.toughguy.sinograin.model.barn;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 档案实体类
 * @author BOBO
 *
 */
public class Record {
	private String pLibraryName;	//直属库
	private String libraryName; 	//库点
	private String position;   //货位号（申请扦样）
	private String sort;    	//分类(品种)
	private String barnType;    //仓型
	private String cangrong;    //仓容
	private String amount;    //数量
	private String gainTime;  //收获年度
	private Date barnTime;   //入库时间（仓库的时间）
	private String quality;  //性质
	private String shape;     //形状
	private double length;     //长度
	private double wide;       //宽度
	private double high;       //高度
	private double measuredVolume;   //测算体积（测量体积）
	private double deductVolume;   //扣除体积
	private double realVolume;     //测算净体积（粮堆实际体积）
	private double realCapacity;    //容重
	private double correctioFactor;   //修正系数
	private double aveDensity;   //平均密度
	private double unQuality;   //测量计算数
	private double grainQuality;  //保管账数量
	private double slip;         //差率
	private String gzdgRummager;  //工作底稿检查人
	private Date gzdgTime;    //工作底稿时间（工作底稿创建时间）
	
	private String[] problem;     //问题
	private String rummager;    //监督检查报告的检查人
	private Date jianduTime;    //监督检查时间（监督检查创建时间）
	
	private int qualityGrade;    //等级
	private String rongzhong;    //容重
	private String shuifen;      //水分
	private String zazhi;        //杂质
	private String kuangwuzhi;    //矿物质
	private String buwanshanli;   //不完善粒
	private String shengmeili;    //生霉粒
	private String sezeqiwei1;    //色泽气味（质量指标）
	private String yingduzhishu;   //硬度指数
	private String mianjinxishuiliang;  //面筋吸水量
	private String zhifangsuanzhi;  //脂肪酸酯
	private String pinchangpingfen;  //品尝评分
	private String sezeqiwei2;      //色泽气味（储存品质指标）
	private int sampleId;          //样品id
	private String jianyanyuan;   //检验员
	private Date jianceTime;      //检测时间（取检测最后的时间）
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
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	public String getBarnType() {
		return barnType;
	}
	public void setBarnType(String barnType) {
		this.barnType = barnType;
	}
	public String getCangrong() {
		return cangrong;
	}
	public void setCangrong(String cangrong) {
		this.cangrong = cangrong;
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
	
	public Date getBarnTime() {
		return barnTime;
	}
	public void setBarnTime(Date barnTime) {
		this.barnTime = barnTime;
	}
	public String getShape() {
		return shape;
	}
	public void setShape(String shape) {
		this.shape = shape;
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
	public double getMeasuredVolume() {
		return measuredVolume;
	}
	public void setMeasuredVolume(double measuredVolume) {
		this.measuredVolume = measuredVolume;
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
	public String getZazhi() {
		return zazhi;
	}
	public void setZazhi(String zazhi) {
		this.zazhi = zazhi;
	}
	public String getKuangwuzhi() {
		return kuangwuzhi;
	}
	public void setKuangwuzhi(String kuangwuzhi) {
		this.kuangwuzhi = kuangwuzhi;
	}
	public String getBuwanshanli() {
		return buwanshanli;
	}
	public void setBuwanshanli(String buwanshanli) {
		this.buwanshanli = buwanshanli;
	}
	public String getShengmeili() {
		return shengmeili;
	}
	public void setShengmeili(String shengmeili) {
		this.shengmeili = shengmeili;
	}
	public String getSezeqiwei1() {
		return sezeqiwei1;
	}
	public void setSezeqiwei1(String sezeqiwei1) {
		this.sezeqiwei1 = sezeqiwei1;
	}
	public String getYingduzhishu() {
		return yingduzhishu;
	}
	public void setYingduzhishu(String yingduzhishu) {
		this.yingduzhishu = yingduzhishu;
	}
	public String getMianjinxishuiliang() {
		return mianjinxishuiliang;
	}
	public void setMianjinxishuiliang(String mianjinxishuiliang) {
		this.mianjinxishuiliang = mianjinxishuiliang;
	}
	public String getZhifangsuanzhi() {
		return zhifangsuanzhi;
	}
	public void setZhifangsuanzhi(String zhifangsuanzhi) {
		this.zhifangsuanzhi = zhifangsuanzhi;
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
	public int getSampleId() {
		return sampleId;
	}
	public void setSampleId(int sampleId) {
		this.sampleId = sampleId;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	
	public String[] getProblem() {
		return problem;
	}
	public void setProblem(String[] problem) {
		this.problem = problem;
	}
	public String getRummager() {
		return rummager;
	}
	public void setRummager(String rummager) {
		this.rummager = rummager;
	}
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	public Date getJianduTime() {
		return jianduTime;
	}
	public void setJianduTime(Date jianduTime) {
		this.jianduTime = jianduTime;
	}
	public String getGzdgRummager() {
		return gzdgRummager;
	}
	public void setGzdgRummager(String gzdgRummager) {
		this.gzdgRummager = gzdgRummager;
	}
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	public Date getGzdgTime() {
		return gzdgTime;
	}
	public void setGzdgTime(Date gzdgTime) {
		this.gzdgTime = gzdgTime;
	}
	public String getJianyanyuan() {
		return jianyanyuan;
	}
	public void setJianyanyuan(String jianyanyuan) {
		this.jianyanyuan = jianyanyuan;
	}
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	public Date getJianceTime() {
		return jianceTime;
	}
	public void setJianceTime(Date jianceTime) {
		this.jianceTime = jianceTime;
	}
	
	
}
