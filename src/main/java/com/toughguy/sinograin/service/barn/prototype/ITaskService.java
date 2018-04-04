package com.toughguy.sinograin.service.barn.prototype;


import java.util.List;

import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.model.barn.Task;
import com.toughguy.sinograin.service.prototype.IGenericService;

public interface ITaskService  extends IGenericService<Task, Integer>{
	public List<Sample> findsampleIdBylibraryId(int id);
	public List<Task> findtaskIdBysampleId(int id);

}
