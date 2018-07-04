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
import com.toughguy.sinograin.model.barn.Warehouse;
import com.toughguy.sinograin.model.barn.WarehouseCounter;
import com.toughguy.sinograin.model.barn.WarehouseCounterPlace;
import com.toughguy.sinograin.pagination.PagerModel;
import com.toughguy.sinograin.service.barn.prototype.IWarehouseCounterPlaceService;
import com.toughguy.sinograin.service.barn.prototype.IWarehouseCounterService;

/**
 * 仓房柜
 * @author BOBO
 *
 */
@Controller
@RequestMapping("/warehouseCounter")
public class WarehouseCounterController {
	@Autowired
	private IWarehouseCounterService warehouseCounterService;
	@Autowired
	private IWarehouseCounterPlaceService warehouseCounterPlaceService;
	
	@ResponseBody
	@RequestMapping("/getAll")
	public List<WarehouseCounter> getAll(){
		return warehouseCounterService.findAll();
	}
	
	@ResponseBody
	@RequestMapping("/get")
	public WarehouseCounter get(int id){
		return warehouseCounterService.find(id);
	}
	
	@ResponseBody
	@RequestMapping(value = "/save")
	public String save(WarehouseCounter warehouseCounter) {
		try {
			warehouseCounterService.save(warehouseCounter);
			WarehouseCounter whc = warehouseCounterService.findByCounter(warehouseCounter.getCounter());
			int warehouseTotal = whc.getWarehouseTotal();
			for(int i=1;i<=warehouseTotal;i++) {
				System.out.println(warehouseTotal+"_________________________");
				WarehouseCounterPlace whcp = new WarehouseCounterPlace();
				whcp.setPlace(i);
				whcp.setpId(whc.getId());
				System.out.println(whcp);
				warehouseCounterPlaceService.save(whcp);
			}
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
			warehouseCounterService.delete(id);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/edit")
	public String remove(WarehouseCounter warehouseCounter) {
		try {
			warehouseCounterService.update(warehouseCounter);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
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
			PagerModel<WarehouseCounter> pg = warehouseCounterService.findPaginated(map);
			
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
