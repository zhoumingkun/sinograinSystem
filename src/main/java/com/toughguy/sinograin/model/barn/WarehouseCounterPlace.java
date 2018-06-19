package com.toughguy.sinograin.model.barn;

import com.toughguy.sinograin.model.AbstractModel;

/**
 * 仓房柜号位置
 * @author BOBO
 *
 */
public class WarehouseCounterPlace extends AbstractModel {

	private static final long serialVersionUID = 2166949566971231212L;
	private int place;  //柜号位置
	private int isStorage; //是否储存 1，未存   2，已存
	private int pId;    //柜id
	
	private String depot; //仓库（页面展示）
	private String counter; //柜号（页面展示）
	
	public int getPlace() {
		return place;
	}
	public void setPlace(int place) {
		this.place = place;
	}
	public int getIsStorage() {
		return isStorage;
	}
	public void setIsStorage(int isStorage) {
		this.isStorage = isStorage;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getDepot() {
		return depot;
	}
	public void setDepot(String depot) {
		this.depot = depot;
	}
	public String getCounter() {
		return counter;
	}
	public void setCounter(String counter) {
		this.counter = counter;
	}
	
}
