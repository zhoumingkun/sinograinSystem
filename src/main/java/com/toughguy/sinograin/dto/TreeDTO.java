package com.toughguy.sinograin.dto;

import java.util.List;

import com.toughguy.sinograin.model.barn.Register;
import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.util.JsonUtil;

/**
 * 转换成前端能使用的树结构
 * 
 * */
public class TreeDTO {
	
	private String name;
	private int id;
	private List<TreeDTO> children;
		
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}




	public List<TreeDTO> getChildren() {
		return children;
	}


	public void setChildren(List<TreeDTO> children) {
		this.children = children;
	}


	@Override
	public String toString() {
		return JsonUtil.objectToJson(this);
	}
	
}
