package com.toughguy.sinograin.controller.barn;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.toughguy.sinograin.model.barn.SmallSample;
import com.toughguy.sinograin.model.barn.Yumipinchang;
import com.toughguy.sinograin.model.barn.Zhenjundusu;
import com.toughguy.sinograin.service.barn.prototype.ISmallSampleService;
import com.toughguy.sinograin.service.barn.prototype.IZhenjundusuService;

@Controller
@RequestMapping("/zhenjundusu")
public class ZhenjundusuController {
	@Autowired
	private IZhenjundusuService zhenjundusuService;
	@Autowired
	private ISmallSampleService smallSampleService;
	
	@ResponseBody
	@RequestMapping("/getAll")
	//@RequiresPermissions("zhenjundusu:all")
	public List<Zhenjundusu> getAll(){
		return zhenjundusuService.findAll();
	}
	@ResponseBody
	@RequestMapping("/get")
	//@RequiresPermissions("zhenjundusu:all")
	public Zhenjundusu get(int id){
		return zhenjundusuService.find(id);
	}
	
	@ResponseBody
	@RequestMapping("/getBySmallSampleId")
	//@RequiresPermissions("zhenjundusu:all")
	public Zhenjundusu getBySmallSampleId(int id){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("smallSampleId", id);
		List<Zhenjundusu> zjdss = zhenjundusuService.findAll(map);
		for(Zhenjundusu zjds:zjdss) {
			return zjds;
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "/remove")
	//@RequiresPermissions("zhenjundusu:delete")
	public String remove(int id) {
		try {
			zhenjundusuService.delete(id);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/edit")
	//@RequiresPermissions("zhenjundusu:edit")
	public String remove(Zhenjundusu zhenjundusu) {
		try {
			zhenjundusuService.update(zhenjundusu);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	@ResponseBody
	@RequestMapping(value = "/save")
	//@RequiresPermissions("zhenjundusu:save")
	public String save(Zhenjundusu zhenjundusu) {
		try {
			SmallSample smallSample = smallSampleService.find(zhenjundusu.getSmallSampleId());
			smallSample.setState(2);
			smallSampleService.update(smallSample);
			zhenjundusuService.save(zhenjundusu);
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
//			PagerModel<Zhenjundusu> pg = zhenjundusuService.findPaginated(map);
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

