package com.toughguy.sinograin.model.barn;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.toughguy.sinograin.model.AbstractModel;
import com.toughguy.sinograin.util.JsonUtil;

/**
 * 库表
 *
 */
public class Switch extends AbstractModel{ 

	private static final long serialVersionUID = -7116934549541376125L;
	
	private String switchName; 	//库名
	private String switchState; 	//状态    （0未启用 、1 启用）
	public String getSwitchName() {
		return switchName;
	}
	public void setSwitchName(String switchName) {
		this.switchName = switchName;
	}
	public String getSwitchState() {
		return switchState;
	}
	public void setSwitchState(String switchState) {
		this.switchState = switchState;
	}
	@Override
	public String toString() {
		return "Switch [switchName=" + switchName + ", switchState=" + switchState + "]";
	}
	
	
}
