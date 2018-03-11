package com.toughguy.sinograin.model.barn;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.toughguy.sinograin.model.AbstractModel;
import com.toughguy.sinograin.util.JsonUtil;

/**
 * 库表
 *
 */
public class Library extends AbstractModel{ 

	private static final long serialVersionUID = -7116934549541376125L;
	
	private String libraryName; 	//库名
	private int libraryState; 		//状态    （-1未启用 、1 启用）
	private int pLibraryId;			//上级库点id
	
	
	private String noSampleIds;  	//未扦样的表id集合（页面）
	private String pLibraryName;	//父库点名（页面）
	private Date regCreateTime; 	//扦样登记表创建时间最新（页面）
	private int count; 			//未扦样表数量
	
	public String getLibraryName() {
		return libraryName;
	}
	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}
	public int getLibraryState() {
		return libraryState;
	}
	public void setLibraryState(int libraryState) {
		this.libraryState = libraryState;
	}
	
	public String getNoSampleIds() {
		return noSampleIds;
	}
	public void setNoSampleIds(String noSampleIds) {
		this.noSampleIds = noSampleIds;
	}
	public int getCount() {
		if(StringUtils.isEmpty(noSampleIds)){
			return 0;
		}else {
			return noSampleIds.split(",").length;
		}
	}
	public void setCount(int count) {
		if(StringUtils.isEmpty(noSampleIds)){
			this.count = 0 ;
		}
		this.count = noSampleIds.split(",").length;
	}
	
	public int getpLibraryId() {
		return pLibraryId;
	}
	public void setpLibraryId(int pLibraryId) {
		this.pLibraryId = pLibraryId;
	}
	public String getpLibraryName() {
		return pLibraryName;
	}
	public void setpLibraryName(String pLibraryName) {
		this.pLibraryName = pLibraryName;
	}
	
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
