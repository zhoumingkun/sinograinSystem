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
import com.toughguy.sinograin.model.barn.Yumipinchang;
import com.toughguy.sinograin.service.barn.prototype.ISmallSampleService;
import com.toughguy.sinograin.service.barn.prototype.IYumipinchangService;

@Controller
@RequestMapping("/yumipinchang")
public class YumipinchangController {
	@Autowired
	private IYumipinchangService yumipinchangService;
	@Autowired
	private ISmallSampleService smallSampleService;
	
	@ResponseBody
	@RequestMapping("/getAll")
	//@RequiresPermissions("library:all")
	public List<Yumipinchang> getAll(){
		return yumipinchangService.findAll();
	}
	
	@ResponseBody
	@RequestMapping("/get")
	//@RequiresPermissions("yumipinchang:getById")
	public Yumipinchang get(int id){
		return yumipinchangService.find(id);
	}
	
	@ResponseBody
	@RequestMapping("/getBySmallSampleId")
	//@RequiresPermissions("yumipinchang:getBySmallSampleId")
	public Yumipinchang getBySmallSampleId(int id){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("smallSampleId", id);
		List<Yumipinchang> ympcs = yumipinchangService.findAll(map);
		for(Yumipinchang ympc:ympcs) {
			return ympc;
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "/save")
	//@RequiresPermissions("yumipinchang:save")
	public String save(Yumipinchang yumipinchang) {
		System.out.println(yumipinchang);
		try {
			SmallSample smallSample = smallSampleService.find(yumipinchang.getSmallSampleId());
			smallSample.setState(2);
			smallSampleService.update(smallSample);
			yumipinchangService.save(yumipinchang);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/remove")
	//@RequiresPermissions("yumipinchang:remove")
	public String remove(int id) {
		try {
			yumipinchangService.delete(id);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/edit")
	//@RequiresPermissions("yumipinchang:edit")
	public String remove(Yumipinchang yumipinchang) {
		try {
			yumipinchangService.update(yumipinchang);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	
}
