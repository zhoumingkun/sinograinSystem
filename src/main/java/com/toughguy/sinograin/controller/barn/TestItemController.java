package com.toughguy.sinograin.controller.barn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.model.barn.TestItem;
import com.toughguy.sinograin.pagination.PagerModel;
import com.toughguy.sinograin.service.barn.prototype.IHandoverService;
import com.toughguy.sinograin.service.barn.prototype.ISampleService;
import com.toughguy.sinograin.service.barn.prototype.ITestItemService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/testItem")
public class TestItemController {
	
	@Autowired
	private ITestItemService testItemService;
	@Autowired
	private IHandoverService handoverService;
	@Autowired
	private ISampleService sampleService;
	
	@ResponseBody
	@RequestMapping("/getAll")
	//@RequiresPermissions("testItem:all")
	public List<TestItem> getAll(){
		return testItemService.findAll();
	}
	
	@ResponseBody
	@RequestMapping("/get")
//	@RequiresPermissions("testItem:getById")
	public TestItem get(int id){
		return testItemService.find(id);
	}
	
	@ResponseBody
	@RequestMapping(value = "/edit")
	//@RequiresPermissions("testItem:edit")
	public String edit(TestItem testItem) {
		try {
			testItemService.update(testItem);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	@ResponseBody
	@RequestMapping(value = "/save")
//	@RequiresPermissions("testItem:save")
	public String save(String params) {
		List<TestItem> list;
		try {
			JSONArray json = JSONArray.fromObject(params);
			list = json.toList(json, TestItem.class);
			for(TestItem t:list) {
				//根据样品id查出所有检测项目实体
				if(t.getSampleId() == 0) {
					Sample sample = sampleService.findBySampleNum(t.getSampleNum());
					t.setSampleId(sample.getId());
				}
				List<TestItem> testItems = testItemService.findResult(t.getSampleId());
				String testItemStr1 = null;
				for(TestItem testItem:testItems) {
					
					testItemStr1 += testItem.getTestItem() + ",";
				}
				if(testItemStr1 != null || "".equals(testItemStr1)) {
					String testItemStr2 = testItemStr1.substring(0, testItemStr1.length()-1);
					String checkeds = handoverService.findCheckedBySampleId(t.getSampleId()).getCheckeds();
					if(checkeds.equals(testItemStr2)) {
						Sample s = sampleService.find(t.getSampleId());
						s.setDetectionState(2);
						sampleService.update(s);
					}
				}
				testItemService.save(t);
			}
			return "{ \"success\" : true }";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	@ResponseBody
	@RequestMapping(value = "/data")
//	@RequiresPermissions("testItem:list")
	public String data(String params) {
		try {
			ObjectMapper om = new ObjectMapper();
			Map<String, Object> map = new HashMap<String, Object>();
			if (!StringUtils.isEmpty(params)) {
				// 参数处理
				map = om.readValue(params, new TypeReference<Map<String, Object>>() {});
			}
			PagerModel<TestItem> pg = testItemService.findPaginated(map);
			
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
	/**
	 * 确认单列表获取（包括状态）
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/findTestItem")
//	@RequiresPermissions("testItem:list")
	public String findTestItem(String params) {
		try {
			ObjectMapper om = new ObjectMapper();
			Map<String, Object> map = new HashMap<String, Object>();
			if (!StringUtils.isEmpty(params)) {
				// 参数处理
				map = om.readValue(params, new TypeReference<Map<String, Object>>() {});
			}
			PagerModel<TestItem> pg = testItemService.findTestItem(map);
			
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
	
	@ResponseBody
	@RequestMapping(value = "/getSampleBySortAndTestItem")
//	@RequiresPermissions("testItem:getSampleBySortAndTestItem")
	public List<Sample> getSampleBySortAndTestItem(TestItem testItem) {
		List<Sample> sampleAll = testItemService.getAllSampleBySortAndTestItem(testItem);
		List<Sample> samples = testItemService.getSampleBySortAndTestItem(testItem);
		int id1 = 0;
		int id2 = 0;
		if(samples.size()>0) {
			for(Sample s:samples) {
				id2 = s.getId();
				for(int i=0;i<sampleAll.size();i++) {
					id1 = sampleAll.get(i).getId();
					if(id1 == id2) {
						sampleAll.remove(i);
					}
				}
			}
		}
		return sampleAll;
		
	}
	
	/**
	 *  导出样品确认单
	 * @param id
	 * @return String
	 */
	@ResponseBody
	@RequestMapping(value = "/expotHandover")
	public String expotexpotTestItem(HttpServletResponse response,int sampleId) {
		try {
			// 返回结果
			testItemService.expotexpotTestItem(response,sampleId);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/getResult")
	public List<TestItem> findResult(int sampleId) {
		return testItemService.findResult(sampleId);
	}
}
