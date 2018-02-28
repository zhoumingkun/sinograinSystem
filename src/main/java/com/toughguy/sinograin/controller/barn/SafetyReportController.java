package com.toughguy.sinograin.controller.barn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.toughguy.sinograin.model.barn.SafetyReport;
import com.toughguy.sinograin.pagination.PagerModel;
import com.toughguy.sinograin.service.barn.prototype.ISafetyReportService;
import com.toughguy.sinograin.util.UploadUtil;

@Controller
@RequestMapping("/safetyReport")
public class SafetyReportController {

	@Autowired
	private ISafetyReportService safeService;
	
	@ResponseBody
	@RequestMapping("/getAll")
	public List<SafetyReport> getAll(){
		return safeService.findAll();
	}
	@ResponseBody
	@RequestMapping(value = "/edit")
	public String edit(SafetyReport report) {
		try {
			safeService.update(report);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	@ResponseBody
	@RequestMapping(value = "/save")
	public String saveSample(SafetyReport report,MultipartFile pictureFile) {
		if(UploadUtil.isPicture(pictureFile.getOriginalFilename())){
			try {
				String path = UploadUtil.uploadPicture(pictureFile);
				report.setImage(path);
				safeService.save(report);
				return "{ \"success\" : true }";
			} catch (Exception e) {
				e.printStackTrace();
				return "{ \"success\" : false \"msg\" : \"上传失败\"}";
			}
		}
		return "{ \"success\" : false, \"msg\" : \"请上传图片格式的图片\" }";
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
			PagerModel<SafetyReport> pg = safeService.findPaginated(map);
			
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
