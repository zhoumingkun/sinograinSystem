package com.toughguy.sinograin.dto;

import java.util.List;

/**
 * 导入不完善粒(玉米)
 * @author Administrator
 *
 */
public class ImportBuwanshanliXM {
	
	private String sampleNum;         //样品编号
	private String daza_pingjunzhi;                   //大杂%平均值
	private String xiaoza_pingjunzhi;                 //小杂%平均值
	private String zazhizongliang_pingjunzhi;        //杂质总量%平均值
	private String kuangwuzhizongliang_pingjunzhi;        //矿物质总量%平均值
	private String yizhongliang_pingjunzhi;            //异种粮（g）平均值
	private String buwanshanli_pingjunzhi;            //不完善粒%平均值
	private String seze_qiwei;                        //色泽、气味
	private String rongzhong_pingjunzhi;              //容重平均值
	private String jianceren;                         //检测人
	private String beizhu_1;                          //备注1
	private String beizhu_2;                          //备注2
	private String beizhu_3;                          //备注3
	private List<BuwanshanliXM_DTO> items;
	public String getSampleNum() {
		return sampleNum;
	}
	public void setSampleNum(String sampleNum) {
		this.sampleNum = sampleNum;
	}
	public String getDaza_pingjunzhi() {
		return daza_pingjunzhi;
	}
	public void setDaza_pingjunzhi(String daza_pingjunzhi) {
		this.daza_pingjunzhi = daza_pingjunzhi;
	}
	public String getXiaoza_pingjunzhi() {
		return xiaoza_pingjunzhi;
	}
	public void setXiaoza_pingjunzhi(String xiaoza_pingjunzhi) {
		this.xiaoza_pingjunzhi = xiaoza_pingjunzhi;
	}
	public String getZazhizongliang_pingjunzhi() {
		return zazhizongliang_pingjunzhi;
	}
	public void setZazhizongliang_pingjunzhi(String zazhizongliang_pingjunzhi) {
		this.zazhizongliang_pingjunzhi = zazhizongliang_pingjunzhi;
	}
	public String getKuangwuzhizongliang_pingjunzhi() {
		return kuangwuzhizongliang_pingjunzhi;
	}
	public void setKuangwuzhizongliang_pingjunzhi(String kuangwuzhizongliang_pingjunzhi) {
		this.kuangwuzhizongliang_pingjunzhi = kuangwuzhizongliang_pingjunzhi;
	}
	public String getYizhongliang_pingjunzhi() {
		return yizhongliang_pingjunzhi;
	}
	public void setYizhongliang_pingjunzhi(String yizhongliang_pingjunzhi) {
		this.yizhongliang_pingjunzhi = yizhongliang_pingjunzhi;
	}
	public String getBuwanshanli_pingjunzhi() {
		return buwanshanli_pingjunzhi;
	}
	public void setBuwanshanli_pingjunzhi(String buwanshanli_pingjunzhi) {
		this.buwanshanli_pingjunzhi = buwanshanli_pingjunzhi;
	}
	
	public String getSeze_qiwei() {
		return seze_qiwei;
	}
	public void setSeze_qiwei(String seze_qiwei) {
		this.seze_qiwei = seze_qiwei;
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
	public String getBeizhu_3() {
		return beizhu_3;
	}
	public void setBeizhu_3(String beizhu_3) {
		this.beizhu_3 = beizhu_3;
	}
	public List<BuwanshanliXM_DTO> getItems() {
		return items;
	}
	public void setItems(List<BuwanshanliXM_DTO> items) {
		this.items = items;
	}
	
	
	
}
