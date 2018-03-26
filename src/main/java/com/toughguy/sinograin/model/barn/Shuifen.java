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
	private String table_version; // 表格版本号
	private Date riqi; // 日期
	private String shiwen; // 室温
	private String xiangduishidu; // 相对湿度
	private String jiancefangfa; // 检测方法
	private String yiqishebei_mingcheng_1; // 仪器设备名称1
	private String yiqishebei_mingcheng_2; // 仪器设备名称2
	private String yiqishebei_bianhao_1; // 仪器设备编号1
	private String yiqishebei_bianhao_2; // 仪器设备编号2
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
	private String pingjunzhi; // 平均值（%）
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

	public String getPingjunzhi() {
		return pingjunzhi;
	}

	public void setPingjunzhi(String pingjunzhi) {
		this.pingjunzhi = pingjunzhi;
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
