package com.toughguy.sinograin.dto;

import java.util.ArrayList;
import java.util.List;

public class BuwanshanliDTO {
	
	private int sampleNum;                            //样品编号
	private int shiyanghao;                           //试样号
	private String dayangzhiliang;                    //大样质量（g）
	private String dazazhilaing;                      //大杂质量（g）
	private String daza_cedingzhi;                    //大杂%测定值
	private String daza_pingjunzhi;                   //大杂%平均值
	private String xiaoyangzhiliang;                  //小样质量（g）
	private String xiaozazhiliang;                    //小杂质量（g）
	private String xiaoza_cedingzhi;                  //小杂%测定值
	private String xiaoza_pingjunzhi;                 //小杂%平均值
	private String zazhizongliang_cedingzhi;          //杂质总量%测定值
	private String zazhizongliang__pingjunzhi;        //杂质总量%平均值
	private String buwanshanli;                       //不完善粒（g）
	private String buwanshanli_cedingzhi;             //不完善粒%测定值
	private String buwanshanli_pingjunzhi;            //不完善粒%平均值
	private String shengmeili;                        //生霉粒(g)
	private String shengmeili_cedingzhi;              //生霉粒(g)测定值
	private String shengmeili_pingjunzhi;             //生霉粒(g)平均值
	private String seze_qiwei;                        //色泽、气味
	private String rongzhong_cedingzhi;               //容重测定值
	private String rongzhong_pingjunzhi;              //容重平均值
	private String jianceren;                         //检测人
	private String beizhu_1;                          //备注1
	private String beizhu_2;                          //备注2
	

	public int getSampleNum() {
		return sampleNum;
	}

	public void setSampleNum(int sampleNum) {
		this.sampleNum = sampleNum;
	}

	public int getShiyanghao() {
		return shiyanghao;
	}

	public void setShiyanghao(int shiyanghao) {
		this.shiyanghao = shiyanghao;
	}

	public String getDayangzhiliang() {
		return dayangzhiliang;
	}

	public void setDayangzhiliang(String dayangzhiliang) {
		this.dayangzhiliang = dayangzhiliang;
	}

	public String getDazazhilaing() {
		return dazazhilaing;
	}

	public void setDazazhilaing(String dazazhilaing) {
		this.dazazhilaing = dazazhilaing;
	}

	public String getDaza_cedingzhi() {
		return daza_cedingzhi;
	}

	public void setDaza_cedingzhi(String daza_cedingzhi) {
		this.daza_cedingzhi = daza_cedingzhi;
	}

	public String getDaza_pingjunzhi() {
		return daza_pingjunzhi;
	}

	public void setDaza_pingjunzhi(String daza_pingjunzhi) {
		this.daza_pingjunzhi = daza_pingjunzhi;
	}

	public String getXiaoyangzhiliang() {
		return xiaoyangzhiliang;
	}

	public void setXiaoyangzhiliang(String xiaoyangzhiliang) {
		this.xiaoyangzhiliang = xiaoyangzhiliang;
	}

	public String getXiaozazhiliang() {
		return xiaozazhiliang;
	}

	public void setXiaozazhiliang(String xiaozazhiliang) {
		this.xiaozazhiliang = xiaozazhiliang;
	}

	public String getXiaoza_cedingzhi() {
		return xiaoza_cedingzhi;
	}

	public void setXiaoza_cedingzhi(String xiaoza_cedingzhi) {
		this.xiaoza_cedingzhi = xiaoza_cedingzhi;
	}

	public String getXiaoza_pingjunzhi() {
		return xiaoza_pingjunzhi;
	}

	public void setXiaoza_pingjunzhi(String xiaoza_pingjunzhi) {
		this.xiaoza_pingjunzhi = xiaoza_pingjunzhi;
	}

	public String getZazhizongliang_cedingzhi() {
		return zazhizongliang_cedingzhi;
	}

	public void setZazhizongliang_cedingzhi(String zazhizongliang_cedingzhi) {
		this.zazhizongliang_cedingzhi = zazhizongliang_cedingzhi;
	}

	public String getZazhizongliang__pingjunzhi() {
		return zazhizongliang__pingjunzhi;
	}

	public void setZazhizongliang__pingjunzhi(String zazhizongliang__pingjunzhi) {
		this.zazhizongliang__pingjunzhi = zazhizongliang__pingjunzhi;
	}

	public String getBuwanshanli() {
		return buwanshanli;
	}

	public void setBuwanshanli(String buwanshanli) {
		this.buwanshanli = buwanshanli;
	}

	public String getBuwanshanli_cedingzhi() {
		return buwanshanli_cedingzhi;
	}

	public void setBuwanshanli_cedingzhi(String buwanshanli_cedingzhi) {
		this.buwanshanli_cedingzhi = buwanshanli_cedingzhi;
	}

	public String getBuwanshanli_pingjunzhi() {
		return buwanshanli_pingjunzhi;
	}

	public void setBuwanshanli_pingjunzhi(String buwanshanli_pingjunzhi) {
		this.buwanshanli_pingjunzhi = buwanshanli_pingjunzhi;
	}

	public String getShengmeili() {
		return shengmeili;
	}

	public void setShengmeili(String shengmeili) {
		this.shengmeili = shengmeili;
	}

	public String getShengmeili_cedingzhi() {
		return shengmeili_cedingzhi;
	}

	public void setShengmeili_cedingzhi(String shengmeili_cedingzhi) {
		this.shengmeili_cedingzhi = shengmeili_cedingzhi;
	}

	public String getShengmeili_pingjunzhi() {
		return shengmeili_pingjunzhi;
	}

	public void setShengmeili_pingjunzhi(String shengmeili_pingjunzhi) {
		this.shengmeili_pingjunzhi = shengmeili_pingjunzhi;
	}

	public String getSeze_qiwei() {
		return seze_qiwei;
	}

	public void setSeze_qiwei(String seze_qiwei) {
		this.seze_qiwei = seze_qiwei;
	}

	public String getRongzhong_cedingzhi() {
		return rongzhong_cedingzhi;
	}

	public void setRongzhong_cedingzhi(String rongzhong_cedingzhi) {
		this.rongzhong_cedingzhi = rongzhong_cedingzhi;
	}

	public String getRongzhong_pingjunzhi() {
		return rongzhong_pingjunzhi;
	}

	public void setRongzhong_pingjunzhi(String rongzhong_pingjunzhi) {
		this.rongzhong_pingjunzhi = rongzhong_pingjunzhi;
	}

	public String getJianceren() {
		return jianceren;
	}

	public void setJianceren(String jianceren) {
		this.jianceren = jianceren;
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
