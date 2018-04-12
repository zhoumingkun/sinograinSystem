package com.toughguy.sinograin.controller.barn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.toughguy.sinograin.model.barn.Mantoupinchang;
import com.toughguy.sinograin.model.barn.SmallSample;
import com.toughguy.sinograin.service.barn.prototype.IMantoupinchangService;
import com.toughguy.sinograin.service.barn.prototype.ISmallSampleService;

@Controller
@RequestMapping("/mantoupinchang")
public class MantoupinchangController {
	@Autowired
	private IMantoupinchangService mantoupinchangService;
	@Autowired
	private ISmallSampleService smallSampleService;
	
	@ResponseBody
	@RequestMapping("/getAll")
	//@RequiresPermissions("mantoupinchang:all")
	public List<Mantoupinchang> getAll(){
		return mantoupinchangService.findAll();
	}
	
	@ResponseBody
	@RequestMapping("/get")
	//@RequiresPermissions("mantoupinchang:all")
	public Mantoupinchang get(int id){
		return mantoupinchangService.find(id);
	}
	
	@ResponseBody
	@RequestMapping("/getBySmallSampleId")
	//@RequiresPermissions("mantoupinchang:all")
	public Mantoupinchang getBySmallSampleId(int id){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("smallSampleId", id);
		List<Mantoupinchang> mtpcs = mantoupinchangService.findAll(map);
		for(Mantoupinchang mtpc:mtpcs) {
			return mtpc;
		}
		return null;
	}
	@ResponseBody
	@RequestMapping(value = "/save")
	//@RequiresPermissions("mantoupinchang:save")
	public String save(Mantoupinchang mantoupinchang) {
		try {
			SmallSample smallSample = smallSampleService.find(mantoupinchang.getSmallSampleId());
			smallSample.setState(2);
			smallSampleService.update(smallSample);
			mantoupinchangService.save(mantoupinchang);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/remove")
	//@RequiresPermissions("mantoupinchang:delete")
	public String remove(int id) {
		try {
			mantoupinchangService.delete(id);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/edit")
	//@RequiresPermissions("mantoupinchang:edit")
	public String remove(Mantoupinchang mantoupinchang) {
		try {
			mantoupinchangService.update(mantoupinchang);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	
}
