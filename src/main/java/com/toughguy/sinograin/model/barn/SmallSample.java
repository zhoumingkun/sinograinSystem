package com.toughguy.sinograin.model.barn;

import com.toughguy.sinograin.model.AbstractModel;
import com.toughguy.sinograin.util.JsonUtil;

/**
 * 小样实体类
 * */

public class SmallSample extends AbstractModel {

	private static final long serialVersionUID = 3394574318034670671L;
	
	private String smallSampleNum;		//小样编号
	private int sampleId;				//样品id
	private String checkPoint;				//检测项（1 不完善粒、杂质、生霉粒  2 水分 3 硬度 4 脂肪酸值 5 品尝评分 6 卫生  7 加工品质）
	private int checkId;				//检测id
	private String smallSamplePic;		//小样条形码
	private int state;                  //检验单的状态 1，创建  2，编辑
//	private int taskId;                 //任务id
	private String smallSampleWord;     //小样编号文字版
	private int inspectState;           //检验状态 -1待审核 1未通过 2已通过 3草稿
	private String approveRemark;        //审批备注
	private String checkMember;          //校核员
	private String inspector;            //检验员
	private int checkOrderApprovalStatus;  //检验单审批状态  -1待审批   1已通过   2未通过
	
	private String sampleNum;	//检测编号 (页面展示)
	private String sampleWord;  //扦样编号(页面展示文字)
	private String sampleNo;  //扦样编号(页面展示文字)
	private String sort;    	//分类(品种,页面展示)
	public String getSmallSampleNum() { 
		return smallSampleNum;
	}
	public void setSmallSampleNum(String smallSampleNum) {
		this.smallSampleNum = smallSampleNum;
	}
	public int getSampleId() {
		return sampleId;
	}
	public void setSampleId(int sampleId) {
		this.sampleId = sampleId;
	}
	
	public String getCheckPoint() {
		return checkPoint;
	}
	public void setCheckPoint(String checkPoint) {
		this.checkPoint = checkPoint;
	}
	public int getCheckId() {
		return checkId;
	}
	public void setCheckId(int checkId) {
		this.checkId = checkId;
	}
	
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getSampleNum() {
		return sampleNum;
	}
	public void setSampleNum(String sampleNum) {
		this.sampleNum = sampleNum;
	}
	
	public String getSmallSamplePic() {
		return smallSamplePic;
	}
	public void setSmallSamplePic(String smallSamplePic) {
		this.smallSamplePic = smallSamplePic;
	}
	
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
//	public int getTaskId() {
//		return taskId;
//	}
//	public void setTaskId(int taskId) {
//		this.taskId = taskId;
//	}
	
	public String getSampleWord() {
		return sampleWord;
	}
	public String getSmallSampleWord() {
		return smallSampleWord;
	}
	public void setSmallSampleWord(String smallSampleWord) {
		this.smallSampleWord = smallSampleWord;
	}
	public void setSampleWord(String sampleWord) {
		this.sampleWord = sampleWord;
	}
	
	public String getSampleNo() {
		return sampleNo;
	}
	public void setSampleNo(String sampleNo) {
		this.sampleNo = sampleNo;
	}
	
	public int getInspectState() {
		return inspectState;
	}
	public void setInspectState(int inspectState) {
		this.inspectState = inspectState;
	}
	public String getApproveRemark() {
		return approveRemark;
	}
	public void setApproveRemark(String approveRemark) {
		this.approveRemark = approveRemark;
	}
	public String getCheckMember() {
		return checkMember;
	}
	public void setCheckMember(String checkMember) {
		this.checkMember = checkMember;
	}
	public String getInspector() {
		return inspector;
	}
	public void setInspector(String inspector) {
		this.inspector = inspector;
	}
	
	public int getCheckOrderApprovalStatus() {
		return checkOrderApprovalStatus;
	}
	public void setCheckOrderApprovalStatus(int checkOrderApprovalStatus) {
		this.checkOrderApprovalStatus = checkOrderApprovalStatus;
	}
	@Override
	public String toString(){
		return JsonUtil.objectToJson(this);
	}
}
