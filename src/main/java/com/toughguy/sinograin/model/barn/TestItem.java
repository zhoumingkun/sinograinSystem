package com.toughguy.sinograin.model.barn;

import com.toughguy.sinograin.model.AbstractModel;

/**
 * 检测项目实体类
 * @author BOBO
 *
 */
public class TestItem extends AbstractModel{
	
	private static final long serialVersionUID = -8419692870412974730L;
	
	/*(1,容重   2,水分  3,杂质    3.1,矿物质   4,不完善粒    4.1,生霉粒   
	 * 5,色泽气味(质量指标) 6,面筋吸水量   7,脂肪酸酯   8,品尝评分   
	 * 9,色泽气味(储存品质指标) 10,真菌毒素    10.1,黄曲霉毒素B1
	 * 10.2,脱氧雪腐     10.3,镰刀菌烯醇      10.4, 玉米赤霉稀酮
	 * 11,重金属   11.1,铅    11.2,镉   11.3,汞   11.4,砷)
	 */
	private Double testItem;    //检测项目 
	private int sampleId;       //样品id
	private String result;      //检测结果
	private String principal;    //负责人
	
	private String sampleNum;    //样品检测编号(页面展示)
	private String checkeds;	 //检测项集(页面展示)
	
	public Double getTestItem() {
		return testItem;
	}
	public void setTestItem(Double testItem) {
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
	@Override
	public String toString() {
		return "TestItem [testItem=" + testItem + ", sampleId=" + sampleId + ", result=" + result + "]";
	}
	
	
}
