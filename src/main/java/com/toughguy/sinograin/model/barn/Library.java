package com.toughguy.sinograin.model.barn;

import com.toughguy.sinograin.model.AbstractModel;
import com.toughguy.sinograin.util.JsonUtil;

/**
 * 库表
 *
 */
public class Library extends AbstractModel{

	private static final long serialVersionUID = -7116934549541376125L;
	
	private String libraryName; //库名
	private int libraryState; //状态    （-1未启用 、1 启用）
	
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
	@Override
	public String toString(){
		return JsonUtil.objectToJson(this);
	}
}
