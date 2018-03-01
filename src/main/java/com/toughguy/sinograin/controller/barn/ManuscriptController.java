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
import com.toughguy.sinograin.model.barn.Manuscript;
import com.toughguy.sinograin.model.barn.Register;
import com.toughguy.sinograin.pagination.PagerModel;
import com.toughguy.sinograin.service.barn.prototype.IManuscriptService;
import com.toughguy.sinograin.util.JsonUtil;

@Controller
@RequestMapping("/manuscript")
public class ManuscriptController {

	@Autowired
	private IManuscriptService manuscriptService;
	
	@ResponseBody
	@RequestMapping("/getAll")
	//@RequiresPermissions("manuscript:all")
	public List<Manuscript> getAll(){
		return manuscriptService.findAll();
	}
	@ResponseBody
	@RequestMapping(value = "/edit")
	//@RequiresPermissions("manuscript:edit")
	public String edit(Manuscript manuscript) {
		try {
			manuscriptService.update(manuscript);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	@ResponseBody
	@RequestMapping(value = "/save")
	//@RequiresPermissions("manuscript:add")
	public String saveManuscript(Manuscript manuscript) {
		try {
			manuscriptService.save(manuscript);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveMan")
	//@RequiresPermissions("manuscript:add")
	public String saveMan(String params) {
		Manuscript manuscript = JsonUtil.jsonToPojo(params, Manuscript.class);
		try {
			manuscriptService.save(manuscript);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	@ResponseBody
	@RequestMapping(value = "/data")
	//@RequiresPermissions("manuscript:list")
	public String data(String params) {
		try {
			ObjectMapper om = new ObjectMapper();
			Map<String, Object> map = new HashMap<String, Object>();
			if (!StringUtils.isEmpty(params)) {
				// 参数处理
				map = om.readValue(params, new TypeReference<Map<String, Object>>() {});
			}
			PagerModel<Manuscript> pg = manuscriptService.findPaginated(map);
			
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
