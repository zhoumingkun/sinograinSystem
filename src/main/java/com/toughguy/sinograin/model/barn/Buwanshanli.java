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
	
	private int smallSampleId;   			          				  //小样ID
	private String b_table_version;			      				  //表格版本号
	private Date b_riqi;          			       				  //日期
	private String b_shiwen;   				       				  //室温
	private String b_xiangduishidu;   		      			   	  //相对湿度
	private String b_jiancefangfa;                   				  //检测方法
	private String b_yiqishebei_mingcheng_1;         				  //仪器设备名称1
	private String b_yiqishebei_mingcheng_2;        				  //仪器设备名称2
	private String b_yiqishebei_mingcheng_3;        				  //仪器设备名称3
	private String b_yiqishebei_bianhao_1;          				  //仪器设备编号1
	private String b_yiqishebei_bianhao_2;         				  //仪器设备编号2
	private String b_yiqishebei_bianhao_3;         				  //仪器设备编号3
	private String dayangzhiliang_1;              				  //大样质量m（g）1
	private String dayangzhiliang_2;              				  //大样质量m（g）2
	private String dayangzazhizhiliang_1;         				  //大样杂质质量m（g）1
	private String dayangzazhizhiliang_2;          				  //大样杂质质量m（g）2
	private String dayangzazhihanliang_1;          				  //大样杂质含量M（%）1
	private String dayangzazhihanliang_2;                         //大样杂质含量M（%）2
	private String dayangzazhihanliang_pingjunzhi; 				  //大样杂质含量平均值（%）
	private String xiaoyangzhiliang_1;            				  //小样质量m2（g）1
	private String xiaoyangzhiliang_2;     	       				  //小样质量m2（g）2
	private String xiaoyangzazhizhiliang_1;       				  //小样杂质质量m3（g）1
	private String xiaoyangzazhizhiliang_2;        				  //小样杂质质量m3（g）2
	private String xiaoyangzazhihanliang_1;        				  //小样杂质含量N（%）1
	private String xiaoyangzazhihanliang_2;        				  //小样杂质含量N（%）2
	private String xiaoyangzazhihanliang_pingjunzhi;			  //小样杂质含量平均值（%）
	private String kuangwuzhizhiliang_1;           				  //矿物质质量m4（g）1
	private String kuangwuzhizhiliang_2;           				  //矿物质质量m4（g）2
	private String kuangwuzhihanliang_1;          				  //矿物质含量A（%）1
	private String kuangwuzhihanliang_2;          				  //矿物质含量A（%）2
	private String kuangwuzhihanliang_pingjunzhi;  				  //矿物质含量平均值（%）
	private String zazhizongliang_1;              				  //杂质总量B（%）
	private String buwanshanlizhiliang_1;          				  //不完善粒质量m5（g）1
	private String buwanshanlizhiliang_2;          				  //不完善粒质量m5（g）2
	private String buwanshanlihanliang_1;          				  //不完善粒含量C（%）1
	private String buwanshanlihanliang_2;          				  //不完善粒含量C（%）2
	private String buwanshanlihanliang_pingjunzhi_1;              //不完善粒含量平均值（%）1
	private String buwanshanlihanliang_pingjunzhi_2;              //不完善粒含量平均值（%）2
	private String shengmeilizhiliang_1;                          //生霉粒质量m6（g）1
	private String shengmeilizhiliang_2;                          //生霉粒质量m6（g）2
	private String shengmeilihanliang_1;                          //生霉粒含量D（%）1
	private String shengmeilihanliang_2;                          //生霉粒含量D（%）2
	private String shengmeilihanliang_pingjunzhi;                 //生霉粒含量平均值（%）
	private String beizhu;              	   					  //备注
	private String fenyangjiance;              					  //分样检测
	private String buwanshanli_zazhi_jiance;   					  //不完善粒、杂质检测
	private String jiaohe;             	   	   					  //校核
	
	



	public int getSmallSampleId() {
		return smallSampleId;
	}


	public void setSmallSampleId(int smallSampleId) {
		this.smallSampleId = smallSampleId;
	}


	public String getB_table_version() {
		return b_table_version;
	}


	public void setB_table_version(String b_table_version) {
		this.b_table_version = b_table_version;
	}


	public Date getB_riqi() {
		return b_riqi;
	}


	public void setB_riqi(Date b_riqi) {
		this.b_riqi = b_riqi;
	}


	public String getB_shiwen() {
		return b_shiwen;
	}


	public void setB_shiwen(String b_shiwen) {
		this.b_shiwen = b_shiwen;
	}


	public String getB_xiangduishidu() {
		return b_xiangduishidu;
	}


	public void setB_xiangduishidu(String b_xiangduishidu) {
		this.b_xiangduishidu = b_xiangduishidu;
	}


	public String getB_jiancefangfa() {
		return b_jiancefangfa;
	}


	public void setB_jiancefangfa(String b_jiancefangfa) {
		this.b_jiancefangfa = b_jiancefangfa;
	}


	public String getB_yiqishebei_mingcheng_1() {
		return b_yiqishebei_mingcheng_1;
	}


	public void setB_yiqishebei_mingcheng_1(String b_yiqishebei_mingcheng_1) {
		this.b_yiqishebei_mingcheng_1 = b_yiqishebei_mingcheng_1;
	}


	public String getB_yiqishebei_mingcheng_2() {
		return b_yiqishebei_mingcheng_2;
	}


	public void setB_yiqishebei_mingcheng_2(String b_yiqishebei_mingcheng_2) {
		this.b_yiqishebei_mingcheng_2 = b_yiqishebei_mingcheng_2;
	}


	public String getB_yiqishebei_mingcheng_3() {
		return b_yiqishebei_mingcheng_3;
	}


	public void setB_yiqishebei_mingcheng_3(String b_yiqishebei_mingcheng_3) {
		this.b_yiqishebei_mingcheng_3 = b_yiqishebei_mingcheng_3;
	}


	public String getB_yiqishebei_bianhao_1() {
		return b_yiqishebei_bianhao_1;
	}


	public void setB_yiqishebei_bianhao_1(String b_yiqishebei_bianhao_1) {
		this.b_yiqishebei_bianhao_1 = b_yiqishebei_bianhao_1;
	}


	public String getB_yiqishebei_bianhao_2() {
		return b_yiqishebei_bianhao_2;
	}


	public void setB_yiqishebei_bianhao_2(String b_yiqishebei_bianhao_2) {
		this.b_yiqishebei_bianhao_2 = b_yiqishebei_bianhao_2;
	}


	public String getB_yiqishebei_bianhao_3() {
		return b_yiqishebei_bianhao_3;
	}


	public void setB_yiqishebei_bianhao_3(String b_yiqishebei_bianhao_3) {
		this.b_yiqishebei_bianhao_3 = b_yiqishebei_bianhao_3;
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

	public String getDayangzazhihanliang_pingjunzhi() {
		return dayangzazhihanliang_pingjunzhi;
	}


	public void setDayangzazhihanliang_pingjunzhi(String dayangzazhihanliang_pingjunzhi) {
		this.dayangzazhihanliang_pingjunzhi = dayangzazhihanliang_pingjunzhi;
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

	public String getXiaoyangzazhihanliang_pingjunzhi() {
		return xiaoyangzazhihanliang_pingjunzhi;
	}


	public void setXiaoyangzazhihanliang_pingjunzhi(String xiaoyangzazhihanliang_pingjunzhi) {
		this.xiaoyangzazhihanliang_pingjunzhi = xiaoyangzazhihanliang_pingjunzhi;
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

	public String getKuangwuzhihanliang_pingjunzhi() {
		return kuangwuzhihanliang_pingjunzhi;
	}


	public void setKuangwuzhihanliang_pingjunzhi(String kuangwuzhihanliang_pingjunzhi) {
		this.kuangwuzhihanliang_pingjunzhi = kuangwuzhihanliang_pingjunzhi;
	}

	public String getZazhizongliang_1() {
		return zazhizongliang_1;
	}


	public void setZazhizongliang_1(String zazhizongliang_1) {
		this.zazhizongliang_1 = zazhizongliang_1;
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

	public String getShengmeilihanliang_pingjunzhi() {
		return shengmeilihanliang_pingjunzhi;
	}


	public void setShengmeilihanliang_pingjunzhi(String shengmeilihanliang_pingjunzhi) {
		this.shengmeilihanliang_pingjunzhi = shengmeilihanliang_pingjunzhi;
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





	@Override
	public String toString(){
		return JsonUtil.objectToJson(this);
	}
	
}
