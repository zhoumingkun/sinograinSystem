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
	private	int type;  // -1 资源 ；1操作
	private String disabled;  //是否禁用 ture/false
	private String checked;  //是否选中 ture/false
	private String index;  //唯一标识
	
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


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}


	public String getDisabled() {
		return disabled;
	}


	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}


	public String getChecked() {
		return checked;
	}


	public void setChecked(String checked) {
		this.checked = checked;
	}


	public String getIndex() {
		return index;
	}


	public void setIndex(String index) {
		this.index = index;
	}


	@Override
	public String toString() {
		return JsonUtil.objectToJson(this);
	}
	
}
