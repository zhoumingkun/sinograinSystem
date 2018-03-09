package com.toughguy.sinograin.controller.barn;

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
import com.toughguy.sinograin.model.barn.Library;
import com.toughguy.sinograin.pagination.PagerModel;
import com.toughguy.sinograin.service.barn.prototype.ILibraryService;

@Controller
@RequestMapping("/library")
public class LibraryController {
	
	@Autowired
	private ILibraryService libraryService;
	
	@ResponseBody
	@RequestMapping("/getAll")
	//@RequiresPermissions("library:all")
	public List<Library> getAll(){
		return libraryService.findAll();
	}
	@ResponseBody
	@RequestMapping("/get")
	//@RequiresPermissions("library:all")
	public Library get(int id){
		return libraryService.find(id);
	}
	@ResponseBody
	@RequestMapping(value = "/edit")
	//@RequiresPermissions("library:edit")
	public String edit(Library library) {
		try {
			libraryService.update(library);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	@ResponseBody
	@RequestMapping(value = "/save")
	//@RequiresPermissions("library:add")
	public String saveSample(Library library) {
		try {
			libraryService.save(library);
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
			PagerModel<Library> pg = libraryService.findPaginated(map);
			
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
