package com.toughguy.sinograin.model.barn;

import com.toughguy.sinograin.model.AbstractModel;
import com.toughguy.sinograin.util.JsonUtil;

/**
 * 小样实体类
 * */

public class SmallSample extends AbstractModel {

	private static final long serialVersionUID = 3394574318034670671L;
	
	private String smallSampleNum;		//小样编号
	private int sampleId;				//样品id
	private int checkPoint;				//检测项（1 不完善粒、杂质、生霉粒  2 水分 3 硬度 4 脂肪酸值 5 品尝评分 6 卫生  7 加工品质）
	private int checkId;				//检测id
	private String smallSamplePic;		//小样条形码
	
	
	public String getSmallSampleNum() {
		return smallSampleNum;
	}
	public void setSmallSampleNum(String smallSampleNum) {
		this.smallSampleNum = smallSampleNum;
	}
	public int getSampleId() {
		return sampleId;
	}
	public void setSampleId(int sampleId) {
		this.sampleId = sampleId;
	}
	public int getCheckPoint() {
		return checkPoint;
	}
	public void setCheckPoint(int checkPoint) {
		this.checkPoint = checkPoint;
	}
	public int getCheckId() {
		return checkId;
	}
	public void setCheckId(int checkId) {
		this.checkId = checkId;
	}
	
	
	public String getSmallSamplePic() {
		return smallSamplePic;
	}
	public void setSmallSamplePic(String smallSamplePic) {
		this.smallSamplePic = smallSamplePic;
	}
	@Override
	public String toString(){
		return JsonUtil.objectToJson(this);
	}
}
