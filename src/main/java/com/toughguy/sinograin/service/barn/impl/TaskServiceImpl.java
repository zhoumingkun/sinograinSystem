package com.toughguy.sinograin.service.barn.impl;

import org.springframework.stereotype.Service;


import com.toughguy.sinograin.model.barn.Task;

import com.toughguy.sinograin.service.barn.prototype.ITaskService;
import com.toughguy.sinograin.service.impl.GenericServiceImpl;

@Service
public class TaskServiceImpl extends GenericServiceImpl<Task, Integer> implements ITaskService{

}
