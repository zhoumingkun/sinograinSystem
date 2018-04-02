package com.toughguy.sinograin.util;

public class ParamUtils {
	public static String title ="汇总表";
	
	public static String heard ="中央储备粮轮换验收申请统计表（2016年度）";
	
	public static String[] heardText= {"基本情况","扦样检查情况","数量验收情况","质量验收情况"};
			
			
	public static String[] column={
			"单位","序号","储存库点名称","检验编号","扦样编号","仓号","品种","数量","生产年份","入库时间",
			 "验收申请时间","任务下达时间","扦样时间","扦样人","备注",
			 "长度","宽度","高度","扣除体积","粮堆实际体积","容重","修正系数","平均密度","测量计算数","保管账数量","差率",
			 "质量情况"
	};
	
	public static String[] content={"等级","质量指标","容重","水分","杂质","总量","其中：矿物质","不完善粒","硬度指数","色泽气味"};
	
	public static String[] text={"结果判定","储存品质情况","储存品质指标","面筋吸水量","湿面筋","品尝评分值","色泽气味","结果判定","备注"};
	
	public static String filePath= "E://样品检验汇总表.xls";
}
