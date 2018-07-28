package com.toughguy.sinograin.model.barn;


import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.toughguy.sinograin.model.AbstractModel;

/**
 * 归还单实体类
 * @author BOBO
 *
 */
public class ReturnSingle  extends AbstractModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 791004038890822801L;
	
	private String returnPerson;          //归还人
	private String sampleIds;             //样品id集
	private int returnState;             //归还状态 -1未归还    1已归还
	private Date returnTime;              //归还时间
	private int returnSampleNumber;      //归还样品数量
	
	private List<Sample> samples;               //样品集
	
	public String getReturnPerson() {
		return returnPerson;
	}

	public void setReturnPerson(String returnPerson) {
		this.returnPerson = returnPerson;
	}

	public String getSampleIds() {
		return sampleIds;
	}

	public void setSampleIds(String sampleIds) {
		this.sampleIds = sampleIds;
	}

	public int getReturnState() {
		return returnState;
	}

	public void setReturnState(int returnState) {
		this.returnState = returnState;
	}
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	public Date getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}

	public int getReturnSampleNumber() {
		return returnSampleNumber;
	}

	public void setReturnSampleNumber(int returnSampleNumber) {
		this.returnSampleNumber = returnSampleNumber;
	}

	public List<Sample> getSamples() {
		return samples;
	}

	public void setSamples(List<Sample> samples) {
		this.samples = samples;
	}

	
}
