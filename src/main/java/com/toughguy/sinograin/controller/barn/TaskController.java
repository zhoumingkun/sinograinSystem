package com.toughguy.sinograin.controller.barn;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.toughguy.sinograin.model.barn.Task;
import com.toughguy.sinograin.service.barn.prototype.ITaskService;

@Controller
@RequestMapping("/Task")
public class TaskController {
	@Autowired
	private ITaskService taskService;
	

	@ResponseBody
	@RequestMapping("/getAll")
	//@RequiresPermissions("library:all")
	public List<Task> getAll(){
		return taskService.findAll();
	}
	@ResponseBody
	@RequestMapping("/get")
	//@RequiresPermissions("library:all")
	public Task get(int id){
		return taskService.find(id);
	}
	
	@ResponseBody
	@RequestMapping(value = "/remove")
	//@RequiresPermissions("library:edit")
	public String remove(int id) {
		try {
			taskService.delete(id);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/edit")
	//@RequiresPermissions("library:edit")
	public String remove(Task task) {
		try {
			taskService.update(task);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	@ResponseBody
	@RequestMapping(value = "/save")
	//@RequiresPermissions("library:add")
	public String save(Task task) {
		try {
			taskService.save(task);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}

}

