package com.toughguy.sinograin.controller.barn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.model.barn.Warehouse;
import com.toughguy.sinograin.pagination.PagerModel;
import com.toughguy.sinograin.service.barn.prototype.IWarehouseCounterService;
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
	@Autowired
	private IWarehouseCounterService warehouseCounterService;
	
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
	public String edit(Warehouse warehouse) {
		try {
			warehouseService.update(warehouse);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	@ResponseBody
	@RequestMapping(value = "/data")
	@RequiresPermissions("warehouse:list")
	public String data(String params) {
		try {
			ObjectMapper om = new ObjectMapper();
			Map<String, Object> map = new HashMap<String, Object>();
			if (!StringUtils.isEmpty(params)) {
				// 参数处理
				map = om.readValue(params, new TypeReference<Map<String, Object>>() {});
			}
			PagerModel<Warehouse> pg = warehouseService.findPaginated(map);
			List<Warehouse> whs = pg.getData();
			int xmnum = 0;
			int ymnum = 0;
			int xmzc = 0;
			int xmzd = 0;
			int xmlc = 0;
			int xmsp = 0;
			int xmtd = 0;
			int ymzc = 0;
			int ymzd = 0;
			int ymlc = 0;
			int ymsp = 0;
			int ymtd = 0;
			for(Warehouse wh:whs) {
				List<Sample> ss = warehouseCounterService.findSample(wh.getCounterId());
				for(Sample s:ss) {
					if(s.getSort().equals("小麦")) {
						xmnum++;
						if(s.getQuality() == null || "".equals(s.getQuality())) {
						} else {
							if(s.getQuality().equals("ZC")) {
								xmzc++;
							} else if(s.getQuality().equals("ZD")) {
								xmzd++;
							} else if(s.getQuality().equals("LC")) {
								xmlc++;
							} else if(s.getQuality().equals("SP")) {
								xmsp++;
							} else if(s.getQuality().equals("TD")) {
								xmtd++;
							}
						}
					} else if(s.getSort().equals("玉米")) {
						ymnum++;
						if(s.getQuality() == null || "".equals(s.getQuality())) {
						} else {
							System.out.println(s.getId());
							System.out.println(s.getQuality());
							if(s.getQuality().equals("ZC")) {
								ymzc++;
							} else if(s.getQuality().equals("ZD")) {
								ymzd++;
							} else if(s.getQuality().equals("LC")) {
								ymlc++;
							} else if(s.getQuality().equals("SP")) {
								ymsp++;
							} else if(s.getQuality().equals("TD")) {
								ymtd++;
							}
						}
					}
				}
				String describe = null;
				boolean isxm = false;
				boolean isym = false;
				describe = "小麦:" + xmnum +"个";
				if(xmzc != 0) {
					describe += ",(ZC:" + xmzc +"个";
					isxm = true;
				}
				if(xmzd != 0) {
					if(isxm) {
						describe += ",ZD:" + xmzd +"个";
					} else {
						describe += ",(ZD:" + xmzd +"个";
						isxm = true;
					}
				}
				if(xmlc != 0) {
					if(isxm) {
						describe += ",LC:" + xmlc +"个";
					} else {
						describe += ",(LC:" + xmlc +"个";
						isxm = true;
					}
				}
				if(xmsp != 0) {
					if(isxm) {
						describe += ",SP:" + xmsp +"个";
					} else {
						describe += ",(SP:" + xmsp +"个";
						isxm = true;
					}
				}
				if(xmtd != 0) {
					if(isxm) {
						describe += ",TD:" + xmtd +"个";
					} else {
						describe += ",(TD:" + xmtd +"个";
						isxm = true;
					}
				}
				if(isxm) {
					describe += ")";
				}
				describe += ",玉米:" + ymnum +"个";
				if(ymzc != 0) {
					describe += ",(ZC:" + ymzc +"个";
					isym = true;
				}
				if(ymzd != 0) {
					if(isym) {
						describe += ",ZD:" + ymzd +"个";
					} else {
						describe += ",(ZD:" + ymzd +"个";
						isym = true;
					}
				}
				if(ymlc != 0) {
					if(isym) {
						describe += ",LC:" + ymlc +"个";
					} else {
						describe += ",(LC:" + ymlc +"个";
						isym = true;
					}
				}
				if(ymsp != 0) {
					if(isym) {
						describe += ",SP:" + ymsp +"个";
					} else {
						describe += ",(SP:" + ymsp +"个";
						isym = true;
					}
				}
				if(ymtd != 0) {
					if(isym) {
						describe += ",TD:" + ymtd +"个";
					} else {
						describe += ",(TD:" + ymtd +"个";
						isym = true;
					}
				}
				if(isym) {
					describe += ")";
				}
				wh.setDescribe(describe);
			}
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
