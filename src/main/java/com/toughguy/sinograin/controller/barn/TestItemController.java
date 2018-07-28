package com.toughguy.sinograin.controller.barn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.toughguy.sinograin.model.barn.TestItem;
import com.toughguy.sinograin.pagination.PagerModel;
import com.toughguy.sinograin.service.barn.prototype.ITestItemService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/testItem")
public class TestItemController {
	
	@Autowired
	private ITestItemService testItemService;
	
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
}
