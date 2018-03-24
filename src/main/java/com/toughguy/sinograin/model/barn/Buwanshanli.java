package com.toughguy.sinograin.model.barn;

import java.util.Date;
import com.toughguy.sinograin.model.AbstractModel;
import com.toughguy.sinograin.util.JsonUtil;
/*
 * 杂质，不完全测定记录
 * 
 */
public class Buwanshanli extends AbstractModel{

	private static final long serialVersionUID = 3083587919773638128L;
	
	private int smallSampleId;   			          				  //样品ID
	private String table_version;			      				  //表格版本号
	private Date riqi;          			       				  //日期
	private String shiwen;   				       				  //室温
	private String xiangduishidu;   		      			   	  //相对湿度
	private String didian;   				      				  //地点
	private String jiancefangfa;                   				  //检测方法
	private String yiqishebei_mingcheng_1;         				  //仪器设备名称1
	private String yiqishebei_mingcheng_2;        				  //仪器设备名称2
	private String yiqishebei_mingcheng_3;        				  //仪器设备名称3
	private String yiqishebei_bianhao_1;          				  //仪器设备编号1
	private String yiqishebei_bianhao_2;         				  //仪器设备编号2
	private String yiqishebei_bianhao_3;         				  //仪器设备编号3
	private String dayangzhiliang_1;              				  //大样质量m（g）1
	private String dayangzhiliang_2;              				  //大样质量m（g）2
	private String dayangzhiliang_jisuangongshi;  				  //大样质量m（g）算计公式
	private String dayangzazhizhiliang_1;         				  //大样杂质质量m（g）1
	private String dayangzazhizhiliang_2;          				  //大样杂质质量m（g）2
	private String dayangzazhizhiliang_jisuangongshi;			  //大样杂质质量m（g）算计公式
	private String dayangzazhihanliang_1;          				  //大样杂质含量M（%）1
	private String dayangzazhihanliang_2;                         //大样杂质含量M（%）2
	private String dayangzazhihanliang_jisuangongshi;			  //大样杂质含量M（%）算计公式
	private String dayangzazhihanliang_pingjunzhi; 				  //大样杂质含量平均值（%）
	private String dayangzazhihanliang_pingjunzhi_jisuangongshi;  //大样杂质含量平均值（%）计算公式
	private String xiaoyangzhiliang_1;            				  //小样质量m2（g）1
	private String xiaoyangzhiliang_2;     	       				  //小样质量m2（g）2
	private String xiaoyangzhiliang_jisuangongshi; 				  //小样质量m2（g）计算公式
	private String xiaoyangzazhizhiliang_1;       				  //小样杂质质量m3（g）1
	private String xiaoyangzazhizhiliang_2;        				  //小样杂质质量m3（g）2
	private String xiaoyangzazhizhiliang_jisuangongshi;			  //小样杂质质量m3（g）计算公式
	private String xiaoyangzazhihanliang_1;        				  //小样杂质含量N（%）1
	private String xiaoyangzazhihanliang_2;        				  //小样杂质含量N（%）2
	private String xiaoyangzazhihanliang_jisuangongshi;			  //小样杂质含量N（%）计算公式
	private String xiaoyangzazhihanliang_pingjunzhi;			  //小样杂质含量平均值（%）
	private String xiaoyangzazhihanliang_pingjunzhi_jisuangongshi;//小样杂质含量平均值（%）计算公式
	private String kuangwuzhizhiliang_1;           				  //矿物质质量m4（g）1
	private String kuangwuzhizhiliang_2;           				  //矿物质质量m4（g）2
	private String kuangwuzhizhiliang_jisuangongshi;			  //矿物质质量m4（g）计算公式
	private String kuangwuzhihanliang_1;          				  //矿物质含量A（%）1
	private String kuangwuzhihanliang_2;          				  //矿物质含量A（%）2
	private String kuangwuzhihanliang_jisuangongshi; 			  //矿物质含量A（%）计算公式
	private String kuangwuzhihanliang_pingjunzhi;  				  //矿物质含量平均值（%）
	private String kuangwuzhihanliang_pingjunzhi_jisuangongshi;   //矿物质含量平均值（%）计算公式
	private String zazhizongliang_1;              				  //杂质总量B（%）
	private String zazhizongliang_jisuangongshi;  				  //杂质总量B（%）计算公式
	private String buwanshanlizhiliang_1;          				  //不完善粒质量m5（g）1
	private String buwanshanlizhiliang_2;          				  //不完善粒质量m5（g）2
	private String buwanshanlizhiliang_jisuangongshi;			  //不完善粒质量m5（g）计算公式
	private String buwanshanlihanliang_1;          				  //不完善粒含量C（%）1
	private String buwanshanlihanliang_2;          				  //不完善粒含量C（%）2
	private String buwanshanlihanliang_jisuangongshi;			  //不完善粒质量m5（g）计算公式
	private String buwanshanlihanliang_pingjunzhi_1;              //不完善粒含量平均值（%）1
	private String buwanshanlihanliang_pingjunzhi_2;              //不完善粒含量平均值（%）2
	private String buwanshanlihanliang_pingjunzhi_jisuangongshi;  //不完善粒含量平均值（%）计算公式
	private String shengmeilizhiliang_1;                          //生霉粒质量m6（g）1
	private String shengmeilizhiliang_2;                          //生霉粒质量m6（g）2
	private String shengmeilizhiliang_jisuangongshi;              //生霉粒质量m6（g）计算公式
	private String shengmeilihanliang_1;                          //生霉粒含量D（%）1
	private String shengmeilihanliang_2;                          //生霉粒含量D（%）2
	private String shengmeilihanliang_jisuangongshi;              //生霉粒含量D（%）计算公式
	private String shengmeilihanliang_pingjunzhi;                 //生霉粒含量平均值（%）
	private String shengmeilihanliang_pingjunzhi_jisuangongshi;   //生霉粒含量平均值（%）计算公式
	private String beizhu;              	   					  //备注
	private String fenyangjiance;              					  //分样检测
	private String buwanshanli_zazhi_jiance;   					  //不完善粒、杂质检测
	private String jiaohe;             	   	   					  //校核
	
	

	public int getsmallSampleId() {
		return smallSampleId;
	}


	public void setsmallSampleId(int smallSampleId) {
		this.smallSampleId = smallSampleId;
	}


	public String getTable_version() {
		return table_version;
	}


	public void setTable_version(String table_version) {
		this.table_version = table_version;
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


	public String getDidian() {
		return didian;
	}


	public void setDidian(String didian) {
		this.didian = didian;
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


	public String getYiqishebei_mingcheng_3() {
		return yiqishebei_mingcheng_3;
	}


	public void setYiqishebei_mingcheng_3(String yiqishebei_mingcheng_3) {
		this.yiqishebei_mingcheng_3 = yiqishebei_mingcheng_3;
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


	public String getYiqishebei_bianhao_3() {
		return yiqishebei_bianhao_3;
	}


	public void setYiqishebei_bianhao_3(String yiqishebei_bianhao_3) {
		this.yiqishebei_bianhao_3 = yiqishebei_bianhao_3;
	}


	public String getDayangzhiliang_1() {
		return dayangzhiliang_1;
	}


	public void setDayangzhiliang_1(String dayangzhiliang_1) {
		this.dayangzhiliang_1 = dayangzhiliang_1;
	}


	public String getDayangzhiliang_2() {
		return dayangzhiliang_2;
	}


	public void setDayangzhiliang_2(String dayangzhiliang_2) {
		this.dayangzhiliang_2 = dayangzhiliang_2;
	}


	public String getDayangzhiliang_jisuangongshi() {
		return dayangzhiliang_jisuangongshi;
	}


	public void setDayangzhiliang_jisuangongshi(String dayangzhiliang_jisuangongshi) {
		this.dayangzhiliang_jisuangongshi = dayangzhiliang_jisuangongshi;
	}


	public String getDayangzazhizhiliang_1() {
		return dayangzazhizhiliang_1;
	}


	public void setDayangzazhizhiliang_1(String dayangzazhizhiliang_1) {
		this.dayangzazhizhiliang_1 = dayangzazhizhiliang_1;
	}


	public String getDayangzazhizhiliang_2() {
		return dayangzazhizhiliang_2;
	}


	public void setDayangzazhizhiliang_2(String dayangzazhizhiliang_2) {
		this.dayangzazhizhiliang_2 = dayangzazhizhiliang_2;
	}


	public String getDayangzazhizhiliang_jisuangongshi() {
		return dayangzazhizhiliang_jisuangongshi;
	}


	public void setDayangzazhizhiliang_jisuangongshi(String dayangzazhizhiliang_jisuangongshi) {
		this.dayangzazhizhiliang_jisuangongshi = dayangzazhizhiliang_jisuangongshi;
	}


	public String getDayangzazhihanliang_1() {
		return dayangzazhihanliang_1;
	}


	public void setDayangzazhihanliang_1(String dayangzazhihanliang_1) {
		this.dayangzazhihanliang_1 = dayangzazhihanliang_1;
	}


	public String getDayangzazhihanliang_2() {
		return dayangzazhihanliang_2;
	}


	public void setDayangzazhihanliang_2(String dayangzazhihanliang_2) {
		this.dayangzazhihanliang_2 = dayangzazhihanliang_2;
	}


	public String getDayangzazhihanliang_jisuangongshi() {
		return dayangzazhihanliang_jisuangongshi;
	}


	public void setDayangzazhihanliang_jisuangongshi(String dayangzazhihanliang_jisuangongshi) {
		this.dayangzazhihanliang_jisuangongshi = dayangzazhihanliang_jisuangongshi;
	}


	public String getDayangzazhihanliang_pingjunzhi() {
		return dayangzazhihanliang_pingjunzhi;
	}


	public void setDayangzazhihanliang_pingjunzhi(String dayangzazhihanliang_pingjunzhi) {
		this.dayangzazhihanliang_pingjunzhi = dayangzazhihanliang_pingjunzhi;
	}


	public String getDayangzazhihanliang_pingjunzhi_jisuangongshi() {
		return dayangzazhihanliang_pingjunzhi_jisuangongshi;
	}


	public void setDayangzazhihanliang_pingjunzhi_jisuangongshi(String dayangzazhihanliang_pingjunzhi_jisuangongshi) {
		this.dayangzazhihanliang_pingjunzhi_jisuangongshi = dayangzazhihanliang_pingjunzhi_jisuangongshi;
	}


	public String getXiaoyangzhiliang_1() {
		return xiaoyangzhiliang_1;
	}


	public void setXiaoyangzhiliang_1(String xiaoyangzhiliang_1) {
		this.xiaoyangzhiliang_1 = xiaoyangzhiliang_1;
	}


	public String getXiaoyangzhiliang_2() {
		return xiaoyangzhiliang_2;
	}


	public void setXiaoyangzhiliang_2(String xiaoyangzhiliang_2) {
		this.xiaoyangzhiliang_2 = xiaoyangzhiliang_2;
	}


	public String getXiaoyangzhiliang_jisuangongshi() {
		return xiaoyangzhiliang_jisuangongshi;
	}


	public void setXiaoyangzhiliang_jisuangongshi(String xiaoyangzhiliang_jisuangongshi) {
		this.xiaoyangzhiliang_jisuangongshi = xiaoyangzhiliang_jisuangongshi;
	}


	public String getXiaoyangzazhizhiliang_1() {
		return xiaoyangzazhizhiliang_1;
	}


	public void setXiaoyangzazhizhiliang_1(String xiaoyangzazhizhiliang_1) {
		this.xiaoyangzazhizhiliang_1 = xiaoyangzazhizhiliang_1;
	}


	public String getXiaoyangzazhizhiliang_2() {
		return xiaoyangzazhizhiliang_2;
	}


	public void setXiaoyangzazhizhiliang_2(String xiaoyangzazhizhiliang_2) {
		this.xiaoyangzazhizhiliang_2 = xiaoyangzazhizhiliang_2;
	}


	public String getXiaoyangzazhizhiliang_jisuangongshi() {
		return xiaoyangzazhizhiliang_jisuangongshi;
	}


	public void setXiaoyangzazhizhiliang_jisuangongshi(String xiaoyangzazhizhiliang_jisuangongshi) {
		this.xiaoyangzazhizhiliang_jisuangongshi = xiaoyangzazhizhiliang_jisuangongshi;
	}


	public String getXiaoyangzazhihanliang_1() {
		return xiaoyangzazhihanliang_1;
	}


	public void setXiaoyangzazhihanliang_1(String xiaoyangzazhihanliang_1) {
		this.xiaoyangzazhihanliang_1 = xiaoyangzazhihanliang_1;
	}


	public String getXiaoyangzazhihanliang_2() {
		return xiaoyangzazhihanliang_2;
	}


	public void setXiaoyangzazhihanliang_2(String xiaoyangzazhihanliang_2) {
		this.xiaoyangzazhihanliang_2 = xiaoyangzazhihanliang_2;
	}


	public String getXiaoyangzazhihanliang_jisuangongshi() {
		return xiaoyangzazhihanliang_jisuangongshi;
	}


	public void setXiaoyangzazhihanliang_jisuangongshi(String xiaoyangzazhihanliang_jisuangongshi) {
		this.xiaoyangzazhihanliang_jisuangongshi = xiaoyangzazhihanliang_jisuangongshi;
	}


	public String getXiaoyangzazhihanliang_pingjunzhi() {
		return xiaoyangzazhihanliang_pingjunzhi;
	}


	public void setXiaoyangzazhihanliang_pingjunzhi(String xiaoyangzazhihanliang_pingjunzhi) {
		this.xiaoyangzazhihanliang_pingjunzhi = xiaoyangzazhihanliang_pingjunzhi;
	}


	public String getXiaoyangzazhihanliang_pingjunzhi_jisuangongshi() {
		return xiaoyangzazhihanliang_pingjunzhi_jisuangongshi;
	}


	public void setXiaoyangzazhihanliang_pingjunzhi_jisuangongshi(String xiaoyangzazhihanliang_pingjunzhi_jisuangongshi) {
		this.xiaoyangzazhihanliang_pingjunzhi_jisuangongshi = xiaoyangzazhihanliang_pingjunzhi_jisuangongshi;
	}


	public String getKuangwuzhizhiliang_1() {
		return kuangwuzhizhiliang_1;
	}


	public void setKuangwuzhizhiliang_1(String kuangwuzhizhiliang_1) {
		this.kuangwuzhizhiliang_1 = kuangwuzhizhiliang_1;
	}


	public String getKuangwuzhizhiliang_2() {
		return kuangwuzhizhiliang_2;
	}


	public void setKuangwuzhizhiliang_2(String kuangwuzhizhiliang_2) {
		this.kuangwuzhizhiliang_2 = kuangwuzhizhiliang_2;
	}


	public String getKuangwuzhizhiliang_jisuangongshi() {
		return kuangwuzhizhiliang_jisuangongshi;
	}


	public void setKuangwuzhizhiliang_jisuangongshi(String kuangwuzhizhiliang_jisuangongshi) {
		this.kuangwuzhizhiliang_jisuangongshi = kuangwuzhizhiliang_jisuangongshi;
	}


	public String getKuangwuzhihanliang_1() {
		return kuangwuzhihanliang_1;
	}


	public void setKuangwuzhihanliang_1(String kuangwuzhihanliang_1) {
		this.kuangwuzhihanliang_1 = kuangwuzhihanliang_1;
	}


	public String getKuangwuzhihanliang_2() {
		return kuangwuzhihanliang_2;
	}


	public void setKuangwuzhihanliang_2(String kuangwuzhihanliang_2) {
		this.kuangwuzhihanliang_2 = kuangwuzhihanliang_2;
	}


	public String getKuangwuzhihanliang_jisuangongshi() {
		return kuangwuzhihanliang_jisuangongshi;
	}


	public void setKuangwuzhihanliang_jisuangongshi(String kuangwuzhihanliang_jisuangongshi) {
		this.kuangwuzhihanliang_jisuangongshi = kuangwuzhihanliang_jisuangongshi;
	}


	public String getKuangwuzhihanliang_pingjunzhi() {
		return kuangwuzhihanliang_pingjunzhi;
	}


	public void setKuangwuzhihanliang_pingjunzhi(String kuangwuzhihanliang_pingjunzhi) {
		this.kuangwuzhihanliang_pingjunzhi = kuangwuzhihanliang_pingjunzhi;
	}


	public String getKuangwuzhihanliang_pingjunzhi_jisuangongshi() {
		return kuangwuzhihanliang_pingjunzhi_jisuangongshi;
	}


	public void setKuangwuzhihanliang_pingjunzhi_jisuangongshi(String kuangwuzhihanliang_pingjunzhi_jisuangongshi) {
		this.kuangwuzhihanliang_pingjunzhi_jisuangongshi = kuangwuzhihanliang_pingjunzhi_jisuangongshi;
	}


	public String getZazhizongliang_1() {
		return zazhizongliang_1;
	}


	public void setZazhizongliang_1(String zazhizongliang_1) {
		this.zazhizongliang_1 = zazhizongliang_1;
	}


	public String getZazhizongliang_jisuangongshi() {
		return zazhizongliang_jisuangongshi;
	}


	public void setZazhizongliang_jisuangongshi(String zazhizongliang_jisuangongshi) {
		this.zazhizongliang_jisuangongshi = zazhizongliang_jisuangongshi;
	}


	public String getBuwanshanlizhiliang_1() {
		return buwanshanlizhiliang_1;
	}


	public void setBuwanshanlizhiliang_1(String buwanshanlizhiliang_1) {
		this.buwanshanlizhiliang_1 = buwanshanlizhiliang_1;
	}


	public String getBuwanshanlizhiliang_2() {
		return buwanshanlizhiliang_2;
	}


	public void setBuwanshanlizhiliang_2(String buwanshanlizhiliang_2) {
		this.buwanshanlizhiliang_2 = buwanshanlizhiliang_2;
	}


	public String getBuwanshanlizhiliang_jisuangongshi() {
		return buwanshanlizhiliang_jisuangongshi;
	}


	public void setBuwanshanlizhiliang_jisuangongshi(String buwanshanlizhiliang_jisuangongshi) {
		this.buwanshanlizhiliang_jisuangongshi = buwanshanlizhiliang_jisuangongshi;
	}


	public String getBuwanshanlihanliang_1() {
		return buwanshanlihanliang_1;
	}


	public void setBuwanshanlihanliang_1(String buwanshanlihanliang_1) {
		this.buwanshanlihanliang_1 = buwanshanlihanliang_1;
	}


	public String getBuwanshanlihanliang_2() {
		return buwanshanlihanliang_2;
	}


	public void setBuwanshanlihanliang_2(String buwanshanlihanliang_2) {
		this.buwanshanlihanliang_2 = buwanshanlihanliang_2;
	}


	public String getBuwanshanlihanliang_jisuangongshi() {
		return buwanshanlihanliang_jisuangongshi;
	}


	public void setBuwanshanlihanliang_jisuangongshi(String buwanshanlihanliang_jisuangongshi) {
		this.buwanshanlihanliang_jisuangongshi = buwanshanlihanliang_jisuangongshi;
	}


	public String getBuwanshanlihanliang_pingjunzhi_1() {
		return buwanshanlihanliang_pingjunzhi_1;
	}


	public void setBuwanshanlihanliang_pingjunzhi_1(String buwanshanlihanliang_pingjunzhi_1) {
		this.buwanshanlihanliang_pingjunzhi_1 = buwanshanlihanliang_pingjunzhi_1;
	}


	public String getBuwanshanlihanliang_pingjunzhi_2() {
		return buwanshanlihanliang_pingjunzhi_2;
	}


	public void setBuwanshanlihanliang_pingjunzhi_2(String buwanshanlihanliang_pingjunzhi_2) {
		this.buwanshanlihanliang_pingjunzhi_2 = buwanshanlihanliang_pingjunzhi_2;
	}


	public String getBuwanshanlihanliang_pingjunzhi_jisuangongshi() {
		return buwanshanlihanliang_pingjunzhi_jisuangongshi;
	}


	public void setBuwanshanlihanliang_pingjunzhi_jisuangongshi(String buwanshanlihanliang_pingjunzhi_jisuangongshi) {
		this.buwanshanlihanliang_pingjunzhi_jisuangongshi = buwanshanlihanliang_pingjunzhi_jisuangongshi;
	}


	public String getShengmeilizhiliang_1() {
		return shengmeilizhiliang_1;
	}


	public void setShengmeilizhiliang_1(String shengmeilizhiliang_1) {
		this.shengmeilizhiliang_1 = shengmeilizhiliang_1;
	}


	public String getShengmeilizhiliang_2() {
		return shengmeilizhiliang_2;
	}


	public void setShengmeilizhiliang_2(String shengmeilizhiliang_2) {
		this.shengmeilizhiliang_2 = shengmeilizhiliang_2;
	}


	public String getShengmeilizhiliang_jisuangongshi() {
		return shengmeilizhiliang_jisuangongshi;
	}


	public void setShengmeilizhiliang_jisuangongshi(String shengmeilizhiliang_jisuangongshi) {
		this.shengmeilizhiliang_jisuangongshi = shengmeilizhiliang_jisuangongshi;
	}


	public String getShengmeilihanliang_1() {
		return shengmeilihanliang_1;
	}


	public void setShengmeilihanliang_1(String shengmeilihanliang_1) {
		this.shengmeilihanliang_1 = shengmeilihanliang_1;
	}


	public String getShengmeilihanliang_2() {
		return shengmeilihanliang_2;
	}


	public void setShengmeilihanliang_2(String shengmeilihanliang_2) {
		this.shengmeilihanliang_2 = shengmeilihanliang_2;
	}


	public String getShengmeilihanliang_jisuangongshi() {
		return shengmeilihanliang_jisuangongshi;
	}


	public void setShengmeilihanliang_jisuangongshi(String shengmeilihanliang_jisuangongshi) {
		this.shengmeilihanliang_jisuangongshi = shengmeilihanliang_jisuangongshi;
	}


	public String getShengmeilihanliang_pingjunzhi() {
		return shengmeilihanliang_pingjunzhi;
	}


	public void setShengmeilihanliang_pingjunzhi(String shengmeilihanliang_pingjunzhi) {
		this.shengmeilihanliang_pingjunzhi = shengmeilihanliang_pingjunzhi;
	}


	public String getShengmeilihanliang_pingjunzhi_jisuangongshi() {
		return shengmeilihanliang_pingjunzhi_jisuangongshi;
	}


	public void setShengmeilihanliang_pingjunzhi_jisuangongshi(String shengmeilihanliang_pingjunzhi_jisuangongshi) {
		this.shengmeilihanliang_pingjunzhi_jisuangongshi = shengmeilihanliang_pingjunzhi_jisuangongshi;
	}


	public String getBeizhu() {
		return beizhu;
	}


	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}


	public String getFenyangjiance() {
		return fenyangjiance;
	}


	public void setFenyangjiance(String fenyangjiance) {
		this.fenyangjiance = fenyangjiance;
	}


	public String getBuwanshanli_zazhi_jiance() {
		return buwanshanli_zazhi_jiance;
	}


	public void setBuwanshanli_zazhi_jiance(String buwanshanli_zazhi_jiance) {
		this.buwanshanli_zazhi_jiance = buwanshanli_zazhi_jiance;
	}


	public String getJiaohe() {
		return jiaohe;
	}


	public void setJiaohe(String jiaohe) {
		this.jiaohe = jiaohe;
	}

	public Date getRiqi() {
		return riqi;
	}


	public void setRiqi(Date riqi) {
		this.riqi = riqi;
	}




	@Override
	public String toString(){
		return JsonUtil.objectToJson(this);
	}
	
}
