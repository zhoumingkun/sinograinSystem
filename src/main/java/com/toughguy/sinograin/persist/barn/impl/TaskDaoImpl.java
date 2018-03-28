package com.toughguy.sinograin.persist.barn.impl;


import org.springframework.stereotype.Repository;

import com.toughguy.sinograin.model.barn.Task;

import com.toughguy.sinograin.persist.barn.prototype.ITaskDao;
import com.toughguy.sinograin.persist.impl.GenericDaoImpl;
@Repository
public class TaskDaoImpl extends GenericDaoImpl<Task, Integer> implements ITaskDao{

}
