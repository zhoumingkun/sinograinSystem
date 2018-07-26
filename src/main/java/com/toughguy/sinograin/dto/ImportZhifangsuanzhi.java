package com.toughguy.sinograin.dto;

import java.util.List;

public class ImportZhifangsuanzhi {
	
	private String sampleNum;         //样品编号
	
	private List<ZhifangsuanzhiDTO> items;
	
	private String pingjunzhi;     //平均值
	private String beizhu_1;       //备注1
	private String beizhu_2;       //备注2

	public String getSampleNum() {
		return sampleNum;
	}
	public void setSampleNum(String sampleNum) {
		this.sampleNum = sampleNum;
	}
	public String getPingjunzhi() {
		return pingjunzhi;
	}
	public List<ZhifangsuanzhiDTO> getItems() {
		return items;
	}
	public void setItems(List<ZhifangsuanzhiDTO> items) {
		this.items = items;
	}
	public void setPingjunzhi(String pingjunzhi) {
		this.pingjunzhi = pingjunzhi;
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
