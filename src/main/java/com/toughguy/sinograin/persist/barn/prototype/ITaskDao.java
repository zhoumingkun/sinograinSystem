package com.toughguy.sinograin.persist.barn.prototype;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.toughguy.sinograin.model.barn.CornExaminingReport;
import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.model.barn.Task;
import com.toughguy.sinograin.persist.prototype.IGenericDao;

public interface ITaskDao extends IGenericDao<Task, Integer>{
	public List<Sample> findsampleIdBylibraryId(Map<String, Object> params);
	public List<Task> findtaskIdBysampleId(@Param("id") int id);
	
}
