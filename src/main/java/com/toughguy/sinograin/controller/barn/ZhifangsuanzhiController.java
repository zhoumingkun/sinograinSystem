package com.toughguy.sinograin.controller.barn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.toughguy.sinograin.model.barn.SmallSample;
import com.toughguy.sinograin.model.barn.Zhifangsuanzhi;
import com.toughguy.sinograin.service.barn.prototype.ISmallSampleService;
import com.toughguy.sinograin.service.barn.prototype.IZhifangsuanzhiService;


@Controller
@RequestMapping("/zhifangsuanzhi")
public class ZhifangsuanzhiController {
	@Autowired
	private IZhifangsuanzhiService zhifangsuanzhiService;
	@Autowired
	private ISmallSampleService smallSampleService;
	
	@ResponseBody
	@RequestMapping("/getAll")
	//@RequiresPermissions("zhifangsuanzhi:all")
	public List<Zhifangsuanzhi> getAll(){
		return zhifangsuanzhiService.findAll();
	}
	@ResponseBody
	@RequestMapping("/get")
	//@RequiresPermissions("zhifangsuanzhi:all")
	public Zhifangsuanzhi get(int id){
		return zhifangsuanzhiService.find(id);
	}
	@ResponseBody
	@RequestMapping("/getBySmallSampleId")
	//@RequiresPermissions("zhifangsuanzhi:all")
	public Zhifangsuanzhi getBySmallSampleId(int id){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("smallSampleId", id);
		List<Zhifangsuanzhi> zfszs = zhifangsuanzhiService.findAll(map);
		for(Zhifangsuanzhi zfsz:zfszs) {
			return zfsz;
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "/remove")
	//@RequiresPermissions("zhifangsuanzhi:delete")
	public String remove(int id) {
		try {
			zhifangsuanzhiService.delete(id);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/edit")
	//@RequiresPermissions("zhifangsuanzhi:edit")
	public String remove(Zhifangsuanzhi zhifangsuanzhi) {
		try {
			zhifangsuanzhiService.update(zhifangsuanzhi);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	@ResponseBody
	@RequestMapping(value = "/save")
	//@RequiresPermissions("zhifangsuanzhi:delete")
	public String save(Zhifangsuanzhi zhifangsuanzhi) {
		try {
			SmallSample ss = smallSampleService.find(zhifangsuanzhi.getSmallSampleId());
			ss.setState(2);
			smallSampleService.update(ss);
			zhifangsuanzhiService.save(zhifangsuanzhi);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
//	@ResponseBody
//	@RequestMapping(value = "/data")
//	//@RequiresPermissions("library:list")
//	public String data(String params) {
//		try {
//			ObjectMapper om = new ObjectMapper();
//			Map<String, Object> map = new HashMap<String, Object>();
//			if (!StringUtils.isEmpty(params)) {
//				// 参数处理
//				map = om.readValue(params, new TypeReference<Map<String, Object>>() {});
//			}
//			PagerModel<Zhifangsuanzhi> pg = zhifangsuanzhiService.findPaginated(map);
//			
//			// 序列化查询结果为JSON
//			Map<String, Object> result = new HashMap<String, Object>();
//			result.put("total", pg.getTotal());
//			result.put("rows", pg.getData());
//			return om.writeValueAsString(result);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return "{ \"total\" : 0, \"rows\" : [] }";
//		}
//	}
	
}


