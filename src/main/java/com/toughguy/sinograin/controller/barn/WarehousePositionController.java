package com.toughguy.sinograin.controller.barn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.toughguy.sinograin.model.barn.WarehousePosition;
import com.toughguy.sinograin.service.barn.prototype.IWarehousePositionService;

/**
 * 仓房柜
 * @author BOBO
 *
 */
@Controller
@RequestMapping("/warehousePosition")
public class WarehousePositionController {
	@Autowired
	private IWarehousePositionService warehousePositionService;
	
	@ResponseBody
	@RequestMapping("/getAll")
	public List<WarehousePosition> getAll(){
		return warehousePositionService.findAll();
	}
	
	@ResponseBody
	@RequestMapping("/get")
	public WarehousePosition get(int id){
		return warehousePositionService.find(id);
	}
	
	@ResponseBody
	@RequestMapping(value = "/save")
	public String save(WarehousePosition warehousePosition) {
		try {
			warehousePositionService.save(warehousePosition);
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
			warehousePositionService.delete(id);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/edit")
	public String remove(WarehousePosition warehousePosition) {
		try {
			warehousePositionService.update(warehousePosition);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
}
