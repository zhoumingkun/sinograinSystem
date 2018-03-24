package com.toughguy.sinograin.model.barn;

import java.util.Date;

import com.toughguy.sinograin.model.AbstractModel;
import com.toughguy.sinograin.util.JsonUtil;

public class Mantoubirong extends AbstractModel{
	
	private static final long serialVersionUID = -3124651049784617369L;
	
	private String table_version;                //表格版本号
	private Date riqi ;                          //日期
	private String shiwen ;                      //室温
	private String xiangduishidu;                //相对湿度
	private String didian;                       //地点
	private String jiancefangfa;                 //检测方法
	private String yiqishebei_mingcheng_1;       //仪器设备名称1
	private String yiqishebei_mingcheng_2;       //仪器设备名称2
	private String yiqishebei_bianhao_1;         //仪器设备编号1
	private String yiqishebei_bianhao_2;         //仪器设备编号2
	private String content;                      //内容
	private String jiance;                       //检测
	private String jiaohe;                       //校核
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
