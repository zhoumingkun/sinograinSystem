package com.toughguy.sinograin.dto;

import java.util.List;
import java.util.Map;

import com.toughguy.sinograin.util.JsonUtil;

/**
 * 将检验单工具类中
 * 参数进行整合
 * */
public class SummaryCheckDTO {
	
	private String CheckName;				//检验单名称
	private String sort;					//品种
	private int  sum;				//检验单申请总数
	
	
	public String getCheckName() {
		return CheckName;
	}


	public void setCheckName(String checkName) {
		CheckName = checkName;
	}


	public String getSort() {
		return sort;
	}


	public void setSort(String sort) {
		this.sort = sort;
	}


	public int getSum() {
		return sum;
	}


	public void setSum(int sum) {
		this.sum = sum;
	}


	@Override
	public String toString(){
		return JsonUtil.objectToJson(this);
	}

}
