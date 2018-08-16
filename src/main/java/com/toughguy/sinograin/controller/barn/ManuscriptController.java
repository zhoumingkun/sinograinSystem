package com.toughguy.sinograin.controller.barn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.toughguy.sinograin.model.barn.Manuscript;
import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.pagination.PagerModel;
import com.toughguy.sinograin.service.barn.prototype.IManuscriptService;
import com.toughguy.sinograin.service.barn.prototype.ISampleService;
import com.toughguy.sinograin.util.JsonUtil;

@Controller
@RequestMapping("/manuscript")
public class ManuscriptController {

	@Autowired
	private IManuscriptService manuscriptService;
	@Autowired
	private ISampleService sampleService;
	
	@ResponseBody
	@RequestMapping("/getAll")
	//@RequiresPermissions("manuscript:all")
	public List<Manuscript> getAll(){
		return manuscriptService.findAll();
	}
	
	@ResponseBody
	@RequestMapping(value = "/edit")
	@RequiresPermissions("manuscript:edit")
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
	//@RequiresPermissions("manuscript:save")
	public String saveManuscript(Manuscript manuscript) {
		try {
			manuscriptService.save(manuscript);
			int id = manuscript.getId();
			return "{ \"success\" : true,\"id\":"+ id +" }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	@ResponseBody
	@RequestMapping(value = "/saveMan")
	@RequiresPermissions("manuscript:saveMan")
	public String saveMan(String params){
		try{
			Manuscript manuscript = JsonUtil.jsonToPojo(params, Manuscript.class);
			manuscriptService.save(manuscript);
			int id = manuscript.getId();
			return "{ \"success\" : true ,\"id\":"+ id +" }";
		}catch(Exception e){
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrEditMobile")
	//@RequiresPermissions("manuscript:saveOrEditMobile")
	public String saveManMobile(String params,int type) {
		try {
			ObjectMapper om = new ObjectMapper();
			Map<String, Object> map = new HashMap<String, Object>();
			if (!StringUtils.isEmpty(params)) {
				// 参数处理
				map = om.readValue(params, new TypeReference<Map<String, Object>>() {});
				String qualityGrade = (String) map.get("qualityGrade");
				String putWay = (String) map.get("putWay");
				if("一等".equals(qualityGrade)){
					map.put("qualityGrade", 1);
				}else if("二等".equals(qualityGrade)){
					map.put("qualityGrade", 2);
				}else{
					map.put("qualityGrade", 3);
				}
				if("机械入仓".equals(putWay)){
					map.put("putWay", 1);
				}else if("人工入仓".equals(putWay)){
					map.put("putWay", 2);
				}
			}
			String param = JsonUtil.objectToJson(map);
			Manuscript manuscript = JsonUtil.jsonToPojo(param, Manuscript.class);
			manuscript.setStorge(1);
			if(type == 1){
				manuscriptService.save(manuscript);
			}else {
				manuscriptService.update(manuscript);
			}
			
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	/**
	 * 导出工作底稿(长方体)
	 * */
	@ResponseBody
	@RequestMapping(value = "/exportExcelCFT")
	@RequiresPermissions("manuscript:export")
	public String exportExcelCFT(HttpServletResponse response,int id) {
		try {
			Manuscript manuscript = manuscriptService.find(id);
			Sample sample = sampleService.find(manuscript.getSampleId());
			manuscriptService.exportExcelCFT(response,sample,manuscript);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/exportExcelYZT")
	@RequiresPermissions("manuscript:export")
	public String exportExcelYZT(HttpServletResponse response,int id) {
		try {
			Manuscript manuscript = manuscriptService.find(id);
			Sample sample = sampleService.find(manuscript.getSampleId());
			manuscriptService.exportExcelYZT(response,sample,manuscript);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/exportExcelCFJZT")
	@RequiresPermissions("manuscript:export")
	public String exportExcelCFJZT(HttpServletResponse response,int id) {
		try {
			Manuscript manuscript = manuscriptService.find(id);
			Sample sample = sampleService.find(manuscript.getSampleId());
			manuscriptService.exportExcelCFJZT(response,sample,manuscript);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/exportExcelQT")
	@RequiresPermissions("manuscript:export")
	public String exportExcelQT(HttpServletResponse response,int id) {
		try {
			Manuscript manuscript = manuscriptService.find(id);
			Sample sample = sampleService.find(manuscript.getSampleId());
			manuscriptService.exportExcelQT(response,sample,manuscript);
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
