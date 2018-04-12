package com.toughguy.sinograin.controller.barn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.toughguy.sinograin.model.barn.Pinchang;
import com.toughguy.sinograin.service.barn.prototype.IPinchangService;

@Controller
@RequestMapping("/pinchang")
public class PinchangController {
	@Autowired
	private IPinchangService pinchangService;

	@ResponseBody
	@RequestMapping("/getAll")
	//@RequiresPermissions("pinchang:all")
	public List<Pinchang> getAll(){
		return pinchangService.findAll();
	}
	
	@ResponseBody
	@RequestMapping("/get")
	//@RequiresPermissions("pinchang:all")
	public Pinchang get(int id){
		return pinchangService.find(id);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/save")
	//@RequiresPermissions("pinchang:save")
	public String save(Pinchang pinchang) {
		try {
			pinchangService.save(pinchang);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/remove")
	//@RequiresPermissions("pinchang:delete")
	public String remove(int id) {
		try {
			pinchangService.delete(id);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/edit")
	//@RequiresPermissions("pinchang:edit")
	public String remove(Pinchang pinchang) {
		try {
			pinchangService.update(pinchang);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	/*	
	@ResponseBody
	@RequestMapping(value = "/edit")
	//@RequiresPermissions("pinchang:edit")
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
	//@RequiresPermissions("pinchang:save")
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
	//@RequiresPermissions("pinchang:list")
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
