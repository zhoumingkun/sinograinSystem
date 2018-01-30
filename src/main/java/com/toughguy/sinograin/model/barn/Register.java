package com.toughguy.sinograin.model.barn;

import com.toughguy.sinograin.model.AbstractModel;

/**
 * 扦样登记表
 *
 */
public class Register extends AbstractModel {

	private static final long serialVersionUID = -2244920019537054274L;
	
	private String formName; //表格名称
	private int state; //状态
	
	public String getFormName() {
		return formName;
	}
	public void setFormName(String formName) {
		this.formName = formName;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
}
