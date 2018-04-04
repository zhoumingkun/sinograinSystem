package com.toughguy.sinograin.service.barn.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.model.barn.Task;
import com.toughguy.sinograin.persist.barn.prototype.ISampleDao;
import com.toughguy.sinograin.persist.barn.prototype.ITaskDao;
import com.toughguy.sinograin.service.barn.prototype.ITaskService;
import com.toughguy.sinograin.service.impl.GenericServiceImpl;

@Service
public class TaskServiceImpl extends GenericServiceImpl<Task, Integer> implements ITaskService{
	@Autowired
	ITaskDao itaskDao;

	@Override
	
	public List<Sample> findsampleIdBylibraryId(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return ((ITaskDao)dao).findsampleIdBylibraryId(params);	
	}

	@Override
	public List<Task> findtaskIdBysampleId(int id) {
		// TODO Auto-generated method stub
		return ((ITaskDao)dao).findtaskIdBysampleId(id);	
	}

}
