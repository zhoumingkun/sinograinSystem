package com.toughguy.sinograin.model.barn;

import com.toughguy.sinograin.model.AbstractModel;

/**
 * 仓房柜
 * @author BOBO
 *
 */
public class WarehouseCounter extends AbstractModel {

	private static final long serialVersionUID = 2166949566971231212L;
	private String counter;  //柜号
	private int pId; //样品室id
	
	public String getCounter() {
		return counter;
	}
	public void setCounter(String counter) {
		this.counter = counter;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	
}
