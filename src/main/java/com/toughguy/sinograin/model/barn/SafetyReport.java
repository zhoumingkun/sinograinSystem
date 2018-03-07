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
	private int isDeal;			//是否处理（-1 未解决， 1 已解决）
	
	private String libraryName;	//被查库名（页面展示）
	private String position; //货位号（页面展示）
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
	
	public int getIsDeal() {
		return isDeal;
	}
	public void setIsDeal(int isDeal) {
		this.isDeal = isDeal;
	}
	
	
	public String getLibraryName() {
		return libraryName;
	}
	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	@Override
	public String toString(){
		return JsonUtil.objectToJson(this);
	}

}
