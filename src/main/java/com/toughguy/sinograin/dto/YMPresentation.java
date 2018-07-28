package com.toughguy.sinograin.dto;

/**
 * 玉米检验报告
 * @author  YAO
 * @date:   2018年7月27日 上午11:11:07
 */
public class YMPresentation {

	private String bianhao_1;         //编号1
	private String bianhao_2;         //编号2
	private String sort;         	//产品名称（种类）
	private String sampleNum;    	//检验编号
	private String cunchudanwei; 	//储存单位
	private int counter;         	//仓（货位）号
	private String shengchanniandu; //生产年度 
	private String quality;         //储粮性质
	private String  daibiaoshuliang;//代表数量（吨数）
	private String  sampleCount;    //样品数量（公斤）
	private String  yangpinmiaoshu; //样品描述
	private String  yangpinzhuangtai; //样品状态
	private String  qianyangren; 	 //扦样人
	private String  sampleTime; 	 //扦样时间
	private String  qianyangyiju; 	 //扦样依据
	private String  jianyanmudi; 	 //检验目的
	private String  jianyanshijian;  //检验时间
	private String  jianyanyiju; 	 //检验依据
	private String  jianyanxiangmu;  //检验项目
	private String  jianyanjielun;   //检验结论
	private String  beizhu;  		 //备注
	private String  rongzhongbiaozhunyaoqiu;  //容重标准要求
	private String  rongzhongjiancejieguo;    //容重检测结果
	private String  rongzhongdanxiangpingjia; //容重单项评价
	private String  buwanshanlizongliangbiaozhunyaoqiu;  //不完善粒总量标准要求
	private String  buwanshanlizongliangjiancejieguo;    //不完善粒总量检测结果
	private String  buwanshanlizongliangdanxiangpingjia; //不完善粒总量单项评价
	private String  buwanshanlishengmeilibiaozhunyaoqiu;  //不完善粒生霉粒标准要求
	private String  buwanshanlishengmeilijiancejieguo;    //不完善粒生霉粒标检测结果
	private String  buwanshanlishengmeilidanxiangpingjia; //不完善粒生霉粒标单项评价
	private String  zazhibiaozhunyaoqiu;  //杂质标准要求
	private String  zazhijiancejieguo;    //杂质检测结果
	private String  zazhidanxiangpingjia; //杂质单项评价
	private String  shuifenbiaozhunyaoqiu;  //水分标准要求
	private String  shuifenjiancejieguo;    //水分检测结果
	private String  shuifendanxiangpingjia; //水分单项评价
	private String  zhifangsuanzhi_yicun; 		  //脂肪酸酯—宜存
	private String  zhifangsuanzhi_qingdubuyicun;  //脂肪酸酯—轻度不宜存
	private String  zhifangsuanzhi_zhongdubuyicun; //脂肪酸酯—重度不宜存
	private String  zhifangsuanzhi_jianyanjieguo;  //脂肪酸酯—检验结果
	private String  pinchangpingfen_yicun; 		  //品尝评分—宜存
	private String  pinchangpingfen_qingdubuyicun;  //品尝评分—轻度不宜存
	private String  pinchangpingfen_zhongdubuyicun; //品尝评分—重度不宜存
	private String  pinchangpingfen_jianyanjieguo;  //品尝评分—检验结果
	private String  sezeqiwei_yicun; 		  //色泽气味—宜存
	private String  sezeqiwei_qingdubuyicun;  //色泽气味—轻度不宜存
	private String  sezeqiwei_zhongdubuyicun; //色泽气味—重度不宜存
	private String  sezeqiwei_jianyanjieguo;  //色泽气味—检验结果
	private String  jieguopanding;  		  //结果判定
	
	public String getBianhao_1() {
		return bianhao_1;
	}
	public void setBianhao_1(String bianhao_1) {
		this.bianhao_1 = bianhao_1;
	}
	public String getBianhao_2() {
		return bianhao_2;
	}
	public void setBianhao_2(String bianhao_2) {
		this.bianhao_2 = bianhao_2;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getSampleNum() {
		return sampleNum;
	}
	public void setSampleNum(String sampleNum) {
		this.sampleNum = sampleNum;
	}
	public String getCunchudanwei() {
		return cunchudanwei;
	}
	public void setCunchudanwei(String cunchudanwei) {
		this.cunchudanwei = cunchudanwei;
	}
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	public String getShengchanniandu() {
		return shengchanniandu;
	}
	public void setShengchanniandu(String shengchanniandu) {
		this.shengchanniandu = shengchanniandu;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	public String getDaibiaoshuliang() {
		return daibiaoshuliang;
	}
	public void setDaibiaoshuliang(String daibiaoshuliang) {
		this.daibiaoshuliang = daibiaoshuliang;
	}
	public String getSampleCount() {
		return sampleCount;
	}
	public void setSampleCount(String sampleCount) {
		this.sampleCount = sampleCount;
	}
	public String getYangpinmiaoshu() {
		return yangpinmiaoshu;
	}
	public void setYangpinmiaoshu(String yangpinmiaoshu) {
		this.yangpinmiaoshu = yangpinmiaoshu;
	}
	public String getYangpinzhuangtai() {
		return yangpinzhuangtai;
	}
	public void setYangpinzhuangtai(String yangpinzhuangtai) {
		this.yangpinzhuangtai = yangpinzhuangtai;
	}
	public String getQianyangren() {
		return qianyangren;
	}
	public void setQianyangren(String qianyangren) {
		this.qianyangren = qianyangren;
	}
	public String getSampleTime() {
		return sampleTime;
	}
	public void setSampleTime(String sampleTime) {
		this.sampleTime = sampleTime;
	}
	public String getQianyangyiju() {
		return qianyangyiju;
	}
	public void setQianyangyiju(String qianyangyiju) {
		this.qianyangyiju = qianyangyiju;
	}
	public String getJianyanmudi() {
		return jianyanmudi;
	}
	public void setJianyanmudi(String jianyanmudi) {
		this.jianyanmudi = jianyanmudi;
	}
	public String getJianyanshijian() {
		return jianyanshijian;
	}
	public void setJianyanshijian(String jianyanshijian) {
		this.jianyanshijian = jianyanshijian;
	}
	public String getJianyanyiju() {
		return jianyanyiju;
	}
	public void setJianyanyiju(String jianyanyiju) {
		this.jianyanyiju = jianyanyiju;
	}
	public String getJianyanxiangmu() {
		return jianyanxiangmu;
	}
	public void setJianyanxiangmu(String jianyanxiangmu) {
		this.jianyanxiangmu = jianyanxiangmu;
	}
	public String getJianyanjielun() {
		return jianyanjielun;
	}
	public void setJianyanjielun(String jianyanjielun) {
		this.jianyanjielun = jianyanjielun;
	}
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	public String getRongzhongbiaozhunyaoqiu() {
		return rongzhongbiaozhunyaoqiu;
	}
	public void setRongzhongbiaozhunyaoqiu(String rongzhongbiaozhunyaoqiu) {
		this.rongzhongbiaozhunyaoqiu = rongzhongbiaozhunyaoqiu;
	}
	public String getRongzhongjiancejieguo() {
		return rongzhongjiancejieguo;
	}
	public void setRongzhongjiancejieguo(String rongzhongjiancejieguo) {
		this.rongzhongjiancejieguo = rongzhongjiancejieguo;
	}
	public String getRongzhongdanxiangpingjia() {
		return rongzhongdanxiangpingjia;
	}
	public void setRongzhongdanxiangpingjia(String rongzhongdanxiangpingjia) {
		this.rongzhongdanxiangpingjia = rongzhongdanxiangpingjia;
	}
	public String getBuwanshanlizongliangbiaozhunyaoqiu() {
		return buwanshanlizongliangbiaozhunyaoqiu;
	}
	public void setBuwanshanlizongliangbiaozhunyaoqiu(String buwanshanlizongliangbiaozhunyaoqiu) {
		this.buwanshanlizongliangbiaozhunyaoqiu = buwanshanlizongliangbiaozhunyaoqiu;
	}
	public String getBuwanshanlizongliangjiancejieguo() {
		return buwanshanlizongliangjiancejieguo;
	}
	public void setBuwanshanlizongliangjiancejieguo(String buwanshanlizongliangjiancejieguo) {
		this.buwanshanlizongliangjiancejieguo = buwanshanlizongliangjiancejieguo;
	}
	public String getBuwanshanlizongliangdanxiangpingjia() {
		return buwanshanlizongliangdanxiangpingjia;
	}
	public void setBuwanshanlizongliangdanxiangpingjia(String buwanshanlizongliangdanxiangpingjia) {
		this.buwanshanlizongliangdanxiangpingjia = buwanshanlizongliangdanxiangpingjia;
	}
	public String getBuwanshanlishengmeilibiaozhunyaoqiu() {
		return buwanshanlishengmeilibiaozhunyaoqiu;
	}
	public void setBuwanshanlishengmeilibiaozhunyaoqiu(String buwanshanlishengmeilibiaozhunyaoqiu) {
		this.buwanshanlishengmeilibiaozhunyaoqiu = buwanshanlishengmeilibiaozhunyaoqiu;
	}
	public String getBuwanshanlishengmeilijiancejieguo() {
		return buwanshanlishengmeilijiancejieguo;
	}
	public void setBuwanshanlishengmeilijiancejieguo(String buwanshanlishengmeilijiancejieguo) {
		this.buwanshanlishengmeilijiancejieguo = buwanshanlishengmeilijiancejieguo;
	}
	public String getBuwanshanlishengmeilidanxiangpingjia() {
		return buwanshanlishengmeilidanxiangpingjia;
	}
	public void setBuwanshanlishengmeilidanxiangpingjia(String buwanshanlishengmeilidanxiangpingjia) {
		this.buwanshanlishengmeilidanxiangpingjia = buwanshanlishengmeilidanxiangpingjia;
	}
	public String getZazhibiaozhunyaoqiu() {
		return zazhibiaozhunyaoqiu;
	}
	public void setZazhibiaozhunyaoqiu(String zazhibiaozhunyaoqiu) {
		this.zazhibiaozhunyaoqiu = zazhibiaozhunyaoqiu;
	}
	public String getZazhijiancejieguo() {
		return zazhijiancejieguo;
	}
	public void setZazhijiancejieguo(String zazhijiancejieguo) {
		this.zazhijiancejieguo = zazhijiancejieguo;
	}
	public String getZazhidanxiangpingjia() {
		return zazhidanxiangpingjia;
	}
	public void setZazhidanxiangpingjia(String zazhidanxiangpingjia) {
		this.zazhidanxiangpingjia = zazhidanxiangpingjia;
	}
	public String getShuifenbiaozhunyaoqiu() {
		return shuifenbiaozhunyaoqiu;
	}
	public void setShuifenbiaozhunyaoqiu(String shuifenbiaozhunyaoqiu) {
		this.shuifenbiaozhunyaoqiu = shuifenbiaozhunyaoqiu;
	}
	public String getShuifenjiancejieguo() {
		return shuifenjiancejieguo;
	}
	public void setShuifenjiancejieguo(String shuifenjiancejieguo) {
		this.shuifenjiancejieguo = shuifenjiancejieguo;
	}
	public String getShuifendanxiangpingjia() {
		return shuifendanxiangpingjia;
	}
	public void setShuifendanxiangpingjia(String shuifendanxiangpingjia) {
		this.shuifendanxiangpingjia = shuifendanxiangpingjia;
	}
	public String getZhifangsuanzhi_yicun() {
		return zhifangsuanzhi_yicun;
	}
	public void setZhifangsuanzhi_yicun(String zhifangsuanzhi_yicun) {
		this.zhifangsuanzhi_yicun = zhifangsuanzhi_yicun;
	}
	public String getZhifangsuanzhi_qingdubuyicun() {
		return zhifangsuanzhi_qingdubuyicun;
	}
	public void setZhifangsuanzhi_qingdubuyicun(String zhifangsuanzhi_qingdubuyicun) {
		this.zhifangsuanzhi_qingdubuyicun = zhifangsuanzhi_qingdubuyicun;
	}
	public String getZhifangsuanzhi_zhongdubuyicun() {
		return zhifangsuanzhi_zhongdubuyicun;
	}
	public void setZhifangsuanzhi_zhongdubuyicun(String zhifangsuanzhi_zhongdubuyicun) {
		this.zhifangsuanzhi_zhongdubuyicun = zhifangsuanzhi_zhongdubuyicun;
	}
	public String getZhifangsuanzhi_jianyanjieguo() {
		return zhifangsuanzhi_jianyanjieguo;
	}
	public void setZhifangsuanzhi_jianyanjieguo(String zhifangsuanzhi_jianyanjieguo) {
		this.zhifangsuanzhi_jianyanjieguo = zhifangsuanzhi_jianyanjieguo;
	}
	public String getPinchangpingfen_yicun() {
		return pinchangpingfen_yicun;
	}
	public void setPinchangpingfen_yicun(String pinchangpingfen_yicun) {
		this.pinchangpingfen_yicun = pinchangpingfen_yicun;
	}
	public String getPinchangpingfen_qingdubuyicun() {
		return pinchangpingfen_qingdubuyicun;
	}
	public void setPinchangpingfen_qingdubuyicun(String pinchangpingfen_qingdubuyicun) {
		this.pinchangpingfen_qingdubuyicun = pinchangpingfen_qingdubuyicun;
	}
	public String getPinchangpingfen_zhongdubuyicun() {
		return pinchangpingfen_zhongdubuyicun;
	}
	public void setPinchangpingfen_zhongdubuyicun(String pinchangpingfen_zhongdubuyicun) {
		this.pinchangpingfen_zhongdubuyicun = pinchangpingfen_zhongdubuyicun;
	}
	public String getPinchangpingfen_jianyanjieguo() {
		return pinchangpingfen_jianyanjieguo;
	}
	public void setPinchangpingfen_jianyanjieguo(String pinchangpingfen_jianyanjieguo) {
		this.pinchangpingfen_jianyanjieguo = pinchangpingfen_jianyanjieguo;
	}
	public String getSezeqiwei_yicun() {
		return sezeqiwei_yicun;
	}
	public void setSezeqiwei_yicun(String sezeqiwei_yicun) {
		this.sezeqiwei_yicun = sezeqiwei_yicun;
	}
	public String getSezeqiwei_qingdubuyicun() {
		return sezeqiwei_qingdubuyicun;
	}
	public void setSezeqiwei_qingdubuyicun(String sezeqiwei_qingdubuyicun) {
		this.sezeqiwei_qingdubuyicun = sezeqiwei_qingdubuyicun;
	}
	public String getSezeqiwei_zhongdubuyicun() {
		return sezeqiwei_zhongdubuyicun;
	}
	public void setSezeqiwei_zhongdubuyicun(String sezeqiwei_zhongdubuyicun) {
		this.sezeqiwei_zhongdubuyicun = sezeqiwei_zhongdubuyicun;
	}
	public String getSezeqiwei_jianyanjieguo() {
		return sezeqiwei_jianyanjieguo;
	}
	public void setSezeqiwei_jianyanjieguo(String sezeqiwei_jianyanjieguo) {
		this.sezeqiwei_jianyanjieguo = sezeqiwei_jianyanjieguo;
	}
	public String getJieguopanding() {
		return jieguopanding;
	}
	public void setJieguopanding(String jieguopanding) {
		this.jieguopanding = jieguopanding;
	}
	
}
