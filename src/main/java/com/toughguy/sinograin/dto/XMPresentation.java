package com.toughguy.sinograin.dto;

/**
 * 小麦检验报告
 * @author  YAO
 * @date:   2018年7月27日 上午11:11:07
 */
public class XMPresentation {

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
	private String  buwanshanlibiaozhunyaoqiu;  //不完善粒标准要求
	private String  buwanshanlijiancejieguo;    //不完善粒检测结果
	private String  buwanshanlidanxiangpingjia; //不完善粒单项评价
	private String  zazhizongliangbiaozhunyaoqiu;  //杂质总量标准要求
	private String  zazhizongliangjiancejieguo;    //杂质总量检测结果
	private String  zazhizongliangdanxiangpingjia; //杂质总量单项评价
	private String  zazhikuangwuzhibiaozhunyaoqiu;  //杂质矿物质标准要求
	private String  zazhikuangwuzhijiancejieguo;    //杂质矿物质检测结果
	private String  zazhikuangwuzhidanxiangpingjia; //杂质矿物质单项评价
	private String  shuifenbiaozhunyaoqiu;  //水分标准要求
	private String  shuifenjiancejieguo;    //水分检测结果
	private String  shuifendanxiangpingjia; //水分单项评价
	private String  yingduzhishu_1_biaozhunyaoqiu;  //硬度指数 1 标准要求
	private String  yingduzhishu_2_biaozhunyaoqiu;  //硬度指数 2 标准要求
	private String  yingduzhishu_3_biaozhunyaoqiu;  //硬度指数 3 标准要求
	private String  yingduzhishujiancejieguo;    //硬度指数检测结果
	private String  yingduzhishudanxiangpingjia; //硬度指数单项评价
	private String  sezeqiweibiaozhunyaoqiu;  //色泽气味标准要求
	private String  sezeqiweijiancejieguo;    //色泽气味检测结果
	private String  sezeqiweidanxiangpingjia; //色泽气味单项评价
	private String  mianjinxishui_yicun; 		  //面筋吸水量(%)—宜存
	private String  mianjinxishui_qingdubuyicun;  //面筋吸水量(%)—轻度不宜存
	private String  mianjinxishui_zhongdubuyicun; //面筋吸水量(%)—重度不宜存
	private String  mianjinxishui_jianyanjieguo;  //面筋吸水量(%)—检验结果
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
	public String getBuwanshanlibiaozhunyaoqiu() {
		return buwanshanlibiaozhunyaoqiu;
	}
	public void setBuwanshanlibiaozhunyaoqiu(String buwanshanlibiaozhunyaoqiu) {
		this.buwanshanlibiaozhunyaoqiu = buwanshanlibiaozhunyaoqiu;
	}
	public String getBuwanshanlijiancejieguo() {
		return buwanshanlijiancejieguo;
	}
	public void setBuwanshanlijiancejieguo(String buwanshanlijiancejieguo) {
		this.buwanshanlijiancejieguo = buwanshanlijiancejieguo;
	}
	public String getBuwanshanlidanxiangpingjia() {
		return buwanshanlidanxiangpingjia;
	}
	public void setBuwanshanlidanxiangpingjia(String buwanshanlidanxiangpingjia) {
		this.buwanshanlidanxiangpingjia = buwanshanlidanxiangpingjia;
	}
	public String getZazhizongliangbiaozhunyaoqiu() {
		return zazhizongliangbiaozhunyaoqiu;
	}
	public void setZazhizongliangbiaozhunyaoqiu(String zazhizongliangbiaozhunyaoqiu) {
		this.zazhizongliangbiaozhunyaoqiu = zazhizongliangbiaozhunyaoqiu;
	}
	public String getZazhizongliangjiancejieguo() {
		return zazhizongliangjiancejieguo;
	}
	public void setZazhizongliangjiancejieguo(String zazhizongliangjiancejieguo) {
		this.zazhizongliangjiancejieguo = zazhizongliangjiancejieguo;
	}
	public String getZazhizongliangdanxiangpingjia() {
		return zazhizongliangdanxiangpingjia;
	}
	public void setZazhizongliangdanxiangpingjia(String zazhizongliangdanxiangpingjia) {
		this.zazhizongliangdanxiangpingjia = zazhizongliangdanxiangpingjia;
	}
	public String getZazhikuangwuzhibiaozhunyaoqiu() {
		return zazhikuangwuzhibiaozhunyaoqiu;
	}
	public void setZazhikuangwuzhibiaozhunyaoqiu(String zazhikuangwuzhibiaozhunyaoqiu) {
		this.zazhikuangwuzhibiaozhunyaoqiu = zazhikuangwuzhibiaozhunyaoqiu;
	}
	public String getZazhikuangwuzhijiancejieguo() {
		return zazhikuangwuzhijiancejieguo;
	}
	public void setZazhikuangwuzhijiancejieguo(String zazhikuangwuzhijiancejieguo) {
		this.zazhikuangwuzhijiancejieguo = zazhikuangwuzhijiancejieguo;
	}
	public String getZazhikuangwuzhidanxiangpingjia() {
		return zazhikuangwuzhidanxiangpingjia;
	}
	public void setZazhikuangwuzhidanxiangpingjia(String zazhikuangwuzhidanxiangpingjia) {
		this.zazhikuangwuzhidanxiangpingjia = zazhikuangwuzhidanxiangpingjia;
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
	public String getYingduzhishu_1_biaozhunyaoqiu() {
		return yingduzhishu_1_biaozhunyaoqiu;
	}
	public void setYingduzhishu_1_biaozhunyaoqiu(String yingduzhishu_1_biaozhunyaoqiu) {
		this.yingduzhishu_1_biaozhunyaoqiu = yingduzhishu_1_biaozhunyaoqiu;
	}
	public String getYingduzhishu_2_biaozhunyaoqiu() {
		return yingduzhishu_2_biaozhunyaoqiu;
	}
	public void setYingduzhishu_2_biaozhunyaoqiu(String yingduzhishu_2_biaozhunyaoqiu) {
		this.yingduzhishu_2_biaozhunyaoqiu = yingduzhishu_2_biaozhunyaoqiu;
	}
	public String getYingduzhishu_3_biaozhunyaoqiu() {
		return yingduzhishu_3_biaozhunyaoqiu;
	}
	public void setYingduzhishu_3_biaozhunyaoqiu(String yingduzhishu_3_biaozhunyaoqiu) {
		this.yingduzhishu_3_biaozhunyaoqiu = yingduzhishu_3_biaozhunyaoqiu;
	}
	public String getYingduzhishujiancejieguo() {
		return yingduzhishujiancejieguo;
	}
	public void setYingduzhishujiancejieguo(String yingduzhishujiancejieguo) {
		this.yingduzhishujiancejieguo = yingduzhishujiancejieguo;
	}
	public String getYingduzhishudanxiangpingjia() {
		return yingduzhishudanxiangpingjia;
	}
	public void setYingduzhishudanxiangpingjia(String yingduzhishudanxiangpingjia) {
		this.yingduzhishudanxiangpingjia = yingduzhishudanxiangpingjia;
	}
	public String getSezeqiweibiaozhunyaoqiu() {
		return sezeqiweibiaozhunyaoqiu;
	}
	public void setSezeqiweibiaozhunyaoqiu(String sezeqiweibiaozhunyaoqiu) {
		this.sezeqiweibiaozhunyaoqiu = sezeqiweibiaozhunyaoqiu;
	}
	public String getSezeqiweijiancejieguo() {
		return sezeqiweijiancejieguo;
	}
	public void setSezeqiweijiancejieguo(String sezeqiweijiancejieguo) {
		this.sezeqiweijiancejieguo = sezeqiweijiancejieguo;
	}
	public String getSezeqiweidanxiangpingjia() {
		return sezeqiweidanxiangpingjia;
	}
	public void setSezeqiweidanxiangpingjia(String sezeqiweidanxiangpingjia) {
		this.sezeqiweidanxiangpingjia = sezeqiweidanxiangpingjia;
	}
	public String getMianjinxishui_yicun() {
		return mianjinxishui_yicun;
	}
	public void setMianjinxishui_yicun(String mianjinxishui_yicun) {
		this.mianjinxishui_yicun = mianjinxishui_yicun;
	}
	public String getMianjinxishui_qingdubuyicun() {
		return mianjinxishui_qingdubuyicun;
	}
	public void setMianjinxishui_qingdubuyicun(String mianjinxishui_qingdubuyicun) {
		this.mianjinxishui_qingdubuyicun = mianjinxishui_qingdubuyicun;
	}
	public String getMianjinxishui_zhongdubuyicun() {
		return mianjinxishui_zhongdubuyicun;
	}
	public void setMianjinxishui_zhongdubuyicun(String mianjinxishui_zhongdubuyicun) {
		this.mianjinxishui_zhongdubuyicun = mianjinxishui_zhongdubuyicun;
	}
	public String getMianjinxishui_jianyanjieguo() {
		return mianjinxishui_jianyanjieguo;
	}
	public void setMianjinxishui_jianyanjieguo(String mianjinxishui_jianyanjieguo) {
		this.mianjinxishui_jianyanjieguo = mianjinxishui_jianyanjieguo;
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
