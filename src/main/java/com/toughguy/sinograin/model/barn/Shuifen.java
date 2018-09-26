package com.toughguy.sinograin.model.barn;

import java.util.Date;

import com.toughguy.sinograin.model.AbstractModel;
import com.toughguy.sinograin.util.JsonUtil;

/**
 * 
 * 水分测定记录
 */
public class Shuifen extends AbstractModel {

	private static final long serialVersionUID = 464599627973265946L;

	private int smallSampleId; // 样品ID
	private String s_table_version; // 表格版本号
	private Date s_riqi; // 日期
	private String s_shiwen; // 室温
	private String s_xiangduishidu; // 相对湿度
	private String s_jiancefangfa; // 检测方法
	private String s_yiqishebei_mingcheng_1; // 仪器设备名称1
	private String s_yiqishebei_mingcheng_2; // 仪器设备名称2
	private String s_yiqishebei_bianhao_1; // 仪器设备编号1
	private String s_yiqishebei_bianhao_2; // 仪器设备编号2
	private String qimin_bianhao_1; // 器皿编号1
	private String qimin_bianhao_2; // 器皿编号2
	private String hongqianqiminzhiliang_1; // 烘前器皿质量Wo（g）1
	private String hongqianqiminzhiliang_2; // 烘前器皿质量Wo（g）2
	private String hongqianqiminzhiliang_3; // 烘前器皿质量Wo（g）3
	private String hongqianqiminzhiliang_4; // 烘前器皿质量Wo（g）4
	private String shiyangzhiliang_1; // 试样质量W1（g）1
	private String shiyangzhiliang_2; // 试样质量W1（g）2
	private String hengzhongqiminjishiyang_hengzhonghouzhiliang_1; // 恒重器皿及试样（ ）℃（）恒重后质量W2（g）1
	private String hengzhongqiminjishiyang_hengzhonghouzhiliang_2; // 恒重器皿及试样（ ）℃（）恒重后质量W2（g）2
	private String hengzhongqiminjishiyang_hengzhonghouzhiliang_3; // 恒重器皿及试样（）℃（）恒重后质量W2（g）3
	private String hengzhongqiminjishiyang_hengzhonghouzhiliang_4; // 恒重器皿及试样（ ）℃（）恒重后质量W2（g）4
	private String shuifenhanliang_1; // 水分含量（%）1
	private String shuifenhanliang_2; // 水分含量（%）2
	private String pingjunzhi_1; // 平均值1（%）
	private String pingjunzhi_2; // 平均值2（%）
//	private String pingxingcha; // 平行差
//	private String xiangduicha; // 相对差（%）
	private String pingxingcha_xiangduicha;         //平行差或相对差
	private String pingxingcha_xiangduicha_zhi;      //平行差或相对差的值
	private String beizhu; // 备注
	private String jiance; // 检测
	private String jiaohe; // 校核


	public int getSmallSampleId() {
		return smallSampleId;
	}

	public void setSmallSampleId(int smallSampleId) {
		this.smallSampleId = smallSampleId;
	}


	public String getS_table_version() {
		return s_table_version;
	}

	public void setS_table_version(String s_table_version) {
		this.s_table_version = s_table_version;
	}

	public Date getS_riqi() {
		return s_riqi;
	}

	public void setS_riqi(Date s_riqi) {
		this.s_riqi = s_riqi;
	}

	public String getS_shiwen() {
		return s_shiwen;
	}

	public void setS_shiwen(String s_shiwen) {
		this.s_shiwen = s_shiwen;
	}

	public String getS_xiangduishidu() {
		return s_xiangduishidu;
	}

	public void setS_xiangduishidu(String s_xiangduishidu) {
		this.s_xiangduishidu = s_xiangduishidu;
	}

	public String getS_jiancefangfa() {
		return s_jiancefangfa;
	}

	public void setS_jiancefangfa(String s_jiancefangfa) {
		this.s_jiancefangfa = s_jiancefangfa;
	}

	public String getS_yiqishebei_mingcheng_1() {
		return s_yiqishebei_mingcheng_1;
	}

	public void setS_yiqishebei_mingcheng_1(String s_yiqishebei_mingcheng_1) {
		this.s_yiqishebei_mingcheng_1 = s_yiqishebei_mingcheng_1;
	}

	public String getS_yiqishebei_mingcheng_2() {
		return s_yiqishebei_mingcheng_2;
	}

	public void setS_yiqishebei_mingcheng_2(String s_yiqishebei_mingcheng_2) {
		this.s_yiqishebei_mingcheng_2 = s_yiqishebei_mingcheng_2;
	}

	public String getS_yiqishebei_bianhao_1() {
		return s_yiqishebei_bianhao_1;
	}

	public void setS_yiqishebei_bianhao_1(String s_yiqishebei_bianhao_1) {
		this.s_yiqishebei_bianhao_1 = s_yiqishebei_bianhao_1;
	}

	public String getS_yiqishebei_bianhao_2() {
		return s_yiqishebei_bianhao_2;
	}

	public void setS_yiqishebei_bianhao_2(String s_yiqishebei_bianhao_2) {
		this.s_yiqishebei_bianhao_2 = s_yiqishebei_bianhao_2;
	}

	public String getQimin_bianhao_1() {
		return qimin_bianhao_1;
	}

	public void setQimin_bianhao_1(String qimin_bianhao_1) {
		this.qimin_bianhao_1 = qimin_bianhao_1;
	}

	public String getQimin_bianhao_2() {
		return qimin_bianhao_2;
	}

	public void setQimin_bianhao_2(String qimin_bianhao_2) {
		this.qimin_bianhao_2 = qimin_bianhao_2;
	}

	public String getHongqianqiminzhiliang_1() {
		return hongqianqiminzhiliang_1;
	}

	public void setHongqianqiminzhiliang_1(String hongqianqiminzhiliang_1) {
		this.hongqianqiminzhiliang_1 = hongqianqiminzhiliang_1;
	}

	public String getHongqianqiminzhiliang_2() {
		return hongqianqiminzhiliang_2;
	}

	public void setHongqianqiminzhiliang_2(String hongqianqiminzhiliang_2) {
		this.hongqianqiminzhiliang_2 = hongqianqiminzhiliang_2;
	}

	public String getHongqianqiminzhiliang_3() {
		return hongqianqiminzhiliang_3;
	}

	public void setHongqianqiminzhiliang_3(String hongqianqiminzhiliang_3) {
		this.hongqianqiminzhiliang_3 = hongqianqiminzhiliang_3;
	}

	public String getHongqianqiminzhiliang_4() {
		return hongqianqiminzhiliang_4;
	}

	public void setHongqianqiminzhiliang_4(String hongqianqiminzhiliang_4) {
		this.hongqianqiminzhiliang_4 = hongqianqiminzhiliang_4;
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

	public String getHengzhongqiminjishiyang_hengzhonghouzhiliang_1() {
		return hengzhongqiminjishiyang_hengzhonghouzhiliang_1;
	}

	public void setHengzhongqiminjishiyang_hengzhonghouzhiliang_1(
			String hengzhongqiminjishiyang_hengzhonghouzhiliang_1) {
		this.hengzhongqiminjishiyang_hengzhonghouzhiliang_1 = hengzhongqiminjishiyang_hengzhonghouzhiliang_1;
	}

	public String getHengzhongqiminjishiyang_hengzhonghouzhiliang_2() {
		return hengzhongqiminjishiyang_hengzhonghouzhiliang_2;
	}

	public void setHengzhongqiminjishiyang_hengzhonghouzhiliang_2(
			String hengzhongqiminjishiyang_hengzhonghouzhiliang_2) {
		this.hengzhongqiminjishiyang_hengzhonghouzhiliang_2 = hengzhongqiminjishiyang_hengzhonghouzhiliang_2;
	}

	public String getHengzhongqiminjishiyang_hengzhonghouzhiliang_3() {
		return hengzhongqiminjishiyang_hengzhonghouzhiliang_3;
	}

	public void setHengzhongqiminjishiyang_hengzhonghouzhiliang_3(
			String hengzhongqiminjishiyang_hengzhonghouzhiliang_3) {
		this.hengzhongqiminjishiyang_hengzhonghouzhiliang_3 = hengzhongqiminjishiyang_hengzhonghouzhiliang_3;
	}

	public String getHengzhongqiminjishiyang_hengzhonghouzhiliang_4() {
		return hengzhongqiminjishiyang_hengzhonghouzhiliang_4;
	}

	public void setHengzhongqiminjishiyang_hengzhonghouzhiliang_4(
			String hengzhongqiminjishiyang_hengzhonghouzhiliang_4) {
		this.hengzhongqiminjishiyang_hengzhonghouzhiliang_4 = hengzhongqiminjishiyang_hengzhonghouzhiliang_4;
	}


	public String getShuifenhanliang_1() {
		return shuifenhanliang_1;
	}

	public void setShuifenhanliang_1(String shuifenhanliang_1) {
		this.shuifenhanliang_1 = shuifenhanliang_1;
	}

	public String getShuifenhanliang_2() {
		return shuifenhanliang_2;
	}

	public void setShuifenhanliang_2(String shuifenhanliang_2) {
		this.shuifenhanliang_2 = shuifenhanliang_2;
	}

	

//	public String getPingxingcha() {
//		return pingxingcha;
//	}
//
//	public void setPingxingcha(String pingxingcha) {
//		this.pingxingcha = pingxingcha;
//	}
//
//	public String getXiangduicha() {
//		return xiangduicha;
//	}
//
//	public void setXiangduicha(String xiangduicha) {
//		this.xiangduicha = xiangduicha;
//	}
	

	public String getPingjunzhi_1() {
		return pingjunzhi_1;
	}

	public void setPingjunzhi_1(String pingjunzhi_1) {
		this.pingjunzhi_1 = pingjunzhi_1;
	}

	public String getPingjunzhi_2() {
		return pingjunzhi_2;
	}

	public void setPingjunzhi_2(String pingjunzhi_2) {
		this.pingjunzhi_2 = pingjunzhi_2;
	}

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


	@Override
	public String toString() {
		return JsonUtil.objectToJson(this);
	}

}
