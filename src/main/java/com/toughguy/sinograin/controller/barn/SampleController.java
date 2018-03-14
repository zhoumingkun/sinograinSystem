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
import com.toughguy.sinograin.dto.SamplingDTO;
import com.toughguy.sinograin.model.barn.Register;
import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.pagination.PagerModel;
import com.toughguy.sinograin.service.barn.prototype.IBarnService;
import com.toughguy.sinograin.service.barn.prototype.ISampleService;
import com.toughguy.sinograin.util.JsonUtil;

@Controller
@RequestMapping(value = "/sample")
public class SampleController {

	@Autowired
	private ISampleService sampleService;
	@Autowired
	private IBarnService barnService;
	
	@ResponseBody
	@RequestMapping(value = "/getAll")
	//@RequiresPermissions("sample:all")
	public List<Sample> getAll() {		
		return sampleService.findAll();
	}
	
	@ResponseBody
	@RequestMapping(value = "/get")
	//@RequiresPermissions("sample:get")
	public Sample get(int id) {	
		return sampleService.find(id);
	}
	
	@ResponseBody
	@RequestMapping(value = "/remove")
	//@RequiresPermissions("sample:get")
	public String remove(int id) {
		try {
			sampleService.delete(id);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/edit")
	//@RequiresPermissions("sample:edit")
	public String edit(Sample sample) {
		try {
			Sample sample1 = sampleService.find(sample.getId());
			sample.setPosition(sample1.getPosition());
			sampleService.update(sample);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/getBySampleNo")
	//@RequiresPermissions("sample:edit")
	public Sample getBySampleNo(String sampleNo) {	
			return sampleService.findBySampleNo(sampleNo);
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrEditAll")
	//@RequiresPermissions("sample:edit")
	public String saveOrEditAll(Register register,String sample) {
		try {
			SamplingDTO samplingDTO = new SamplingDTO();
			List<Sample> list = JsonUtil.jsonToList(sample, Sample.class);
			samplingDTO.setRegister(register);
			samplingDTO.setList(list);
			barnService.saveOrEditAll(samplingDTO);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/save")
	//@RequiresPermissions("sample:add")
	public String saveSample(Sample sample) {
		try {
			sampleService.save(sample);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	@ResponseBody
	@RequestMapping(value = "/saveAll")
	//@RequiresPermissions("sample:add")
	public String saveSampleAndRegister(Register register,String sample) {
		try {
			SamplingDTO samplingDTO = new SamplingDTO();
			List<Sample> list = JsonUtil.jsonToList(sample, Sample.class);
			samplingDTO.setRegister(register);
			samplingDTO.setList(list);
			barnService.saveSampleAndRegister(samplingDTO);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/data")
	//@RequiresPermissions("sample:list")
	public String data(String params) {
		try {
			ObjectMapper om = new ObjectMapper();
			Map<String, Object> map = new HashMap<String, Object>();
			if (!StringUtils.isEmpty(params)) {
				// 参数处理
				map = om.readValue(params, new TypeReference<Map<String, Object>>() {});
			}
			PagerModel<Sample> pg = sampleService.findPaginated(map);		
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
	@RequestMapping(value = "/dataMobile")
	//@RequiresPermissions("sample:list")
	public String dataMobile(String params) {
		try {
			ObjectMapper om = new ObjectMapper();
			Map<String, Object> map = new HashMap<String, Object>();
			if (!StringUtils.isEmpty(params)) {
				// 参数处理
				map = om.readValue(params, new TypeReference<Map<String, Object>>() {});
			}
			PagerModel<Sample> pg = sampleService.findPaginatedMobile(map);		
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
