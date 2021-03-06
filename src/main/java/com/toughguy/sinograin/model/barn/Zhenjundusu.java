package com.toughguy.sinograin.model.barn;

import java.util.Date;

import com.toughguy.sinograin.model.AbstractModel;
import com.toughguy.sinograin.util.JsonUtil;
/**
 * 真菌毒素检测记录
 * 
 */
public class Zhenjundusu extends AbstractModel{

	private static final long serialVersionUID = -3124651049784617369L;
	
	private int smallSampleId;                   // 小样ID 
	private String zj_table_version;                //表格版本号
	private Date zj_riqi ;                          //日期
	private String zj_shiwen ;                        //室温
	private String zj_xiangduishidu;                //相对湿度
	private String zj_jiancefangfa;                 //检测方法
	private String zj_yiqishebei_mingcheng_1;       //仪器设备名称1
	private String zj_yiqishebei_mingcheng_2;       //仪器设备名称2
	private String zj_yiqishebei_bianhao_1;         //仪器设备编号1
	private String zj_yiqishebei_bianhao_2;         //仪器设备编号2
	private String outudushu_1;                  //呕吐毒素1
	private String outudushu_2;                  //呕吐毒素2
	private String outudushu_pingjunzhi;         //呕吐毒素平均值
	private String huangqumeidusu_1;             //黄曲霉毒素1
	private String huangqumeidusu_2;             //黄曲霉毒素2
	private String huangqumeidusu_pingjunzhi;    //黄曲霉毒素平均值
	private String yumichimeixitong_1;           //玉米赤霉烯酮1
	private String yumichimeixitong_2;           //玉米赤霉烯酮2
	private String yumichimeixitong_pingjunzhi;  //玉米赤霉烯酮平均值
	private String zhequmeidusu_1;               //赭曲霉毒素1
	private String zhequmeidusu_2;               //赭曲霉毒素2
	private String zhequmeidusu_pingjunzhi;      //赭曲霉毒素平均值
	private String beizhu;                       //备注
	private String jiance;                       //检测
	private String jiaohe;                       //校核
	

	public int getSmallSampleId() {
		return smallSampleId;
	}

	public void setSmallSampleId(int smallSampleId) {
		this.smallSampleId = smallSampleId;
	}

	public String getZj_table_version() {
		return zj_table_version;
	}

	public void setZj_table_version(String zj_table_version) {
		this.zj_table_version = zj_table_version;
	}

	public Date getZj_riqi() {
		return zj_riqi;
	}

	public void setZj_riqi(Date zj_riqi) {
		this.zj_riqi = zj_riqi;
	}

	public String getZj_shiwen() {
		return zj_shiwen;
	}

	public void setZj_shiwen(String zj_shiwen) {
		this.zj_shiwen = zj_shiwen;
	}

	public String getZj_xiangduishidu() {
		return zj_xiangduishidu;
	}

	public void setZj_xiangduishidu(String zj_xiangduishidu) {
		this.zj_xiangduishidu = zj_xiangduishidu;
	}

	public String getZj_jiancefangfa() {
		return zj_jiancefangfa;
	}

	public void setZj_jiancefangfa(String zj_jiancefangfa) {
		this.zj_jiancefangfa = zj_jiancefangfa;
	}

	public String getZj_yiqishebei_mingcheng_1() {
		return zj_yiqishebei_mingcheng_1;
	}

	public void setZj_yiqishebei_mingcheng_1(String zj_yiqishebei_mingcheng_1) {
		this.zj_yiqishebei_mingcheng_1 = zj_yiqishebei_mingcheng_1;
	}

	public String getZj_yiqishebei_mingcheng_2() {
		return zj_yiqishebei_mingcheng_2;
	}

	public void setZj_yiqishebei_mingcheng_2(String zj_yiqishebei_mingcheng_2) {
		this.zj_yiqishebei_mingcheng_2 = zj_yiqishebei_mingcheng_2;
	}

	public String getZj_yiqishebei_bianhao_1() {
		return zj_yiqishebei_bianhao_1;
	}

	public void setZj_yiqishebei_bianhao_1(String zj_yiqishebei_bianhao_1) {
		this.zj_yiqishebei_bianhao_1 = zj_yiqishebei_bianhao_1;
	}

	public String getZj_yiqishebei_bianhao_2() {
		return zj_yiqishebei_bianhao_2;
	}

	public void setZj_yiqishebei_bianhao_2(String zj_yiqishebei_bianhao_2) {
		this.zj_yiqishebei_bianhao_2 = zj_yiqishebei_bianhao_2;
	}

	public String getOutudushu_1() {
		return outudushu_1;
	}

	public void setOutudushu_1(String outudushu_1) {
		this.outudushu_1 = outudushu_1;
	}

	public String getOutudushu_2() {
		return outudushu_2;
	}

	public void setOutudushu_2(String outudushu_2) {
		this.outudushu_2 = outudushu_2;
	}

	public String getOutudushu_pingjunzhi() {
		return outudushu_pingjunzhi;
	}

	public void setOutudushu_pingjunzhi(String outudushu_pingjunzhi) {
		this.outudushu_pingjunzhi = outudushu_pingjunzhi;
	}

	public String getHuangqumeidusu_1() {
		return huangqumeidusu_1;
	}

	public void setHuangqumeidusu_1(String huangqumeidusu_1) {
		this.huangqumeidusu_1 = huangqumeidusu_1;
	}

	public String getHuangqumeidusu_2() {
		return huangqumeidusu_2;
	}

	public void setHuangqumeidusu_2(String huangqumeidusu_2) {
		this.huangqumeidusu_2 = huangqumeidusu_2;
	}

	public String getHuangqumeidusu_pingjunzhi() {
		return huangqumeidusu_pingjunzhi;
	}


	public void setHuangqumeidusu_pingjunzhi(String huangqumeidusu_pingjunzhi) {
		this.huangqumeidusu_pingjunzhi = huangqumeidusu_pingjunzhi;
	}

	public String getYumichimeixitong_1() {
		return yumichimeixitong_1;
	}


	public void setYumichimeixitong_1(String yumichimeixitong_1) {
		this.yumichimeixitong_1 = yumichimeixitong_1;
	}

	public String getYumichimeixitong_2() {
		return yumichimeixitong_2;
	}

	public void setYumichimeixitong_2(String yumichimeixitong_2) {
		this.yumichimeixitong_2 = yumichimeixitong_2;
	}

	public String getYumichimeixitong_pingjunzhi() {
		return yumichimeixitong_pingjunzhi;
	}

	public void setYumichimeixitong_pingjunzhi(String yumichimeixitong_pingjunzhi) {
		this.yumichimeixitong_pingjunzhi = yumichimeixitong_pingjunzhi;
	}

	public String getZhequmeidusu_1() {
		return zhequmeidusu_1;
	}

	public void setZhequmeidusu_1(String zhequmeidusu_1) {
		this.zhequmeidusu_1 = zhequmeidusu_1;
	}

	public String getZhequmeidusu_2() {
		return zhequmeidusu_2;
	}

	public void setZhequmeidusu_2(String zhequmeidusu_2) {
		this.zhequmeidusu_2 = zhequmeidusu_2;
	}

	public String getZhequmeidusu_pingjunzhi() {
		return zhequmeidusu_pingjunzhi;
	}

	public void setZhequmeidusu_pingjunzhi(String zhequmeidusu_pingjunzhi) {
		this.zhequmeidusu_pingjunzhi = zhequmeidusu_pingjunzhi;
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

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString(){
		return JsonUtil.objectToJson(this);
	}
	
}
