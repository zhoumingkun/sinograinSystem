package com.toughguy.sinograin.controller.barn;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.toughguy.sinograin.model.barn.CornExaminingReport;
import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.model.barn.Task;
import com.toughguy.sinograin.pagination.PagerModel;
import com.toughguy.sinograin.persist.barn.prototype.ICornExaminingReportDao;
import com.toughguy.sinograin.service.barn.prototype.ITaskService;

@Controller
@RequestMapping("/task")
public class TaskController {
	@Autowired
	private ITaskService taskService;
	
	@Autowired
	private ICornExaminingReportDao cornExaminingReportDao;
	//根据库ID查样品ID
	@ResponseBody
	@RequestMapping("/findsampleIdBylibraryId")
	//@RequiresPermissions("sample:edit")
	public List<Sample> findsampleIdBylibraryId(int id) {
			List<Sample> list = taskService.findsampleIdBylibraryId(id);
			List<CornExaminingReport> array = new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				List<CornExaminingReport> cornExaminingReport = cornExaminingReportDao.findQualityAcceptance(list.get(i).getId());
				
			}
			
			return null;
	}
	
	//根据样品ID查任务ID
		@ResponseBody
		@RequestMapping("/findtaskIdBysampleId")
		//@RequiresPermissions("sample:edit")
		public List<Task> findtaskIdBysampleId(int id) {
				return taskService.findtaskIdBysampleId(id);
		}
	
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
	
	@ResponseBody
	@RequestMapping(value = "/data")
	//@RequiresPermissions("library:list")
	public String data(String params) {
		try {
			ObjectMapper om = new ObjectMapper();
			Map<String, Object> map = new HashMap<String, Object>();
			if (!StringUtils.isEmpty(params)) {
				// 参数处理
				map = om.readValue(params, new TypeReference<Map<String, Object>>() {});
			}
			PagerModel<Task> pg = taskService.findPaginated(map);
			
			// 序列化查询结果为JSON
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("total", pg.getTotal());
			result.put("rows", pg.getData());
			return om.writeValueAsString(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"total\" : 0, \"rows\" : [] }";
		}
	}

}

