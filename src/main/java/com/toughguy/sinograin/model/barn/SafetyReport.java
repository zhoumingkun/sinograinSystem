package com.toughguy.sinograin.model.barn;

import com.toughguy.sinograin.model.AbstractModel;


/**
 * 安全报告
 *
 */
public class SafetyReport extends AbstractModel{

	private static final long serialVersionUID = -9121652120717759870L;
	
	private String problem;   //问题
	private String image;     //图片
	private int sampleId;     //样品表
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getSampleId() {
		return sampleId;
	}
	public void setSampleId(int sampleId) {
		this.sampleId = sampleId;
	}
	
	

}
