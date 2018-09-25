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
	private String c_table_version;			  //表格版本号
	private Date c_riqi;          			  //日期
	private String c_shiwen;   				  //室温
	private String c_xiangduishidu;   		  //相对湿度
	private String c_jiancefangfa;              //检测方法
	private String c_yiqishebei_mingcheng_1;    //仪器设备名称1
	private String c_yiqishebei_mingcheng_2;    //仪器设备名称2
	private String c_yiqishebei_mingcheng_3;    //仪器设备名称3
	private String c_yiqishebei_mingcheng_4;    //仪器设备名称4
	private String c_yiqishebei_bianhao_1;      //仪器设备编号1
	private String c_yiqishebei_bianhao_2;      //仪器设备编号2
	private String c_yiqishebei_bianhao_3;      //仪器设备编号3
	private String c_yiqishebei_bianhao_4;      //仪器设备编号4
	private String rongzhong_1;               //容重1
	private String rongzhong_2;               //容重2
	private String rongzhong_pingjunzhi;      //容重平均值
	private String sezeqiwei_1;               //色泽气味1
	private String sezeqiwei_2;               //色泽气味1
	private String sezeqiwei_pingjunzhi;      //色泽气味平均值
	private String yingduzhishu_1;            //硬度指数1
	private String yingduzhishu_2;            //硬度指数1
	private String yingduzhishu_pingjunzhi;   //硬度指数平均值
	private String pise_1;					  //皮色2
	private String pise_2;                    //皮色2
	private String pise_pingjunzhi;           //皮色平均值
	private String shuifen_1;                 //水分1
	private String shuifen_2;                 //水分2
	private String shuifen_pingjunzhi;        //水分平均值
	private String dainfen_1;                 //淀粉1
	private String dainfen_2;                 //淀粉2
	private String dainfen_pingjunzhi;        //淀粉平均值
	private String zhifang_1;                 //脂肪1
	private String zhifang_2;                 //脂肪2
	private String zhifang_pingjunzhi;        //脂肪平均值
	private String danbai_1;                  //蛋白1
	private String danbai_2;                  //蛋白2
	private String danbai_pingjunzhi;         //蛋白平均值
	private String shimianjin_1;              //湿面筋1
	private String shimianjin_2;              //湿面筋2
	private String shimianjin_pingjunzhi;     //湿面筋平均值
	private String chenjiangzhi_1;            //沉降值1
	private String chenjiangzhi_2;            //沉降值2
	private String chenjiangzhi_pingjunzhi;   //沉降值平均值
	private String lashenchangdu_1;           //拉伸长度1
	private String lashenchangdu_2;           //拉伸长度2
	private String lashenchangdu_pingjunzhi;  //拉伸长度平均值
	private String wendingshijian_1;          //稳定时间1
	private String wendingshijian_2;          //稳定时间2
	private String wendingshijian_pingjunzhi; //稳定时间平均值
	private String xishuilv_1;                 //吸水率1
	private String xishuilv_2;                 //吸水率2
	private String xishuilv_pingjunzhi;        //吸水率平均值
	private String xingchengshijian_1;         //形成时间1
	private String xingchengshijian_2;         //形成时间2
	private String xingchengshijian_pingjunzhi;//形成时间平均值
	private String beizhu;              	   //备注
	private String jiance;             		   //检测
	private String jiaohe;             	   	   //校核
	
	
	public int getSmallSampleId() {
		return smallSampleId;
	}
	public void setSmallSampleId(int smallSampleId) {
		this.smallSampleId = smallSampleId;
	}
	public String getC_table_version() {
		return c_table_version;
	}
	public void setC_table_version(String c_table_version) {
		this.c_table_version = c_table_version;
	}
	public Date getC_riqi() {
		return c_riqi;
	}
	public void setC_riqi(Date c_riqi) {
		this.c_riqi = c_riqi;
	}
	public String getC_shiwen() {
		return c_shiwen;
	}
	public void setC_shiwen(String c_shiwen) {
		this.c_shiwen = c_shiwen;
	}
	public String getC_xiangduishidu() {
		return c_xiangduishidu;
	}
	public void setC_xiangduishidu(String c_xiangduishidu) {
		this.c_xiangduishidu = c_xiangduishidu;
	}
	public String getC_jiancefangfa() {
		return c_jiancefangfa;
	}
	public void setC_jiancefangfa(String c_jiancefangfa) {
		this.c_jiancefangfa = c_jiancefangfa;
	}
	public String getC_yiqishebei_mingcheng_1() {
		return c_yiqishebei_mingcheng_1;
	}
	public void setC_yiqishebei_mingcheng_1(String c_yiqishebei_mingcheng_1) {
		this.c_yiqishebei_mingcheng_1 = c_yiqishebei_mingcheng_1;
	}
	public String getC_yiqishebei_mingcheng_2() {
		return c_yiqishebei_mingcheng_2;
	}
	public void setC_yiqishebei_mingcheng_2(String c_yiqishebei_mingcheng_2) {
		this.c_yiqishebei_mingcheng_2 = c_yiqishebei_mingcheng_2;
	}
	public String getC_yiqishebei_mingcheng_3() {
		return c_yiqishebei_mingcheng_3;
	}
	public void setC_yiqishebei_mingcheng_3(String c_yiqishebei_mingcheng_3) {
		this.c_yiqishebei_mingcheng_3 = c_yiqishebei_mingcheng_3;
	}
	public String getC_yiqishebei_mingcheng_4() {
		return c_yiqishebei_mingcheng_4;
	}
	public void setC_yiqishebei_mingcheng_4(String c_yiqishebei_mingcheng_4) {
		this.c_yiqishebei_mingcheng_4 = c_yiqishebei_mingcheng_4;
	}
	public String getC_yiqishebei_bianhao_1() {
		return c_yiqishebei_bianhao_1;
	}
	public void setC_yiqishebei_bianhao_1(String c_yiqishebei_bianhao_1) {
		this.c_yiqishebei_bianhao_1 = c_yiqishebei_bianhao_1;
	}
	public String getC_yiqishebei_bianhao_2() {
		return c_yiqishebei_bianhao_2;
	}
	public void setC_yiqishebei_bianhao_2(String c_yiqishebei_bianhao_2) {
		this.c_yiqishebei_bianhao_2 = c_yiqishebei_bianhao_2;
	}
	public String getC_yiqishebei_bianhao_3() {
		return c_yiqishebei_bianhao_3;
	}
	public void setC_yiqishebei_bianhao_3(String c_yiqishebei_bianhao_3) {
		this.c_yiqishebei_bianhao_3 = c_yiqishebei_bianhao_3;
	}
	public String getC_yiqishebei_bianhao_4() {
		return c_yiqishebei_bianhao_4;
	}
	public void setC_yiqishebei_bianhao_4(String c_yiqishebei_bianhao_4) {
		this.c_yiqishebei_bianhao_4 = c_yiqishebei_bianhao_4;
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
	public String getRongzhong_pingjunzhi() {
		return rongzhong_pingjunzhi;
	}
	public void setRongzhong_pingjunzhi(String rongzhong_pingjunzhi) {
		this.rongzhong_pingjunzhi = rongzhong_pingjunzhi;
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
	public String getSezeqiwei_pingjunzhi() {
		return sezeqiwei_pingjunzhi;
	}
	public void setSezeqiwei_pingjunzhi(String sezeqiwei_pingjunzhi) {
		this.sezeqiwei_pingjunzhi = sezeqiwei_pingjunzhi;
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
	public String getYingduzhishu_pingjunzhi() {
		return yingduzhishu_pingjunzhi;
	}
	public void setYingduzhishu_pingjunzhi(String yingduzhishu_pingjunzhi) {
		this.yingduzhishu_pingjunzhi = yingduzhishu_pingjunzhi;
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
	public String getPise_pingjunzhi() {
		return pise_pingjunzhi;
	}
	public void setPise_pingjunzhi(String pise_pingjunzhi) {
		this.pise_pingjunzhi = pise_pingjunzhi;
	}
	public String getShuifen_1() {
		return shuifen_1;
	}
	public void setShuifen_1(String shuifen_1) {
		this.shuifen_1 = shuifen_1;
	}
	public String getShuifen_2() {
		return shuifen_2;
	}
	public void setShuifen_2(String shuifen_2) {
		this.shuifen_2 = shuifen_2;
	}
	public String getShuifen_pingjunzhi() {
		return shuifen_pingjunzhi;
	}
	public void setShuifen_pingjunzhi(String shuifen_pingjunzhi) {
		this.shuifen_pingjunzhi = shuifen_pingjunzhi;
	}
	public String getDainfen_1() {
		return dainfen_1;
	}
	public void setDainfen_1(String dainfen_1) {
		this.dainfen_1 = dainfen_1;
	}
	public String getDainfen_2() {
		return dainfen_2;
	}
	public void setDainfen_2(String dainfen_2) {
		this.dainfen_2 = dainfen_2;
	}
	public String getDainfen_pingjunzhi() {
		return dainfen_pingjunzhi;
	}
	public void setDainfen_pingjunzhi(String dainfen_pingjunzhi) {
		this.dainfen_pingjunzhi = dainfen_pingjunzhi;
	}
	public String getZhifang_1() {
		return zhifang_1;
	}
	public void setZhifang_1(String zhifang_1) {
		this.zhifang_1 = zhifang_1;
	}
	public String getZhifang_2() {
		return zhifang_2;
	}
	public void setZhifang_2(String zhifang_2) {
		this.zhifang_2 = zhifang_2;
	}
	public String getZhifang_pingjunzhi() {
		return zhifang_pingjunzhi;
	}
	public void setZhifang_pingjunzhi(String zhifang_pingjunzhi) {
		this.zhifang_pingjunzhi = zhifang_pingjunzhi;
	}
	public String getDanbai_1() {
		return danbai_1;
	}
	public void setDanbai_1(String danbai_1) {
		this.danbai_1 = danbai_1;
	}
	public String getDanbai_2() {
		return danbai_2;
	}
	public void setDanbai_2(String danbai_2) {
		this.danbai_2 = danbai_2;
	}
	public String getDanbai_pingjunzhi() {
		return danbai_pingjunzhi;
	}
	public void setDanbai_pingjunzhi(String danbai_pingjunzhi) {
		this.danbai_pingjunzhi = danbai_pingjunzhi;
	}
	public String getShimianjin_1() {
		return shimianjin_1;
	}
	public void setShimianjin_1(String shimianjin_1) {
		this.shimianjin_1 = shimianjin_1;
	}
	public String getShimianjin_2() {
		return shimianjin_2;
	}
	public void setShimianjin_2(String shimianjin_2) {
		this.shimianjin_2 = shimianjin_2;
	}
	public String getShimianjin_pingjunzhi() {
		return shimianjin_pingjunzhi;
	}
	public void setShimianjin_pingjunzhi(String shimianjin_pingjunzhi) {
		this.shimianjin_pingjunzhi = shimianjin_pingjunzhi;
	}
	public String getChenjiangzhi_1() {
		return chenjiangzhi_1;
	}
	public void setChenjiangzhi_1(String chenjiangzhi_1) {
		this.chenjiangzhi_1 = chenjiangzhi_1;
	}
	public String getChenjiangzhi_2() {
		return chenjiangzhi_2;
	}
	public void setChenjiangzhi_2(String chenjiangzhi_2) {
		this.chenjiangzhi_2 = chenjiangzhi_2;
	}
	public String getChenjiangzhi_pingjunzhi() {
		return chenjiangzhi_pingjunzhi;
	}
	public void setChenjiangzhi_pingjunzhi(String chenjiangzhi_pingjunzhi) {
		this.chenjiangzhi_pingjunzhi = chenjiangzhi_pingjunzhi;
	}
	public String getLashenchangdu_1() {
		return lashenchangdu_1;
	}
	public void setLashenchangdu_1(String lashenchangdu_1) {
		this.lashenchangdu_1 = lashenchangdu_1;
	}
	public String getLashenchangdu_2() {
		return lashenchangdu_2;
	}
	public void setLashenchangdu_2(String lashenchangdu_2) {
		this.lashenchangdu_2 = lashenchangdu_2;
	}
	public String getLashenchangdu_pingjunzhi() {
		return lashenchangdu_pingjunzhi;
	}
	public void setLashenchangdu_pingjunzhi(String lashenchangdu_pingjunzhi) {
		this.lashenchangdu_pingjunzhi = lashenchangdu_pingjunzhi;
	}
	public String getWendingshijian_1() {
		return wendingshijian_1;
	}
	public void setWendingshijian_1(String wendingshijian_1) {
		this.wendingshijian_1 = wendingshijian_1;
	}
	public String getWendingshijian_2() {
		return wendingshijian_2;
	}
	public void setWendingshijian_2(String wendingshijian_2) {
		this.wendingshijian_2 = wendingshijian_2;
	}
	public String getWendingshijian_pingjunzhi() {
		return wendingshijian_pingjunzhi;
	}
	public void setWendingshijian_pingjunzhi(String wendingshijian_pingjunzhi) {
		this.wendingshijian_pingjunzhi = wendingshijian_pingjunzhi;
	}
	public String getXishuilv_1() {
		return xishuilv_1;
	}
	public void setXishuilv_1(String xishuilv_1) {
		this.xishuilv_1 = xishuilv_1;
	}
	public String getXishuilv_2() {
		return xishuilv_2;
	}
	public void setXishuilv_2(String xishuilv_2) {
		this.xishuilv_2 = xishuilv_2;
	}
	public String getXishuilv_pingjunzhi() {
		return xishuilv_pingjunzhi;
	}
	public void setXishuilv_pingjunzhi(String xishuilv_pingjunzhi) {
		this.xishuilv_pingjunzhi = xishuilv_pingjunzhi;
	}
	public String getXingchengshijian_1() {
		return xingchengshijian_1;
	}
	public void setXingchengshijian_1(String xingchengshijian_1) {
		this.xingchengshijian_1 = xingchengshijian_1;
	}
	public String getXingchengshijian_2() {
		return xingchengshijian_2;
	}
	public void setXingchengshijian_2(String xingchengshijian_2) {
		this.xingchengshijian_2 = xingchengshijian_2;
	}
	public String getXingchengshijian_pingjunzhi() {
		return xingchengshijian_pingjunzhi;
	}
	public void setXingchengshijian_pingjunzhi(String xingchengshijian_pingjunzhi) {
		this.xingchengshijian_pingjunzhi = xingchengshijian_pingjunzhi;
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
	
	@Override
	public String toString(){
		return JsonUtil.objectToJson(this);
	}
}
