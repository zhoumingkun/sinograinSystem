package com.toughguy.sinograin.model.barn;

import com.toughguy.sinograin.model.AbstractModel;
import com.toughguy.sinograin.util.JsonUtil;


/**
 * 安全报告
 *
 */
public class SafetyReport extends AbstractModel{

	private static final long serialVersionUID = -9121652120717759870L;
	
	private String problem;   //问题
	private String images;     //图片
	private int sampleId;     //样品id
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public int getSampleId() {
		return sampleId;
	}
	public void setSampleId(int sampleId) {
		this.sampleId = sampleId;
	}
	@Override
	public String toString(){
		return JsonUtil.objectToJson(this);
	}

}
