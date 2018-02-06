package com.toughguy.sinograin.model.barn;

import com.toughguy.sinograin.model.AbstractModel;

/**
 * 库表
 *
 */
public class Library extends AbstractModel{

	private static final long serialVersionUID = -7116934549541376125L;
	
	private String libraryName; //库名
	private int state; //状态
	public String getLibraryName() {
		return libraryName;
	}
	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	
}
