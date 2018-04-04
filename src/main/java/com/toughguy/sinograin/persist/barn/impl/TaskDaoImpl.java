package com.toughguy.sinograin.persist.barn.impl;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.toughguy.sinograin.model.barn.CornExaminingReport;
import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.model.barn.Task;

import com.toughguy.sinograin.persist.barn.prototype.ITaskDao;
import com.toughguy.sinograin.persist.impl.GenericDaoImpl;
@Repository
public class TaskDaoImpl extends GenericDaoImpl<Task, Integer> implements ITaskDao{

	@Autowired
	SqlSessionTemplate sessionTemplate;
	
	@Override
	public List<Sample> findsampleIdBylibraryId(@Param("id") int id) {
		return sessionTemplate.selectList("com.toughguy.sinograin.model.barn.Task.findsampleIdBylibraryId",id);
	}
	
	@Override
	public List<Task> findtaskIdBysampleId(@Param("id") int id) {
		return sessionTemplate.selectList("com.toughguy.sinograin.model.barn.Task.findtaskIdBysampleId",id);
	}

}
