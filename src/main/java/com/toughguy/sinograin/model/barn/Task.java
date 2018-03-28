package com.toughguy.sinograin.model.barn;

import com.toughguy.sinograin.model.AbstractModel;
import com.toughguy.sinograin.util.JsonUtil;
/*
 * 任务实体类
 * 
 */
public class Task extends AbstractModel{

	private static final long serialVersionUID = -60705643575053363L;
   
	private String taskName; //任务名称

	
	public String getTaskName() {
		return taskName;
	}


	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}


	@Override
	public String toString(){
		return JsonUtil.objectToJson(this);
	}
	
	
	
}
