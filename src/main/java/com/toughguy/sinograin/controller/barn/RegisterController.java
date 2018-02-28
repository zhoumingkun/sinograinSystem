package com.toughguy.sinograin.controller.barn;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.toughguy.sinograin.dto.ExcelDTO;
import com.toughguy.sinograin.model.barn.Register;
import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.pagination.PagerModel;
import com.toughguy.sinograin.service.barn.prototype.IRegisterService;
import com.toughguy.sinograin.service.barn.prototype.ISampleService;
import com.toughguy.sinograin.util.ExcelUtil;
import com.toughguy.sinograin.util.SamplingUtil;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	private IRegisterService registerService;
	@Autowired
	private ISampleService sampleService;
	
	@ResponseBody
	@RequestMapping("/getAll")
	public List<Register> getAll(){
		return registerService.findAll();
	}
	
	@ResponseBody
	@RequestMapping(value = "/exportExcel")
	public String exportExcel(int pId,HttpServletResponse response){
		try {
		Register reg = registerService.find(pId);
		List<String> headerName = new ArrayList<String>();
		headerName.add("被查库点");
		headerName.add("品种");
		headerName.add("性质");
		headerName.add("数量（吨）");
		headerName.add("产地");
		headerName.add("收获年度");
		headerName.add("扦样人员签字");
		headerName.add("现场人员签字");
		headerName.add("备注");
		List<String> headerId = new ArrayList<String>();
		headerId.add("libraryName");
		headerId.add("sort");
		headerId.add("quality");
		headerId.add("amount");
		headerId.add("originPlace");
		headerId.add("gainTime");
		headerId.add("autograph");
		headerId.add("autograph");
		headerId.add("remark");	
		Map<String,Object> map = new HashMap<>();
		map.put("pId",pId);
		List<Sample> sampleList = sampleService.findAll(map);
		ExcelDTO<Sample> dto =new ExcelDTO<Sample>();
		dto.setFileName(reg.getFormName());
		dto.setTableName(reg.getFormName());
		dto.setHeadersName(headerName);
		dto.setHeadersId(headerId);
		dto.setDtoList(sampleList);
		dto.setTitle(reg.getLibraryName());
		ExcelUtil<Sample> excel = new ExcelUtil<Sample>();
		excel.exportExcel(dto,response);
		return "{ \"success\" : true }";
			}catch(Exception e){
				e.printStackTrace();
				return "{ \"success\" : false }";
			}
	}
	
	@ResponseBody
	@RequestMapping(value = "/edit")
	public String edit(Register register) {
		try {
			if(register.getRegState() == 1) {
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("pId", register.getId());
				List<Sample> s = sampleService.findAll(params);
				SamplingUtil su = new SamplingUtil();
				for(Sample sample:s) {
					String newSampleNo = su.SampleNumber(register.getFormName(), sample.getSort());
					sample.setSampleNo(newSampleNo);
					sampleService.update(sample);
				}
			}
			registerService.update(register);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/save")
	public String saveSample(Register register) {
		try {
			registerService.save(register);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/data")
	public String data(String params) {
		try {
			ObjectMapper om = new ObjectMapper();
			Map<String, Object> map = new HashMap<String, Object>();
			if (!StringUtils.isEmpty(params)) {
				// 参数处理
				map = om.readValue(params, new TypeReference<Map<String, Object>>() {});
			}
			PagerModel<Register> pg = registerService.findPaginated(map);
			
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
