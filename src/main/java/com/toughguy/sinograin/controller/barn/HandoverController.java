package com.toughguy.sinograin.controller.barn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.toughguy.sinograin.model.barn.Handover;
import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.pagination.PagerModel;
import com.toughguy.sinograin.service.barn.prototype.IBarnService;
import com.toughguy.sinograin.service.barn.prototype.IHandoverService;
import com.toughguy.sinograin.service.barn.prototype.ISampleService;

@Controller
@RequestMapping("/handover")
public class HandoverController {
	
	@Autowired
	private IHandoverService handoverService;
	@Autowired
	private IBarnService barnService;
	@Autowired
	private ISampleService sampleService;
	
	@ResponseBody
	@RequestMapping("/getAll")
	//@RequiresPermissions("handover:all")
	public List<Handover> getAll(){
		return handoverService.findAll();
	}
	
	@ResponseBody
	@RequestMapping("/get")
	@RequiresPermissions("handover:getById")
	public Handover get(int id){
		return handoverService.find(id);
	}
	
	@ResponseBody
	@RequestMapping("/getStorage")
	@RequiresPermissions("handover:getById")
	public Handover getStorage(int id){
		Handover h = handoverService.find(id);
		List<Sample> ss = new ArrayList<Sample>();
		String[] sampleNums = h.getSampleNums().split(",");
		for(int i=0;i<sampleNums.length;i++) {
			Sample s = sampleService.findBySampleNum(sampleNums[i]);
			s.setStorage(s.getDepot() + "--" + s.getCounter() + "--" + s.getPlace());
			ss.add(s);
		}
		h.setSamples(ss);
		return h;
	}
	
	@ResponseBody
	@RequestMapping(value = "/remove")
	//@RequiresPermissions("handover:remove")
	public String remove(Handover handover) {
		try {
			barnService.dealCheck(handover,3,null);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	//删除交接单
	@ResponseBody
	@RequestMapping(value = "/removeHandover")
	//@RequiresPermissions("handover:remove")
	public String removeHandover(int id) {
		try {
			 Handover handover = handoverService.find(id);
			 String sampleIds = handover.getSampleIds();
			 String[] sampleIds2 = sampleIds.split(",");
			for(int i=0;i<sampleIds2.length;i++) {
				Sample sample = sampleService.find(Integer.parseInt(sampleIds2[i]));
				sample.setSampleState(2);
				sampleService.update(sample);
			}
			//将交接单状态改为不启用
			handover.setState(1);
			handoverService.update(handover);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/edit")
	//@RequiresPermissions("handover:edit")
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
	@RequiresPermissions("handover:save")
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
	
//	@ResponseBody
//	@RequestMapping(value = "/guiHuan")
//	public String guiHuan(Handover handover) {
//		try {
//			handover.setReturnTime(DateUtil.now());
//			handoverService.update(handover);
//			String[] sampleNums = handover.getSampleNums().split(",");
//			for(int i=0;i<sampleNums.length;i++) {
//				Sample s = sampleService.findBySampleNum(sampleNums[i]);
//				s.setDetectionState(2);
//				sampleService.update(s);
//			}
//			return "{ \"success\" : true}";
//		} catch (Exception e) {
//			e.printStackTrace();
//			return "{ \"success\" : false }";
//		}
//	}
	
	@ResponseBody
	@RequestMapping(value = "/data")
	@RequiresPermissions("handover:list")
	public String data(String params) {
		try {
			ObjectMapper om = new ObjectMapper();
			Map<String, Object> map = new HashMap<String, Object>();
			if (!StringUtils.isEmpty(params)) {
				// 参数处理
				map = om.readValue(params, new TypeReference<Map<String, Object>>() {});
				map.put("state", -1);
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
	
	@ResponseBody
	@RequestMapping(value = "/getBySampleNum")
	public Handover getBySampleNum(String sampleNum) {
		try {
			List<Handover> handovers = handoverService.findAll();
			for(Handover h:handovers) {
				String[] hs = h.getSampleNums().split(",");
				for(int i=0;i<hs.length;i++) {
					if(sampleNum.equals(hs[i])) {
						return h;
					}
				}
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	/**
	 *  导出样品领取交接单
	 * @param id
	 * @return String
	 */
	@ResponseBody
	@RequestMapping(value = "/expotHandover")
	public String expotHandover(int id,HttpServletResponse response){
		try {
			Handover handover = handoverService.find(id);
			handoverService.expotHandover(response,handover,false);
			return "{ \"success\" : true}";
		} catch (Exception e) {
			// TODO: handle exception
			return "{ \"success\" : false}";
		}
	}
	/**
	 *  导出带有位置的样品领取交接单
	 * @param id
	 * @return String
	 */
	@ResponseBody
	@RequestMapping(value = "/expotStorageHandover")
	public String expotStorageHandover(int id,HttpServletResponse response){
		try {
			Handover handover = handoverService.find(id);
			handoverService.expotHandover(response,handover,true);
			return "{ \"success\" : true}";
		} catch (Exception e) {
			// TODO: handle exception
			return "{ \"success\" : false}";
		}
	}
	@ResponseBody
	@RequestMapping(value = "/getSampleByCheckPoint")
	public List<Sample> getSampleByCheckPoint(int checkPoint){
		return handoverService.findSampleByCheckPoint(checkPoint);
			
	}
	
}
