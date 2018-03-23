package com.toughguy.sinograin.model.barn;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.toughguy.sinograin.model.AbstractModel;
import com.toughguy.sinograin.util.JsonUtil;

/**
 * 扦样登记表
 *
 */
public class Register extends AbstractModel {

	private static final long serialVersionUID = -2244920019537054274L;
	
	private String formName; 	//表格名称
	private int regState; 		//状态  （-1 待审核、1 未同意、2 已同意 、3 草稿）
	private int libraryId;		//库id
	
	private String libraryName;	//库名(页面)
	private Date regCreateTime; 	//扦样登记表创建时间最新（页面）
	
	
	public String getLibraryName() {
		return libraryName;
	}
	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}
	public String getFormName() {
		return formName;
	}
	public void setFormName(String formName) {
		this.formName = formName;
	}
	
	public int getRegState() {
		return regState;
	}
	public void setRegState(int regState) {
		this.regState = regState;
	}
	public int getLibraryId() {
		return libraryId;
	}
	public void setLibraryId(int libraryId) {
		this.libraryId = libraryId;
	}
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	public Date getRegCreateTime() {
		return regCreateTime;
	}
	public void setRegCreateTime(Date regCreateTime) {
		this.regCreateTime = regCreateTime;
	}
	@Override
	public String toString(){
		return JsonUtil.objectToJson(this);
	}
}
