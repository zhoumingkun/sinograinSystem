package com.toughguy.sinograin.controller.barn;

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
import com.toughguy.sinograin.model.barn.Mianjinxishuiliang;
import com.toughguy.sinograin.model.barn.Shuifen;
import com.toughguy.sinograin.model.barn.SmallSample;
import com.toughguy.sinograin.pagination.PagerModel;
import com.toughguy.sinograin.service.barn.prototype.IMianjinxishuiliangService;
import com.toughguy.sinograin.service.barn.prototype.ISmallSampleService;


@Controller
@RequestMapping("/mianjinxishuiliang")
public class MianjinxishuiliangController {
	@Autowired
	private IMianjinxishuiliangService mianjinxishuiliangService;
	@Autowired
	private ISmallSampleService smallSampleService;
	
	@ResponseBody
	@RequestMapping("/getAll")
	//@RequiresPermissions("library:all")
	public List<Mianjinxishuiliang> getAll(){
		return mianjinxishuiliangService.findAll();
	}
	@ResponseBody
	@RequestMapping("/get")
	//@RequiresPermissions("library:all")
	public Mianjinxishuiliang get(int id){
		return mianjinxishuiliangService.find(id);
	}
	
	@ResponseBody
	@RequestMapping("/getBySmallSampleId")
	//@RequiresPermissions("library:all")
	public Mianjinxishuiliang getBySmallSampleId(int id){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("smallSampleId", id);
		List<Mianjinxishuiliang> mjxsls = mianjinxishuiliangService.findAll(map);
		for(Mianjinxishuiliang mjxsl:mjxsls) {
			return mjxsl;
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "/remove")
	//@RequiresPermissions("library:edit")
	public String remove(int id) {
		try {
			mianjinxishuiliangService.delete(id);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/edit")
	//@RequiresPermissions("library:edit")
	public String remove(Mianjinxishuiliang mianjinxishuiliang) {
		try {
			mianjinxishuiliangService.update(mianjinxishuiliang);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	@ResponseBody
	@RequestMapping(value = "/save")
	//@RequiresPermissions("library:add")
	public String save(Mianjinxishuiliang mianjinxishuiliang) {
		try {
			SmallSample smallSample = smallSampleService.find(mianjinxishuiliang.getSmallSampleId());
			smallSample.setState(2);
			smallSampleService.update(smallSample);
			mianjinxishuiliangService.save(mianjinxishuiliang);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
//	@ResponseBody
//	@RequestMapping(value = "/data")
//	//@RequiresPermissions("library:list")
//	public String data(String params) {
//		try {
//			ObjectMapper om = new ObjectMapper();
//			Map<String, Object> map = new HashMap<String, Object>();
//			if (!StringUtils.isEmpty(params)) {
//				// 参数处理
//				map = om.readValue(params, new TypeReference<Map<String, Object>>() {});
//			}
//			PagerModel<Mianjinxishuiliang> pg = mianjinxishuiliangService.findPaginated(map);
//			
//			// 序列化查询结果为JSON
//			Map<String, Object> result = new HashMap<String, Object>();
//			result.put("total", pg.getTotal());
//			result.put("rows", pg.getData());
//			return om.writeValueAsString(result);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return "{ \"total\" : 0, \"rows\" : [] }";
//		}
//	}
	
}

