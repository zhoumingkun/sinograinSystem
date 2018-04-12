package com.toughguy.sinograin.controller.barn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.toughguy.sinograin.model.barn.Shuifen;
import com.toughguy.sinograin.model.barn.SmallSample;
import com.toughguy.sinograin.model.barn.Zhifangsuanzhi;
import com.toughguy.sinograin.service.barn.prototype.IShuifenService;
import com.toughguy.sinograin.service.barn.prototype.ISmallSampleService;

@Controller
@RequestMapping("/shuifen")
public class ShuifenController {
	@Autowired
	private IShuifenService shuifenService;
	@Autowired
	private ISmallSampleService smallSampleService;
	
	@ResponseBody
	@RequestMapping("/getAll")
	//@RequiresPermissions("shuifen:all")
	public List<Shuifen> getAll(){
		return shuifenService.findAll();
	}
	
	@ResponseBody
	@RequestMapping("/get")
	//@RequiresPermissions("shuifen:all")
	public Shuifen get(int id){
		return shuifenService.find(id);
	}
	
	@ResponseBody
	@RequestMapping("/getBySmallSampleId")
	//@RequiresPermissions("shuifen:all")
	public Shuifen getBySmallSampleId(int id){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("smallSampleId", id);
		List<Shuifen> sfs = shuifenService.findAll(map);
		for(Shuifen sf:sfs) {
			return sf;
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "/save")
	//@RequiresPermissions("shuifen:save")
	public String save(Shuifen shuifen) {
		try {
			SmallSample smallSample = smallSampleService.find(shuifen.getSmallSampleId());
			smallSample.setState(2);
			smallSampleService.update(smallSample);
			shuifenService.save(shuifen);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/remove")
	//@RequiresPermissions("shuifen:delete")
	public String remove(int id) {
		try {
			shuifenService.delete(id);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/edit")
	//@RequiresPermissions("shuifen:edit")
	public String remove(Shuifen shuifen) {
		try {
			shuifenService.update(shuifen);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	
	
}
