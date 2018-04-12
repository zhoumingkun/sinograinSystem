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
import com.toughguy.sinograin.model.barn.WheatExaminingReport;
import com.toughguy.sinograin.pagination.PagerModel;
import com.toughguy.sinograin.persist.barn.prototype.ICornExaminingReportDao;
import com.toughguy.sinograin.persist.barn.prototype.IWheatExaminingReportDao;
import com.toughguy.sinograin.service.barn.prototype.ITaskService;

@Controller
@RequestMapping("/task")
public class TaskController {
	@Autowired
	private ITaskService taskService;
	@Autowired
	private ICornExaminingReportDao cornExaminingReportDao;
	@Autowired
	private IWheatExaminingReportDao wheatExaminingReportDao;
	
	//玉米库id和货位号查询质检报告
	@ResponseBody
	@RequestMapping("/findCornSampleIdBylibraryId")
	//@RequiresPermissions("task:findCornSampleIdBylibraryId")
	public List<CornExaminingReport> findCornSampleIdBylibraryId(String params) {
		try {
			ObjectMapper om = new ObjectMapper();
			Map<String, Object> map = new HashMap<String, Object>();
			if (!StringUtils.isEmpty(params)) {
				// 参数处理
				map = om.readValue(params, new TypeReference<Map<String, Object>>() {});
			}
			List<Sample> ss = taskService.findsampleIdBylibraryId(map);	
			for(Sample s : ss) {
				List<CornExaminingReport> cs = cornExaminingReportDao.findQualityAcceptance(s.getId());
				return cs;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
		//小麦库id和货位号查询质检报告
		@ResponseBody
		@RequestMapping("/findWheatSampleIdBylibraryId")
		//@RequiresPermissions("task:findWheatSampleIdBylibraryId")
		public List<WheatExaminingReport> findWheatSampleIdBylibraryId(String params) {
			try {
				ObjectMapper om = new ObjectMapper();
				Map<String, Object> map = new HashMap<String, Object>();
				if (!StringUtils.isEmpty(params)) {
					// 参数处理
					map = om.readValue(params, new TypeReference<Map<String, Object>>() {});
				}
				List<Sample> ss = taskService.findsampleIdBylibraryId(map);	
				for(Sample s : ss) {
					List<WheatExaminingReport> ws = wheatExaminingReportDao.findQualityAcceptance(s.getId());
					return ws;
				}
				return null;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
	
//	//根据样品ID查任务ID
//		@ResponseBody
//		@RequestMapping("/findtaskIdBysampleId")
//		//@RequiresPermissions("sample:edit")
//		public List<Task> findtaskIdBysampleId(int id) {
//				return taskService.findtaskIdBysampleId(id);
//		}
//	
	@ResponseBody
	@RequestMapping("/getAll")
	//@RequiresPermissions("task:all")
	public List<Task> getAll(){
		return taskService.findAll();
	}
	@ResponseBody
	@RequestMapping("/get")
	//@RequiresPermissions("task:getById")
	public Task get(int id){
		return taskService.find(id);
	}
	
	@ResponseBody
	@RequestMapping(value = "/remove")
	//@RequiresPermissions("task:remove")
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
	//@RequiresPermissions("task:edit")
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
	//@RequiresPermissions("task:save")
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
	//@RequiresPermissions("task:list")
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

