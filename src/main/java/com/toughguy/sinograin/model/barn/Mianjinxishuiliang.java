package com.toughguy.sinograin.model.barn;

import java.util.Date;

import com.toughguy.sinograin.model.AbstractModel;
import com.toughguy.sinograin.util.JsonUtil;
/**
 * 面筋吸水量测定记录
 */
public class Mianjinxishuiliang extends AbstractModel{
	
	private static final long serialVersionUID = 464599627973265946L;
	
	
	private int smallSampleId;                      // 小样ID 
	private String m_table_version;                   //表格版本号
	private Date m_riqi ;                             //日期
	private String m_shiwen ;                           //室温
	private String m_xiangduishidu;                   //相对湿度
	private String m_jiancefangfa;                    //检测方法
	private String m_yiqishebei_mingcheng_1;          //仪器设备名称1
	private String m_yiqishebei_mingcheng_2;          //仪器设备名称2
	private String m_yiqishebei_mingcheng_3;          //仪器设备名称3
	private String m_yiqishebei_bianhao_1;            //仪器设备编号1
	private String m_yiqishebei_bianhao_2;            //仪器设备编号2
	private String m_yiqishebei_bianhao_3;            //仪器设备编号3
	private String shiyangzhiliang_1;               //试样质量m（g）1
	private String shiyangzhiliang_2;               //试样质量m（g）2
	private String shimianjinzhiliang_1;            //湿面筋质量m1（g）1
	private String shimianjinzhiliang_2;            //湿面筋质量m1（g）2
	private String ganmianjinzhiliang_1;            //干面筋质量m2（g）1
	private String ganmianjinzhiliang_2;            //干面筋质量m2（g）2
	private String mianjinxishuiliang_1;            //面筋吸水量M（%）1
	private String mianjinxishuiliang_2;            //面筋吸水量M（%）2
	private String pingjunzhiganmianjinzhiliang;    //平均值干面筋质量m2（g）
	private String beizhu;                          //备注
	private String jiance;                          //检测
	private String jiaohe;                          //校核
	
	
	
	public int getSmallSampleId() {
		return smallSampleId;
	}
	public void setSmallSampleId(int smallSampleId) {
		this.smallSampleId = smallSampleId;
	}

	public String getM_table_version() {
		return m_table_version;
	}
	public void setM_table_version(String m_table_version) {
		this.m_table_version = m_table_version;
	}
	public Date getM_riqi() {
		return m_riqi;
	}
	public void setM_riqi(Date m_riqi) {
		this.m_riqi = m_riqi;
	}
	public String getM_shiwen() {
		return m_shiwen;
	}
	public void setM_shiwen(String m_shiwen) {
		this.m_shiwen = m_shiwen;
	}
	public String getM_xiangduishidu() {
		return m_xiangduishidu;
	}
	public void setM_xiangduishidu(String m_xiangduishidu) {
		this.m_xiangduishidu = m_xiangduishidu;
	}
	public String getM_jiancefangfa() {
		return m_jiancefangfa;
	}
	public void setM_jiancefangfa(String m_jiancefangfa) {
		this.m_jiancefangfa = m_jiancefangfa;
	}
	public String getM_yiqishebei_mingcheng_1() {
		return m_yiqishebei_mingcheng_1;
	}
	public void setM_yiqishebei_mingcheng_1(String m_yiqishebei_mingcheng_1) {
		this.m_yiqishebei_mingcheng_1 = m_yiqishebei_mingcheng_1;
	}
	public String getM_yiqishebei_mingcheng_2() {
		return m_yiqishebei_mingcheng_2;
	}
	public void setM_yiqishebei_mingcheng_2(String m_yiqishebei_mingcheng_2) {
		this.m_yiqishebei_mingcheng_2 = m_yiqishebei_mingcheng_2;
	}
	public String getM_yiqishebei_mingcheng_3() {
		return m_yiqishebei_mingcheng_3;
	}
	public void setM_yiqishebei_mingcheng_3(String m_yiqishebei_mingcheng_3) {
		this.m_yiqishebei_mingcheng_3 = m_yiqishebei_mingcheng_3;
	}
	public String getM_yiqishebei_bianhao_1() {
		return m_yiqishebei_bianhao_1;
	}
	public void setM_yiqishebei_bianhao_1(String m_yiqishebei_bianhao_1) {
		this.m_yiqishebei_bianhao_1 = m_yiqishebei_bianhao_1;
	}
	public String getM_yiqishebei_bianhao_2() {
		return m_yiqishebei_bianhao_2;
	}
	public void setM_yiqishebei_bianhao_2(String m_yiqishebei_bianhao_2) {
		this.m_yiqishebei_bianhao_2 = m_yiqishebei_bianhao_2;
	}
	public String getM_yiqishebei_bianhao_3() {
		return m_yiqishebei_bianhao_3;
	}
	public void setM_yiqishebei_bianhao_3(String m_yiqishebei_bianhao_3) {
		this.m_yiqishebei_bianhao_3 = m_yiqishebei_bianhao_3;
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
	public String getShimianjinzhiliang_1() {
		return shimianjinzhiliang_1;
	}
	public void setShimianjinzhiliang_1(String shimianjinzhiliang_1) {
		this.shimianjinzhiliang_1 = shimianjinzhiliang_1;
	}
	public String getShimianjinzhiliang_2() {
		return shimianjinzhiliang_2;
	}
	public void setShimianjinzhiliang_2(String shimianjinzhiliang_2) {
		this.shimianjinzhiliang_2 = shimianjinzhiliang_2;
	}
	public String getGanmianjinzhiliang_1() {
		return ganmianjinzhiliang_1;
	}
	public void setGanmianjinzhiliang_1(String ganmianjinzhiliang_1) {
		this.ganmianjinzhiliang_1 = ganmianjinzhiliang_1;
	}
	public String getGanmianjinzhiliang_2() {
		return ganmianjinzhiliang_2;
	}
	public void setGanmianjinzhiliang_2(String ganmianjinzhiliang_2) {
		this.ganmianjinzhiliang_2 = ganmianjinzhiliang_2;
	}
	public String getMianjinxishuiliang_1() {
		return mianjinxishuiliang_1;
	}
	public void setMianjinxishuiliang_1(String mianjinxishuiliang_1) {
		this.mianjinxishuiliang_1 = mianjinxishuiliang_1;
	}
	public String getMianjinxishuiliang_2() {
		return mianjinxishuiliang_2;
	}
	public void setMianjinxishuiliang_2(String mianjinxishuiliang_2) {
		this.mianjinxishuiliang_2 = mianjinxishuiliang_2;
	}
	public String getPingjunzhiganmianjinzhiliang() {
		return pingjunzhiganmianjinzhiliang;
	}
	public void setPingjunzhiganmianjinzhiliang(String pingjunzhiganmianjinzhiliang) {
		this.pingjunzhiganmianjinzhiliang = pingjunzhiganmianjinzhiliang;
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
