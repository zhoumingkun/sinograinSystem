package com.toughguy.sinograin.dto;

import java.util.List;

public class ImportMianjinxishuiliang {
    private String sampleNum;         //样品编号
	
	private List<MianjinxishuiliangDTO> items;
	
	private String pingjunzhi_ganmianjinzhiliang;     //平均值干面筋质量（g）
	private String beizhu_1;       //备注1
	private String beizhu_2;       //备注2
	public String getSampleNum() {
		return sampleNum;
	}
	public void setSampleNum(String sampleNum) {
		this.sampleNum = sampleNum;
	}
	public List<MianjinxishuiliangDTO> getItems() {
		return items;
	}
	public void setItems(List<MianjinxishuiliangDTO> items) {
		this.items = items;
	}
	public String getPingjunzhi_ganmianjinzhiliang() {
		return pingjunzhi_ganmianjinzhiliang;
	}
	public void setPingjunzhi_ganmianjinzhiliang(String pingjunzhi_ganmianjinzhiliang) {
		this.pingjunzhi_ganmianjinzhiliang = pingjunzhi_ganmianjinzhiliang;
	}
	public String getBeizhu_1() {
		return beizhu_1;
	}
	public void setBeizhu_1(String beizhu_1) {
		this.beizhu_1 = beizhu_1;
	}
	public String getBeizhu_2() {
		return beizhu_2;
	}
	public void setBeizhu_2(String beizhu_2) {
		this.beizhu_2 = beizhu_2;
	}
	
	

}
