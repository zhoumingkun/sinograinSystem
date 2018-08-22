package com.toughguy.sinograin.controller.barn;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.toughguy.sinograin.model.barn.CornExaminingReport;
import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.model.barn.Task;
import com.toughguy.sinograin.model.barn.TestItem;
import com.toughguy.sinograin.model.barn.WheatExaminingReport;
import com.toughguy.sinograin.pagination.PagerModel;
import com.toughguy.sinograin.persist.barn.prototype.ICornExaminingReportDao;
import com.toughguy.sinograin.persist.barn.prototype.IWheatExaminingReportDao;
import com.toughguy.sinograin.service.barn.prototype.ISampleService;
import com.toughguy.sinograin.service.barn.prototype.ITaskService;
import com.toughguy.sinograin.service.barn.prototype.ITestItemService;

@Controller
@RequestMapping("/task")
public class TaskController {
	@Autowired
	private ITaskService taskService;
	@Autowired
	private ICornExaminingReportDao cornExaminingReportDao;
	@Autowired
	private ITestItemService testItemService;
	@Autowired
	private IWheatExaminingReportDao wheatExaminingReportDao;
	
	//玉米库id和货位号查询质检报告
	@ResponseBody
	@RequestMapping("/findCornSampleIdBylibraryId")
	//@RequiresPermissions("task:findCornSampleIdBylibraryId")
	public List<CornExaminingReport> findCornSampleIdBylibraryId(String params) {
		List<CornExaminingReport> cs = new ArrayList<CornExaminingReport>();
		try {
			ObjectMapper om = new ObjectMapper();
			Map<String, Object> map = new HashMap<String, Object>();
			if (!StringUtils.isEmpty(params)) {
				// 参数处理
				map = om.readValue(params, new TypeReference<Map<String, Object>>() {});
			}
			List<Sample> ss = taskService.findsampleIdBylibraryId(map);	
			for(Sample s : ss) {
//				List<CornExaminingReport> cs = cornExaminingReportDao.findQualityAcceptance(s.getId());
				CornExaminingReport c = cornExaminingReportDao.findBasicSituation(s.getId());
				List<TestItem> testItems = testItemService.findResult(s.getId());
				String jianceren = "";
				Date jianceshijian = null;
				for(TestItem t:testItems) {
					if(1 == t.getTestItem()) {
						c.setRongzhong(t.getResult());
						jianceren = t.getPrincipal() + ",";
						if(Double.parseDouble(t.getResult()) >= 650) {
							c.setJieguopanding1("达标");
						} else {
							c.setJieguopanding1("不达标");
						}
					}else if(2 == t.getTestItem()){
						c.setShuifen(t.getResult());
						jianceren = t.getPrincipal() + ",";
						if(Double.parseDouble(t.getResult()) <= 14.0) {
							c.setJieguopanding1("达标");
						} else {
							c.setJieguopanding1("不达标");
						}
					}else if(3 == t.getTestItem()){
						c.setZazhi(t.getResult());
						jianceren = t.getPrincipal() + ",";
						if(Double.parseDouble(t.getResult()) <= 1.0) {
							c.setJieguopanding1("达标");
						} else {
							c.setJieguopanding1("不达标");
						}
					}else if(5 == t.getTestItem()){
						c.setBuwanshanlizongliang(t.getResult());
						jianceren = t.getPrincipal() + ",";
						if(Double.parseDouble(t.getResult()) <= 8.0) {
							c.setJieguopanding1("达标");
						} else {
							c.setJieguopanding1("不达标");
						}
					}else if(6 == t.getTestItem()){
						c.setBuwanshanlishengmeikeli(t.getResult());
						jianceren = t.getPrincipal() + ",";
						if(Double.parseDouble(t.getResult()) <= 2.0) {
							c.setJieguopanding1("达标");
						} else {
							c.setJieguopanding1("不达标");
						}
					}else if(7 == t.getTestItem()){
						c.setSezeqiwei1(t.getResult());
						jianceren = t.getPrincipal() + ",";
						if(t.getResult().equals("正常")) {
							c.setJieguopanding1("达标");
						} else {
							c.setJieguopanding1("不达标");
						}
					}else if(10 == t.getTestItem()){
						c.setZhifangsuanzhi(t.getResult());
						jianceren = t.getPrincipal() + ",";
						if(Double.parseDouble(t.getResult()) <= 65) {
							c.setJieguopanding2("宜存");
						} else if(Double.parseDouble(t.getResult()) <= 78){
							c.setJieguopanding2("轻度不宜存");
						} else if(Double.parseDouble(t.getResult()) > 78){
							c.setJieguopanding2("重度不宜存");
						}
					}else if(11 == t.getTestItem()){
						c.setPinchangpingfen(t.getResult());
						jianceren = t.getPrincipal() + ",";
						if(Double.parseDouble(t.getResult()) >= 70) {
							c.setJieguopanding2("宜存");
						} else if(Double.parseDouble(t.getResult()) >= 60){
							c.setJieguopanding2("轻度不宜存");
						} else if(Double.parseDouble(t.getResult()) < 60){
							c.setJieguopanding2("重度不宜存");
						}
					}else if(12 == t.getTestItem()){
						c.setSezeqiwei2(t.getResult());
						jianceren = t.getPrincipal() + ",";
						if(c.getJieguopanding2() != null) {
							if(t.getResult().equals("正常") && c.getJieguopanding2().equals("宜存")) {
								c.setJieguopanding2("宜存");
							} else if(t.getResult().equals("正常") && c.getJieguopanding2().equals("轻度不宜存")){
								c.setJieguopanding2("轻度不宜存");
							} else if(t.getResult().equals("基本正常")){
								c.setJieguopanding2("重度不宜存");
							}
						}
					}
					jianceshijian = t.getUpdateTime();
				}
				if(!jianceren.equals("")) {
					c.setJianceren(jianceren.substring(0, jianceren.length()-1));
				}
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				if(jianceshijian != null) {
					c.setJianceshijian(sdf.format(jianceshijian));
				}
				cs.add(c);
			}
			return cs;
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
			List<WheatExaminingReport> ws = new ArrayList<WheatExaminingReport>();
			try {
				ObjectMapper om = new ObjectMapper();
				Map<String, Object> map = new HashMap<String, Object>();
				if (!StringUtils.isEmpty(params)) {
					// 参数处理
					map = om.readValue(params, new TypeReference<Map<String, Object>>() {});
				}
				List<Sample> ss = taskService.findsampleIdBylibraryId(map);	
				for(Sample s : ss) {
					WheatExaminingReport w = wheatExaminingReportDao.findBasicSituation(s.getId());
					List<TestItem> testItems = testItemService.findResult(s.getId());
					String jianceren = "";
					Date jianceshijian = null;
					for(TestItem t:testItems) {
						if(1 == t.getTestItem()) {
							w.setRongzhong(t.getResult());
							jianceren = t.getPrincipal() + ",";
							if(Double.parseDouble(t.getResult()) >= 750) {
								w.setJieguopanding1("达标");
							} else {
								w.setJieguopanding1("不达标");
							}
						}else if(2 == t.getTestItem()){
							w.setShuifen(t.getResult());
							jianceren = t.getPrincipal() + ",";
							if(Double.parseDouble(t.getResult()) <= 12.5) {
								w.setJieguopanding1("达标");
							} else {
								w.setJieguopanding1("不达标");
							}
						}else if(3 == t.getTestItem()){
							w.setZazhizongliang(t.getResult());
							jianceren = t.getPrincipal() + ",";
							if(Double.parseDouble(t.getResult()) <= 1.0) {
								w.setJieguopanding1("达标");
							} else {
								w.setJieguopanding1("不达标");
							}
						}else if(4 == t.getTestItem()){
							w.setZazhikuangwuzhi(t.getResult());
							jianceren = t.getPrincipal() + ",";
							if(Double.parseDouble(t.getResult()) <= 0.5) {
								w.setJieguopanding1("达标");
							} else {
								w.setJieguopanding1("不达标");
							}
						}else if(5 == t.getTestItem()){
							w.setBuwanshanli(t.getResult());
							jianceren = t.getPrincipal() + ",";
							if(Double.parseDouble(t.getResult()) <= 8.0) {
								w.setJieguopanding1("达标");
							} else {
								w.setJieguopanding1("不达标");
							}
						}else if(7 == t.getTestItem()){
							w.setSezeqiwei1(t.getResult());
							jianceren = t.getPrincipal() + ",";
							if(t.getResult().equals("正常")) {
								w.setJieguopanding1("达标");
							} else {
								w.setJieguopanding1("不达标");
							}
						}else if(8 == t.getTestItem()){
							w.setYingduzhishu(t.getResult());
							jianceren = t.getPrincipal() + ",";
							if(Double.parseDouble(t.getResult()) >= 60) {
								w.setJieguopanding1("达标");
							} else if(Double.parseDouble(t.getResult()) > 45 && Double.parseDouble(t.getResult()) < 60) {
								w.setJieguopanding1("达标");
							} else {
								w.setJieguopanding1("不达标");
							}
						}else if(9 == t.getTestItem()){
							w.setMianjinxishuiliang(t.getResult());
							jianceren = t.getPrincipal() + ",";
							if(Double.parseDouble(t.getResult()) >= 180) {
								w.setJieguopanding2("宜存");
							} else if(Double.parseDouble(t.getResult()) < 180){
								w.setJieguopanding2("轻度不宜存");
							}
						}else if(11 == t.getTestItem()){
							w.setPinchangpingfen(t.getResult());
							jianceren = t.getPrincipal() + ",";
							if(Double.parseDouble(t.getResult()) >= 70) {
								w.setJieguopanding2("宜存");
							} else if(Double.parseDouble(t.getResult()) >= 60 && Double.parseDouble(t.getResult()) < 70){
								w.setJieguopanding2("轻度不宜存");
							} else if(Double.parseDouble(t.getResult()) < 60){
								w.setJieguopanding2("重度不宜存");
							}
						}else if(12 == t.getTestItem()){
							w.setSezeqiwei2(t.getResult());
							jianceren = t.getPrincipal() + ",";
							if(w.getJieguopanding2() != null) {
								if(t.getResult().equals("正常") && w.getJieguopanding2().equals("宜存")) {
									w.setJieguopanding2("宜存");
								} else if(t.getResult().equals("正常") && w.getJieguopanding2().equals("轻度不宜存")){
									w.setJieguopanding2("轻度不宜存");
								} else if(t.getResult().equals("基本正常")){
									w.setJieguopanding2("重度不宜存");
								}
							}
						}
						jianceshijian = t.getUpdateTime();
					}
					if(!jianceren.equals("")) {
						w.setJianceren(jianceren.substring(0, jianceren.length()-1));
					}
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					if(jianceshijian != null && !jianceshijian.equals("")) {
						w.setJianceshijian(sdf.format(jianceshijian));
					}
					ws.add(w);
				}
				return ws;
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
	@RequiresPermissions("task:save")
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

