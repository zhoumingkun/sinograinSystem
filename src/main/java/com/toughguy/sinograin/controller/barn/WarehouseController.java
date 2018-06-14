package com.toughguy.sinograin.controller.barn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.toughguy.sinograin.model.barn.Warehouse;
import com.toughguy.sinograin.service.barn.prototype.IWarehouseService;

/**
 * 仓房
 * @author BOBO
 *
 */
@Controller
@RequestMapping("/warehouse")
public class WarehouseController {
	@Autowired
	private IWarehouseService warehouseService;
	
	@ResponseBody
	@RequestMapping("/getAll")
	public List<Warehouse> getAll(){
		return warehouseService.findAll();
	}
	
	@ResponseBody
	@RequestMapping("/get")
	public Warehouse get(int id){
		return warehouseService.find(id);
	}
	
	@ResponseBody
	@RequestMapping(value = "/save")
	public String save(Warehouse warehouse) {
		try {
			warehouseService.save(warehouse);
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
			warehouseService.delete(id);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/edit")
	public String remove(Warehouse warehouse) {
		try {
			warehouseService.update(warehouse);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
}
