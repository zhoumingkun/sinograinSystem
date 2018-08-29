package com.toughguy.sinograin.model.barn;

import com.toughguy.sinograin.model.AbstractModel;
/**
 * 库房管理类
 * @author BOBO
 *
 */
public class Warehouse extends AbstractModel {

	private static final long serialVersionUID = 8281532611008796714L;
	
	private String depot; //样品室
	
	private String counter;  //样品柜
	private int counterId;    //样品柜id
	private int warehouseUseNumber;//库房使用数（页面使用）
	private int warehouseTotal;  //库房总数（页面使用）
	
	private String describe;   //描述（品种按性质分）
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
	public int getCounterId() {
		return counterId;
	}
	public void setCounterId(int counterId) {
		this.counterId = counterId;
	}
	public int getWarehouseUseNumber() {
		return warehouseUseNumber;
	}
	public void setWarehouseUseNumber(int warehouseUseNumber) {
		this.warehouseUseNumber = warehouseUseNumber;
	}
	public int getWarehouseTotal() {
		return warehouseTotal;
	}
	public void setWarehouseTotal(int warehouseTotal) {
		this.warehouseTotal = warehouseTotal;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	
}
