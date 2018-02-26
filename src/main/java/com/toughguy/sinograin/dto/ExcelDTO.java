package com.toughguy.sinograin.dto;

import java.util.List;
import java.util.Map;

import com.toughguy.sinograin.util.JsonUtil;

/**
 * 将Excel工具类中
 * 参数进行整合
 * 设置Excel表格的各类型参数
 * */
public class ExcelDTO<T> {
	
	private String fileName;				//文件名
	private String title;					//工作簿名
	private String tableName;				//表名
	private List<String> headersName;		//表格属性列名数组
	private List<Integer>headerWidth;		//表格列宽（0则取默认宽度）
	private List<String> headersId;			//表格属性列名对应的字段---你需要导出的字段名（为了更灵活控制你想要导出的字段）
	private List<T> dtoList;				//需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象
	
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	public List<String> getHeadersName() {
		return headersName;
	}
	public void setHeadersName(List<String> headersName) {
		this.headersName = headersName;
	}
	public List<Integer> getHeaderWidth() {
		return headerWidth;
	}
	public void setHeaderWidth(List<Integer> headerWidth) {
		this.headerWidth = headerWidth;
	}
	public List<String> getHeadersId() {
		return headersId;
	}
	public void setHeadersId(List<String> headersId) {
		this.headersId = headersId;
	}
	public List<T> getDtoList() {
		return dtoList;
	}
	public void setDtoList(List<T> dtoList) {
		this.dtoList = dtoList;
	}
	
	@Override
	public String toString(){
		return JsonUtil.objectToJson(this);
	}

}
