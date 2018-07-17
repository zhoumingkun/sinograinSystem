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
	private String reason;		//不同意原因
	private int type;           //类型 （-1正常钎样   1非钎样入库）
	
	private String libraryName;	//库名(页面)
	private Date regCreateTime; 	//扦样登记表创建时间最新（页面）
	private Date dateStart;          //搜索开始时间（前台）
	private Date dateEnd;            //搜索结束时间（前台）
	
	
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
	
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
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
	
	
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Date getDateStart() {
		return dateStart;
	}
	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}
	public Date getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}
	@Override
	public String toString(){
		return JsonUtil.objectToJson(this);
	}
}
