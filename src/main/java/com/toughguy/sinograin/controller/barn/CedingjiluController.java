package com.toughguy.sinograin.controller.barn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.toughguy.sinograin.model.barn.Cedingjilu;
import com.toughguy.sinograin.model.barn.SmallSample;
import com.toughguy.sinograin.service.barn.prototype.ICedingjiluService;
import com.toughguy.sinograin.service.barn.prototype.ISmallSampleService;

@Controller
@RequestMapping("/cedingjilu")
public class CedingjiluController {
	@Autowired
	private ICedingjiluService cedingjiluService;
	@Autowired
	private ISmallSampleService smallSampleService;
	
	@ResponseBody
	@RequestMapping("/getAll")
	//@RequiresPermissions("cedingjilu:all")
	public List<Cedingjilu> getAll(){
		return cedingjiluService.findAll();
	}
	
	@ResponseBody
	@RequestMapping("/get")
	//@RequiresPermissions("cedingjilu:getById")
	public Cedingjilu get(int id){
		return cedingjiluService.find(id);
	}
	@ResponseBody
	@RequestMapping("/getBySmallSampleId")
	@RequiresPermissions("cedingjilu:getBySmallSampleId")
	public Cedingjilu getBySmallSampleId(int id){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("smallSampleId", id);
		List<Cedingjilu> cdjls = cedingjiluService.findAll(map);
		for(Cedingjilu cdjl:cdjls) {
			return cdjl;
		}
		return null;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/save")
	@RequiresPermissions("all:save")
	public String save(Cedingjilu cedingjilu) {
		try {
			SmallSample smallSample = smallSampleService.find(cedingjilu.getSmallSampleId());
			smallSample.setState(2);
			smallSampleService.update(smallSample);
			cedingjiluService.save(cedingjilu);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/remove")
	//@RequiresPermissions("cedingjilu:remove")
	public String remove(int id) {
		try {
			cedingjiluService.delete(id);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/edit")
	@RequiresPermissions("all:edit")
	public String remove(Cedingjilu cedingjilu) {
		try {
			cedingjiluService.update(cedingjilu);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	
}
