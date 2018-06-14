package com.toughguy.sinograin.model.barn;

import com.toughguy.sinograin.model.AbstractModel;

/**
 * 仓房柜
 * @author BOBO
 *
 */
public class WarehousePosition extends AbstractModel {

	private static final long serialVersionUID = 2166949566971231212L;
	private String position;  //柜号
	private int isStorage;    //是否存储  （1，已存，2未存）
	
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getIsStorage() {
		return isStorage;
	}
	public void setIsStorage(int isStorage) {
		this.isStorage = isStorage;
	}
	
	
}
