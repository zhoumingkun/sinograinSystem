package com.toughguy.sinograin.controller.barn;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.toughguy.sinograin.model.barn.Mantoubirong;
import com.toughguy.sinograin.service.barn.prototype.IMantoubirongService;


@Controller
@RequestMapping("/Mantoubirong")
public class MantoubirongController {
	@Autowired
	private IMantoubirongService mantoubirongService;
	
	@ResponseBody
	@RequestMapping("/getAll")
	//@RequiresPermissions("Mantoubirong:all")
	public List<Mantoubirong> getAll(){
		return mantoubirongService.findAll();
	}
	@ResponseBody
	@RequestMapping("/get")
	//@RequiresPermissions("Mantoubirong:getById")
	public Mantoubirong get(int id){
		return mantoubirongService.find(id);
	}
	
	@ResponseBody
	@RequestMapping(value = "/remove")
	//@RequiresPermissions("Mantoubirong:remove")
	public String remove(int id) {
		try {
			mantoubirongService.delete(id);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/edit")
	//@RequiresPermissions("Mantoubirong:edit")
	public String remove(Mantoubirong mantoubirong) {
		try {
			mantoubirongService.update(mantoubirong);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	@ResponseBody
	@RequestMapping(value = "/save")
	//@RequiresPermissions("Mantoubirong:save")
	public String save(Mantoubirong mantoubirong) {
		try {
			mantoubirongService.save(mantoubirong);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}

}

