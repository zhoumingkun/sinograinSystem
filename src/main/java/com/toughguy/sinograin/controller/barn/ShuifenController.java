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
	//@RequiresPermissions("library:all")
	public List<Shuifen> getAll(){
		return shuifenService.findAll();
	}
	
	@ResponseBody
	@RequestMapping("/get")
	//@RequiresPermissions("library:all")
	public Shuifen get(int id){
		return shuifenService.find(id);
	}
	
	@ResponseBody
	@RequestMapping("/getBySmallSampleId")
	//@RequiresPermissions("library:all")
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
	//@RequiresPermissions("library:add")
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
	//@RequiresPermissions("sample:get")
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
	//@RequiresPermissions("library:edit")
	public String remove(Shuifen shuifen) {
		try {
			shuifenService.update(shuifen);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	
	/*	
	
	@ResponseBody
	@RequestMapping(value = "/remove")
	//@RequiresPermissions("library:edit")
	public String remove(Handover handover) {
		try {
			barnService.dealCheck(handover,3,null);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/edit")
	//@RequiresPermissions("library:edit")
	public String edit(Handover handover,String[] deleteIds) {
		try {
			barnService.dealCheck(handover,2,deleteIds);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	@ResponseBody
	@RequestMapping(value = "/save")
	//@RequiresPermissions("library:add")
	public String saveSample(Handover handover) {
		try {
			barnService.dealCheck(handover,1,null);
			int id = handover.getId();
			return "{ \"success\" : true ,\"id\":"+ id +" }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/data")
	//@RequiresPermissions("library:list")
	public String data(String params) {
		try {
			ObjectMapper om = new ObjectMapper();
			Map<String, Object> map = new HashMap<String, Object>();
			if (!StringUtils.isEmpty(params)) {
				// 参数处理
				map = om.readValue(params, new TypeReference<Map<String, Object>>() {});
			}
			PagerModel<Handover> pg = handoverService.findPaginated(map);
			
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
*/	
}
