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
import com.toughguy.sinograin.model.barn.WarehouseCounterPlace;
import com.toughguy.sinograin.pagination.PagerModel;
import com.toughguy.sinograin.service.barn.prototype.IWarehouseCounterPlaceService;

/**
 * 仓房柜号里的位置
 * @author BOBO
 *
 */
@Controller
@RequestMapping("/warehouseCounterPlace")
public class WarehouseCounterPlaceController {
	@Autowired
	private IWarehouseCounterPlaceService warehouseCounterPlaceService;
	
	@ResponseBody
	@RequestMapping("/getAll")
	public List<WarehouseCounterPlace> getAll(){
		return warehouseCounterPlaceService.findAll();
	}
	
	@ResponseBody
	@RequestMapping("/get")
	public WarehouseCounterPlace get(int id){
		return warehouseCounterPlaceService.find(id);
	}
	
	@ResponseBody
	@RequestMapping(value = "/save")
	public String save(WarehouseCounterPlace warehouseCounterPlace) {
		try {
			warehouseCounterPlaceService.save(warehouseCounterPlace);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/remove")
	public String remove(int id) {
		try {
			warehouseCounterPlaceService.delete(id);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/edit")
	public String remove(WarehouseCounterPlace warehouseCounterPlace) {
		try {
			warehouseCounterPlaceService.update(warehouseCounterPlace);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	@ResponseBody
	@RequestMapping(value = "/findPlaces")
	public List<WarehouseCounterPlace> findPlaces(int counterId) {
		try {
			List<WarehouseCounterPlace> ws = warehouseCounterPlaceService.findPlaces(counterId);
			return ws;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@ResponseBody
	@RequestMapping(value = "/findPlacesByCounter")
	public List<WarehouseCounterPlace> findPlacesByCounter(String counter) {
		try {
			List<WarehouseCounterPlace> ws = warehouseCounterPlaceService.findPlacesByCounter(counter);
			return ws;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/data")
	//@RequiresPermissions("SmallSample:list")
	public String data(String params) {
		try {
			ObjectMapper om = new ObjectMapper();
			Map<String, Object> map = new HashMap<String, Object>();
			if (!StringUtils.isEmpty(params)) {
				// 参数处理
				map = om.readValue(params, new TypeReference<Map<String, Object>>() {});
			}
			PagerModel<WarehouseCounterPlace> pg = warehouseCounterPlaceService.findPaginated(map);
			
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
	
}
