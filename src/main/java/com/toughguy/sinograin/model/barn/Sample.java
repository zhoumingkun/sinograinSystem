package com.toughguy.sinograin.model.barn;

import java.sql.Date;
import java.text.SimpleDateFormat;

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
	private String sampleWord;	//扦样编号（文字）
	private String sampleNum;	//检测编号
	private String samplePic;	//扦样编号条形码
	private String sampleNumPic;//检测编号条形码
	private String position ;   //货位号（申请扦样）
	private String sort;    	//分类(品种)
	private String originPlace; //产地
	private String quality;    	//性质
	private String amount;   	//数量
	private String remark;  	//备注
	private int sampleState;    //状态    （-1 未扦样， 1 已扦样 ,2 入库,3 已分小样,4已处理）
	private String autograph; 	//签名
	private String  gainTime;  	//收获年度
	private Date sampleTime;   	//扦样时间
	private int pId;          	//扦样登记表id
	private Date storageTime;	//入库时间（样品室）
	private Date barnTime;		//入仓时间（粮仓）
	private String checkeds;	//检测项
	private Date barnTimes;		//入仓时间（粮仓 页面）
	private int placeId;        //存放位置id
	private String dispose;     //处理人
	private String disposeReason;  //处理理由
	private int detectionState;    //检测状态
	
	private String ids;         //id集
	private String formName;	//扦样登记表名（页面展示）
	private String libraryName;	//被查库名（页面展示）
	private String pLibraryName;	//被父查库名（页面展示）
	private int mId;			//工作底稿id（页面）
	private int srId;			//安全报告id （页面）
	private int libraryId;		//被查库id（前台）
	private int pLibraryId;		//被查库id（前台）
	private String XMNumber;		//小麦库存总量（前台）
	private String YMNumber;		//玉米库存总量（前台）
	private String SYYNumber;		//食用油库存总量（前台）
	private String depot;           //样品室（前台）
	private String counter;         //样品室柜（前台）
	private String place;           //样品室柜位置（前台）
	private String storage;          //样品室具体位置（前台）
	
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
	public String getSampleWord() {
		return sampleWord;
	}
	public void setSampleWord(String sampleWord) {
		this.sampleWord = sampleWord;
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
	
	
	public String getSampleNumPic() {
		return sampleNumPic;
	}
	public void setSampleNumPic(String sampleNumPic) {
		this.sampleNumPic = sampleNumPic;
	}
	public int getLibraryId() {
		return libraryId;
	}
	public void setLibraryId(int libraryId) {
		this.libraryId = libraryId;
	}
	
	public int getpLibraryId() {
		return pLibraryId;
	}
	public void setpLibraryId(int pLibraryId) {
		this.pLibraryId = pLibraryId;
	}
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	public Date getStorageTime() {
		return storageTime;
	}
	public void setStorageTime(Date storageTime) {
		this.storageTime = storageTime;
	}
	@JsonFormat(pattern="yyyy-MM",timezone="GMT+8")
	public Date getBarnTime() {	
		return barnTime;
	}
	public void setBarnTime(Date barnTime) {
		this.barnTime = barnTime;
	}
		
	public String getBarnTimes() {
		SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-MM");
		if(barnTime == null){
			return "";
		}
		return dateFm.format(barnTime);
	}
	public void setBarnTimes(Date barnTimes) {
		this.barnTimes = barnTime;
	}
	
	public String getCheckeds() {
		return checkeds;
	}
	public void setCheckeds(String checkeds) {
		this.checkeds = checkeds;
	}
	
	public String getpLibraryName() {
		return pLibraryName;
	}
	public void setpLibraryName(String pLibraryName) {
		this.pLibraryName = pLibraryName;
	}
	
	
	public String getXMNumber() {
		return XMNumber;
	}
	public void setXMNumber(String xMNumber) {
		XMNumber = xMNumber;
	}
	public String getYMNumber() {
		return YMNumber;
	}
	public void setYMNumber(String yMNumber) {
		YMNumber = yMNumber;
	}
	public String getSYYNumber() {
		return SYYNumber;
	}
	public void setSYYNumber(String sYYNumber) {
		SYYNumber = sYYNumber;
	}
	
	public int getPlaceId() {
		return placeId;
	}
	public void setPlaceId(int placeId) {
		this.placeId = placeId;
	}
	
	public String getDepot() {
		return depot;
	}
	public void setDepot(String depot) {
		this.depot = depot;
	}
	public String getCounter() {
		return counter;
	}
	public void setCounter(String counter) {
		this.counter = counter;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getStorage() {
		return storage;
	}
	public void setStorage(String storage) {
		this.storage = storage;
	}
	
	public String getDispose() {
		return dispose;
	}
	public void setDispose(String dispose) {
		this.dispose = dispose;
	}
	public String getDisposeReason() {
		return disposeReason;
	}
	public void setDisposeReason(String disposeReason) {
		this.disposeReason = disposeReason;
	}
	
	public int getDetectionState() {
		return detectionState;
	}
	public void setDetectionState(int detectionState) {
		this.detectionState = detectionState;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	@Override
	public String toString(){
		return JsonUtil.objectToJson(this);
	}
}
