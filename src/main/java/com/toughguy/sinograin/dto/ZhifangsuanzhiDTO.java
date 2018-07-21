package com.toughguy.sinograin.dto;

import java.util.ArrayList;
import java.util.List;

public class ZhifangsuanzhiDTO {
	
	private int sampleNum;                   //样品编号
	private String shiyangzhiliang;          //试样质量（g）
	private String shiyangshuifen;           //试样水分（%）
	private String koh_rongyeyongliang_1;    //KOH溶液用量（ml）
	private String koh_rongyenongdu;         //KOH溶液浓度（mol/L）
	private String kongbai;                  //空白（ml）
	private String zhifangsuanzhi;           //脂肪酸值
	private String pingjunzhi;               //平均值
	private String beizhu_1;                 //备注1
	private String beizhu_2;                 //备注2
	
	private List<ZhifangsuanzhiDTO> list = new ArrayList<ZhifangsuanzhiDTO>();
	
	public int getSampleNum() {
		return sampleNum;
	}
	public void setSampleNum(int sampleNum) {
		this.sampleNum = sampleNum;
	}
	public String getShiyangzhiliang() {
		return shiyangzhiliang;
	}
	public void setShiyangzhiliang(String shiyangzhiliang) {
		this.shiyangzhiliang = shiyangzhiliang;
	}
	public String getShiyangshuifen() {
		return shiyangshuifen;
	}
	public void setShiyangshuifen(String shiyangshuifen) {
		this.shiyangshuifen = shiyangshuifen;
	}
	public String getKoh_rongyeyongliang_1() {
		return koh_rongyeyongliang_1;
	}
	public void setKoh_rongyeyongliang_1(String koh_rongyeyongliang_1) {
		this.koh_rongyeyongliang_1 = koh_rongyeyongliang_1;
	}
	public String getKoh_rongyenongdu() {
		return koh_rongyenongdu;
	}
	public void setKoh_rongyenongdu(String koh_rongyenongdu) {
		this.koh_rongyenongdu = koh_rongyenongdu;
	}
	public String getKongbai() {
		return kongbai;
	}
	public void setKongbai(String kongbai) {
		this.kongbai = kongbai;
	}
	public String getZhifangsuanzhi() {
		return zhifangsuanzhi;
	}
	public void setZhifangsuanzhi(String zhifangsuanzhi) {
		this.zhifangsuanzhi = zhifangsuanzhi;
	}
	public String getPingjunzhi() {
		return pingjunzhi;
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
	public List<ZhifangsuanzhiDTO> getList() {
		return list;
	}
	public void setList(List<ZhifangsuanzhiDTO> list) {
		this.list = list;
	}
	
	

}
