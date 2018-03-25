package com.toughguy.sinograin.model.barn;

import java.util.Date;

import com.toughguy.sinograin.model.AbstractModel;
import com.toughguy.sinograin.util.JsonUtil;
/**
 * 脂肪酸值测定记录
 * 
 */
public class Zhifangsuanzhi extends AbstractModel{
	
	
	private static final long serialVersionUID = 6946190986921577777L;

	
	private int smallSampleId;                      // 小样ID 
	private String table_version;                   //表格版本号
	private Date riqi ;                             //日期
	private String shiwen ;                           //室温
	private String xiangduishidu;                   //相对湿度
	private String jiancefangfa;                    //检测方法
	private String yiqishebei_mingcheng_1;          //仪器设备名称1
	private String yiqishebei_mingcheng_2;          //仪器设备名称2
	private String yiqishebei_bianhao_1;            //仪器设备编号1
	private String yiqishebei_bianhao_2;            //仪器设备编号2
	private String shiyangzhiliang_1;               //试样质量m（g）1
	private String shiyangzhiliang_2;               //试样质量m（g）2
	private String shiyangshuifen;                  //试样水分W（%）
	private String koh_rongyenongdu;                //KOH溶液浓度c（mol/L)
	private String didingzhongdiandushu_1;          //滴定终点读数V2（mL）1
	private String didingzhongdiandushu_2;          //滴定终点读数V2（mL）2
	private String didingqishidushu_1;              //滴定起始读数V1（mL）1
	private String didingqishidushu_2;              //滴定起始读数V1（mL）1
	private String koh_rongyeyongliang_1;           //KOH溶液用量V（mL）1
	private String koh_rongyeyongliang_2;           //KOH溶液用量V（mL）2
	private String kongbaishiyan_koh_yongliang;     //空白试验KOH用量V0（mL）
	private String zhifangsuanzhi_1;                //脂肪酸值（mgKOH/100g干基）1
	private String zhifangsuanzhi_2;                //脂肪酸值（mgKOH/100g干基）2
	private String pingjunzhi;                      //平均值（mgKOH/100g干基）
//	private String pingxingcha;                     //平行差
//	private String xiangduicha;                     //相对差（%）
	private String pingxingcha_xiangduicha;         //平行差或相对差
	private String pingxingcha_xiangduicha_zhi;      //平行差或相对差的值
	private String beizhu;                          //备注
	private String jiance;                          //检测
	private String jiaohe;                          //校核
	
	private String sampleNum;                      //样品编号（页面展示）
	private String sort;                            //品种（页面展示）
	
	public int getSmallSampleId() {
		return smallSampleId;
	}
	public void setSmallSampleId(int smallSampleId) {
		this.smallSampleId = smallSampleId;
	}
	public String getTable_version() {
		return table_version;
	}
	public void setTable_version(String table_version) {
		this.table_version = table_version;
	}
	public Date getRiqi() {
		return riqi;
	}
	public void setRiqi(Date riqi) {
		this.riqi = riqi;
	}
	
	public String getShiwen() {
		return shiwen;
	}
	public void setShiwen(String shiwen) {
		this.shiwen = shiwen;
	}
	public String getXiangduishidu() {
		return xiangduishidu;
	}
	public void setXiangduishidu(String xiangduishidu) {
		this.xiangduishidu = xiangduishidu;
	}
	public String getJiancefangfa() {
		return jiancefangfa;
	}
	public void setJiancefangfa(String jiancefangfa) {
		this.jiancefangfa = jiancefangfa;
	}
	public String getYiqishebei_mingcheng_1() {
		return yiqishebei_mingcheng_1;
	}
	public void setYiqishebei_mingcheng_1(String yiqishebei_mingcheng_1) {
		this.yiqishebei_mingcheng_1 = yiqishebei_mingcheng_1;
	}
	public String getYiqishebei_mingcheng_2() {
		return yiqishebei_mingcheng_2;
	}
	public void setYiqishebei_mingcheng_2(String yiqishebei_mingcheng_2) {
		this.yiqishebei_mingcheng_2 = yiqishebei_mingcheng_2;
	}
	public String getYiqishebei_bianhao_1() {
		return yiqishebei_bianhao_1;
	}
	public void setYiqishebei_bianhao_1(String yiqishebei_bianhao_1) {
		this.yiqishebei_bianhao_1 = yiqishebei_bianhao_1;
	}
	public String getYiqishebei_bianhao_2() {
		return yiqishebei_bianhao_2;
	}
	public void setYiqishebei_bianhao_2(String yiqishebei_bianhao_2) {
		this.yiqishebei_bianhao_2 = yiqishebei_bianhao_2;
	}
	public String getShiyangzhiliang_1() {
		return shiyangzhiliang_1;
	}
	public void setShiyangzhiliang_1(String shiyangzhiliang_1) {
		this.shiyangzhiliang_1 = shiyangzhiliang_1;
	}
	public String getShiyangzhiliang_2() {
		return shiyangzhiliang_2;
	}
	public void setShiyangzhiliang_2(String shiyangzhiliang_2) {
		this.shiyangzhiliang_2 = shiyangzhiliang_2;
	}
	public String getShiyangshuifen() {
		return shiyangshuifen;
	}
	public void setShiyangshuifen(String shiyangshuifen) {
		this.shiyangshuifen = shiyangshuifen;
	}
	public String getKoh_rongyenongdu() {
		return koh_rongyenongdu;
	}
	public void setKoh_rongyenongdu(String koh_rongyenongdu) {
		this.koh_rongyenongdu = koh_rongyenongdu;
	}
	public String getDidingzhongdiandushu_1() {
		return didingzhongdiandushu_1;
	}
	public void setDidingzhongdiandushu_1(String didingzhongdiandushu_1) {
		this.didingzhongdiandushu_1 = didingzhongdiandushu_1;
	}
	public String getDidingzhongdiandushu_2() {
		return didingzhongdiandushu_2;
	}
	public void setDidingzhongdiandushu_2(String didingzhongdiandushu_2) {
		this.didingzhongdiandushu_2 = didingzhongdiandushu_2;
	}
	public String getDidingqishidushu_1() {
		return didingqishidushu_1;
	}
	public void setDidingqishidushu_1(String didingqishidushu_1) {
		this.didingqishidushu_1 = didingqishidushu_1;
	}
	public String getDidingqishidushu_2() {
		return didingqishidushu_2;
	}
	public void setDidingqishidushu_2(String didingqishidushu_2) {
		this.didingqishidushu_2 = didingqishidushu_2;
	}
	public String getKoh_rongyeyongliang_1() {
		return koh_rongyeyongliang_1;
	}
	public void setKoh_rongyeyongliang_1(String koh_rongyeyongliang_1) {
		this.koh_rongyeyongliang_1 = koh_rongyeyongliang_1;
	}
	public String getKoh_rongyeyongliang_2() {
		return koh_rongyeyongliang_2;
	}
	public void setKoh_rongyeyongliang_2(String koh_rongyeyongliang_2) {
		this.koh_rongyeyongliang_2 = koh_rongyeyongliang_2;
	}
	public String getKongbaishiyan_koh_yongliang() {
		return kongbaishiyan_koh_yongliang;
	}
	public void setKongbaishiyan_koh_yongliang(String kongbaishiyan_koh_yongliang) {
		this.kongbaishiyan_koh_yongliang = kongbaishiyan_koh_yongliang;
	}
	public String getZhifangsuanzhi_1() {
		return zhifangsuanzhi_1;
	}
	public void setZhifangsuanzhi_1(String zhifangsuanzhi_1) {
		this.zhifangsuanzhi_1 = zhifangsuanzhi_1;
	}
	public String getZhifangsuanzhi_2() {
		return zhifangsuanzhi_2;
	}
	public void setZhifangsuanzhi_2(String zhifangsuanzhi_2) {
		this.zhifangsuanzhi_2 = zhifangsuanzhi_2;
	}
	public String getPingjunzhi() {
		return pingjunzhi;
	}
	public void setPingjunzhi(String pingjunzhi) {
		this.pingjunzhi = pingjunzhi;
	}
//	public String getPingxingcha() {
//		return pingxingcha;
//	}
//	public void setPingxingcha(String pingxingcha) {
//		this.pingxingcha = pingxingcha;
//	}
//	public String getXiangduicha() {
//		return xiangduicha;
//	}
//	public void setXiangduicha(String xiangduicha) {
//		this.xiangduicha = xiangduicha;
//	}
	
	public String getBeizhu() {
		return beizhu;
	}
	public String getPingxingcha_xiangduicha() {
		return pingxingcha_xiangduicha;
	}
	public void setPingxingcha_xiangduicha(String pingxingcha_xiangduicha) {
		this.pingxingcha_xiangduicha = pingxingcha_xiangduicha;
	}
	public String getPingxingcha_xiangduicha_zhi() {
		return pingxingcha_xiangduicha_zhi;
	}
	public void setPingxingcha_xiangduicha_zhi(String pingxingcha_xiangduicha_zhi) {
		this.pingxingcha_xiangduicha_zhi = pingxingcha_xiangduicha_zhi;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	public String getJiance() {
		return jiance;
	}
	public void setJiance(String jiance) {
		this.jiance = jiance;
	}
	public String getJiaohe() {
		return jiaohe;
	}
	public void setJiaohe(String jiaohe) {
		this.jiaohe = jiaohe;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getSampleNum() {
		return sampleNum;
	}
	public void setSampleNum(String sampleNum) {
		this.sampleNum = sampleNum;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	@Override
	public String toString(){
		return JsonUtil.objectToJson(this);
	}
	

}
