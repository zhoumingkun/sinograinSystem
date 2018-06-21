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
	
}
