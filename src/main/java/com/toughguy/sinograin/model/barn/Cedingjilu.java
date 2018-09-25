package com.toughguy.sinograin.model.barn;

import java.util.Date;


import com.toughguy.sinograin.model.AbstractModel;
import com.toughguy.sinograin.util.JsonUtil;
/*
 * 测定记录
 * 
 */
public class Cedingjilu extends AbstractModel{

	private static final long serialVersionUID = 1081272876075110807L;
	
	private int smallSampleId;   			      //样品ID
//	private String table_version;			  //表格版本号
	private Date riqi;          			  //日期
	private String shiwen;   				  //室温
	private String xiangduishidu;   		  //相对湿度
	private String didian;   				  //地点
	private String sampleNum;   			  //检测编号
	private String sort;   				      //样品名称
	private String jiancefangfa;              //检测方法
	private String yiqishebei_mingcheng_1;    //仪器设备名称1
	private String yiqishebei_mingcheng_2;    //仪器设备名称2
	private String yiqishebei_mingcheng_3;    //仪器设备名称3
	private String yiqishebei_bianhao_1;      //仪器设备编号1
	private String yiqishebei_bianhao_2;      //仪器设备编号2
	private String yiqishebei_bianhao_3;      //仪器设备编号3
	private String rongzhong_1;               //容重1
	private String rongzhong_2;               //容重2
	private String yingduzhishu_1;            //硬度指数1
	private String yingduzhishu_2;            //硬度指数2
	private String sezeqiwei_1;               //色泽气味1
	private String sezeqiwei_2;               //色泽气味2
	private String jiareshiyan_1;             //加热实验1
	private String jiareshiyan_2;             //加热实验2
	private String jiagongjingdu_1;           //加工精度1
	private String jiagongjingdu_2;           //加工精度2
	private String pise_1;					  //皮色1
	private String pise_2;                    //皮色2
	private String pingjunzhi;                //平均值
//	private String shuifen_1;                 //水分1
//	private String shuifen_2;                 //水分2
//	private String shuifen_pingjunzhi;        //水分平均值
//	private String dainfen_1;                 //淀粉1
//	private String dainfen_2;                 //淀粉2
//	private String dainfen_pingjunzhi;        //淀粉平均值
//	private String zhifang_1;                 //脂肪1
//	private String zhifang_2;                 //脂肪2
//	private String zhifang_pingjunzhi;        //脂肪平均值
//	private String danbai_1;                  //蛋白1
//	private String danbai_2;                  //蛋白2
//	private String danbai_pingjunzhi;         //蛋白平均值
//	private String shimianjin_1;              //湿面筋1
//	private String shimianjin_2;              //湿面筋2
//	private String shimianjin_pingjunzhi;     //湿面筋平均值
//	private String chenjiangzhi_1;            //沉降值1
//	private String chenjiangzhi_2;            //沉降值2
//	private String chenjiangzhi_pingjunzhi;   //沉降值平均值
//	private String lashenchangdu_1;           //拉伸长度1
//	private String lashenchangdu_2;           //拉伸长度2
//	private String lashenchangdu_pingjunzhi;  //拉伸长度平均值
//	private String wendingshijian_1;          //稳定时间1
//	private String wendingshijian_2;          //稳定时间2
//	private String wendingshijian_pingjunzhi; //稳定时间平均值
//	private String xishuilv_1;                 //吸水率1
//	private String xishuilv_2;                 //吸水率2
//	private String xishuilv_pingjunzhi;        //吸水率平均值
//	private String xingchengshijian_1;         //形成时间1
//	private String xingchengshijian_2;         //形成时间2
//	private String xingchengshijian_pingjunzhi;//形成时间平均值
	private String beizhu;              	   //备注
	private String jiance;             		   //检测
	private String jiaohe;             	   	   //校核
	
	
	public int getsmallSampleId() {
		return smallSampleId;
	}
	public void setsmallSampleId(int smallSampleId) {
		this.smallSampleId = smallSampleId;
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
	public String getRongzhong_1() {
		return rongzhong_1;
	}
	public void setRongzhong_1(String rongzhong_1) {
		this.rongzhong_1 = rongzhong_1;
	}
	public String getRongzhong_2() {
		return rongzhong_2;
	}
	public void setRongzhong_2(String rongzhong_2) {
		this.rongzhong_2 = rongzhong_2;
	}
	public String getSezeqiwei_1() {
		return sezeqiwei_1;
	}
	public void setSezeqiwei_1(String sezeqiwei_1) {
		this.sezeqiwei_1 = sezeqiwei_1;
	}
	public String getSezeqiwei_2() {
		return sezeqiwei_2;
	}
	public void setSezeqiwei_2(String sezeqiwei_2) {
		this.sezeqiwei_2 = sezeqiwei_2;
	}
	public String getYingduzhishu_1() {
		return yingduzhishu_1;
	}
	public void setYingduzhishu_1(String yingduzhishu_1) {
		this.yingduzhishu_1 = yingduzhishu_1;
	}
	public String getYingduzhishu_2() {
		return yingduzhishu_2;
	}
	public void setYingduzhishu_2(String yingduzhishu_2) {
		this.yingduzhishu_2 = yingduzhishu_2;
	}
	public String getPise_1() {
		return pise_1;
	}
	public void setPise_1(String pise_1) {
		this.pise_1 = pise_1;
	}
	public String getPise_2() {
		return pise_2;
	}
	public void setPise_2(String pise_2) {
		this.pise_2 = pise_2;
	}
	public String getBeizhu() {
		return beizhu;
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
	
	public int getSmallSampleId() {
		return smallSampleId;
	}
	public void setSmallSampleId(int smallSampleId) {
		this.smallSampleId = smallSampleId;
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
	public String getJiareshiyan_1() {
		return jiareshiyan_1;
	}
	public void setJiareshiyan_1(String jiareshiyan_1) {
		this.jiareshiyan_1 = jiareshiyan_1;
	}
	public String getJiareshiyan_2() {
		return jiareshiyan_2;
	}
	public void setJiareshiyan_2(String jiareshiyan_2) {
		this.jiareshiyan_2 = jiareshiyan_2;
	}
	public String getJiagongjingdu_1() {
		return jiagongjingdu_1;
	}
	public void setJiagongjingdu_1(String jiagongjingdu_1) {
		this.jiagongjingdu_1 = jiagongjingdu_1;
	}
	public String getJiagongjingdu_2() {
		return jiagongjingdu_2;
	}
	public void setJiagongjingdu_2(String jiagongjingdu_2) {
		this.jiagongjingdu_2 = jiagongjingdu_2;
	}
	public String getPingjunzhi() {
		return pingjunzhi;
	}
	public void setPingjunzhi(String pingjunzhi) {
		this.pingjunzhi = pingjunzhi;
	}
	@Override
	public String toString(){
		return JsonUtil.objectToJson(this);
	}
}
