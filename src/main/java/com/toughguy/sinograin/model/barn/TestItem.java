package com.toughguy.sinograin.model.barn;

import com.toughguy.sinograin.model.AbstractModel;

/**
 * 检测项目实体类
 * @author BOBO
 *
 */
public class TestItem extends AbstractModel{
	
	private static final long serialVersionUID = -8419692870412974730L;
	
	/*(1,容重   2,水分  3,杂质    4,矿物质   5,不完善粒    6,生霉粒   
	 * 7,色泽气味(质量指标) 8,硬度指数  9,面筋吸水量   10,脂肪酸酯   11,品尝评分   
	 * 12,色泽气味(储存品质指标) 13,真菌毒素(黄曲霉毒素B1)
	 * 14,真菌毒素(脱氧雪腐镰刀菌烯醇 )  15, 真菌毒素(玉米赤霉稀酮)
	 * 16,重金属(铅) 17,镉   18,汞   19,砷)
	 */
	private int testItem;    //检测项目 
	private int sampleId;       //样品id
	private String result;      //检测结果
	private String principal;    //负责人
	
	private String sampleNum;    //样品检测编号(页面展示)
	private String checkeds;	 //检测项集(页面展示)
	private String sort;         //品种(页面展示)
	private String sampleNumPic;//检测编号条形码
	private int state;       //确认单状态   -1未归还   1应归还    2已归还
	private String taskName;   //任务名称
	
	public int getTestItem() {
		return testItem;
	}
	public void setTestItem(int testItem) {
		this.testItem = testItem;
	}
	
	public int getSampleId() {
		return sampleId;
	}
	public void setSampleId(int sampleId) {
		this.sampleId = sampleId;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	public String getPrincipal() {
		return principal;
	}
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	//页面展示
	
	public String getSampleNum() {
		return sampleNum;
	}
	public void setSampleNum(String sampleNum) {
		this.sampleNum = sampleNum;
	}
	public String getCheckeds() {
		return checkeds;
	}
	public void setCheckeds(String checkeds) {
		this.checkeds = checkeds;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	
	public String getSampleNumPic() {
		return sampleNumPic;
	}
	public void setSampleNumPic(String sampleNumPic) {
		this.sampleNumPic = sampleNumPic;
	}
	
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	@Override
	public String toString() {
		return "TestItem [testItem=" + testItem + ", sampleId=" + sampleId + ", result=" + result + "]";
	}
	
	
}
