package com.toughguy.sinograin.controller.barn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.toughguy.sinograin.model.barn.Buwanshanli;
import com.toughguy.sinograin.model.barn.SmallSample;
import com.toughguy.sinograin.service.barn.prototype.IBuwanshanliService;
import com.toughguy.sinograin.service.barn.prototype.ISmallSampleService;

@Controller
@RequestMapping("/buwanshanli")
public class BuwanshanliController {
	@Autowired
	private IBuwanshanliService buwanshanliService;
	@Autowired
	private ISmallSampleService smallSampleService;

	@ResponseBody
	@RequestMapping("/getAll")
	//@RequiresPermissions("buwanshanli:all")
	public List<Buwanshanli> getAll(){
		return buwanshanliService.findAll();
	}
	
	@ResponseBody
	@RequestMapping("/get")
	//@RequiresPermissions("buwanshanli:getById")
	public Buwanshanli get(int id){
		return buwanshanliService.find(id);
	}
	
	@ResponseBody
	@RequestMapping("/getBySmallSampleId")
	//@RequiresPermissions("buwanshanli:getBySmallSampleId")
	public Buwanshanli getBySmallSampleId(int id){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("smallSampleId", id);
		List<Buwanshanli> bwsls = buwanshanliService.findAll(map);
		for(Buwanshanli bwsl:bwsls) {
			return bwsl;
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "/save")
	@RequiresPermissions("all:save")
	public String save(Buwanshanli buwanshanli) {
		try {
			SmallSample smallSample = smallSampleService.find(buwanshanli.getSmallSampleId());
			smallSample.setState(2);
			smallSampleService.update(smallSample);
			buwanshanliService.save(buwanshanli);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/remove")
	//@RequiresPermissions("buwanshanli:remove")
	public String remove(int id) {
		try {
			buwanshanliService.delete(id);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/edit")
	@RequiresPermissions("all:edit")
	public String remove(Buwanshanli buwanshanli) {
		try {
			buwanshanliService.update(buwanshanli);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
}
