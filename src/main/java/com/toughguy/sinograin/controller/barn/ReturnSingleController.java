package com.toughguy.sinograin.controller.barn;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.toughguy.sinograin.model.barn.Handover;
import com.toughguy.sinograin.model.barn.ReturnSingle;
import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.pagination.PagerModel;
import com.toughguy.sinograin.service.barn.prototype.IBarnService;
import com.toughguy.sinograin.service.barn.prototype.IHandoverService;
import com.toughguy.sinograin.service.barn.prototype.IReturnSingleService;
import com.toughguy.sinograin.service.barn.prototype.ISampleService;

@Controller
@RequestMapping("/returnSingle")
public class ReturnSingleController {
	
	@Autowired
	private IReturnSingleService returnSingleService;
	@Autowired
	private ISampleService sampleService;
	
	@ResponseBody
	@RequestMapping("/getAll")
	//@RequiresPermissions("returnSingle:all")
	public List<ReturnSingle> getAll(){
		return returnSingleService.findAll();
	}
	
	@ResponseBody
	@RequestMapping("/get")
//	@RequiresPermissions("returnSingle:getById")
	public ReturnSingle get(int id){
		return returnSingleService.find(id);
	}
	
	@ResponseBody
	@RequestMapping(value = "/edit")
	//@RequiresPermissions("returnSingle:edit")
	public String edit(ReturnSingle returnSingle) {
		try {
			returnSingleService.update(returnSingle);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	@ResponseBody
	@RequestMapping(value = "/save")
//	@RequiresPermissions("returnSingle:save")
	public String save(ReturnSingle returnSingle) {
		try {
			String[] returnSingles = returnSingle.getSampleIds().split(",");
			int returnSampleNumber = returnSingles.length;
			returnSingle.setReturnSampleNumber(returnSampleNumber);
			returnSingleService.save(returnSingle);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	@ResponseBody
	@RequestMapping(value = "/getStorage")
//	@RequiresPermissions("returnSingle:getStorage")
	public ReturnSingle getStorage(int id) {
		ReturnSingle r = returnSingleService.find(id);
		List<Sample> ss = new ArrayList<Sample>();
		String[] sampleIds = r.getSampleIds().split(",");
		int[] samlpeIdsInt = new int[sampleIds.length];
		for(int i=0; i<sampleIds.length; i++) {
			samlpeIdsInt[i] = Integer.parseInt(sampleIds[i]);
		}
		for(int i=0;i<sampleIds.length;i++) {
			Sample s = sampleService.find(samlpeIdsInt[i]);
			s.setStorage(s.getDepot() + "--" + s.getCounter() + "--" + s.getPlace());
			ss.add(s);
		}
		r.setSamples(ss);
		return r;
	}
	
	@ResponseBody
	@RequestMapping(value = "/data")
//	@RequiresPermissions("returnSingle:list")
	public String data(String params) {
		try {
			ObjectMapper om = new ObjectMapper();
			Map<String, Object> map = new HashMap<String, Object>();
			if (!StringUtils.isEmpty(params)) {
				// 参数处理
				map = om.readValue(params, new TypeReference<Map<String, Object>>() {});
			}
			PagerModel<ReturnSingle> pg = returnSingleService.findPaginated(map);
			
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
	@RequestMapping(value = "/guihuan")
	//@RequiresPermissions("returnSingle:guihuan")
	public String guihuan(ReturnSingle returnSingle) {
		try {
			Date d = new Date();
			returnSingle.setReturnTime(new java.sql.Date(d.getTime()));
			returnSingleService.update(returnSingle);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	@ResponseBody
	@RequestMapping(value = "/removeSampleId")
	//@RequiresPermissions("returnSingle:removeSampleId")
	public String removeSampleId(ReturnSingle returnsingle,int sampleId) {
		try {
			ReturnSingle r = returnSingleService.find(returnsingle.getId());
			String[] sampleIds = r.getSampleIds().split(",");
			String newSampleIds = null;
			String sampleIdString = Integer.toString(sampleId);
			for(int i=0;i<sampleIds.length;i++) {
				if(sampleIds[i].equals(sampleIdString)) {
					System.out.println("相等");
				} else {
					if(newSampleIds == null || "".equals(newSampleIds)) {
						newSampleIds = sampleIds[i];
					} else {
						newSampleIds += "," + sampleIds[i];
					}
					
				}
			}
			if(newSampleIds == null || "".equals(newSampleIds)) {
				returnSingleService.delete(returnsingle.getId());
			} else {
				r.setSampleIds(newSampleIds);
				returnSingleService.updateSampleIdsOfNull(r);
			}
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
}
