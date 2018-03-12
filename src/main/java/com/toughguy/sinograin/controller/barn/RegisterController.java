package com.toughguy.sinograin.controller.barn;

import java.io.File;
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
import com.toughguy.sinograin.dto.SamplingDTO;
import com.toughguy.sinograin.model.barn.Library;
import com.toughguy.sinograin.model.barn.Register;
import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.model.barn.SampleNo;
import com.toughguy.sinograin.pagination.PagerModel;
import com.toughguy.sinograin.service.barn.prototype.ILibraryService;
import com.toughguy.sinograin.service.barn.prototype.IRegisterService;
import com.toughguy.sinograin.service.barn.prototype.ISampleNoService;
import com.toughguy.sinograin.service.barn.prototype.ISampleService;
import com.toughguy.sinograin.util.BarCodeUtil;
import com.toughguy.sinograin.util.SamplingUtil;
import com.toughguy.sinograin.util.UploadUtil;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	private IRegisterService registerService;
	@Autowired
	private ISampleService sampleService;
	@Autowired
	private ILibraryService libraryService;
	@Autowired
	private ISampleNoService noService;
	
	@ResponseBody
	@RequestMapping("/getAll")
	//@RequiresPermissions("register:all")
	public List<Register> getAll(){
		return registerService.findAll();
	}
	
/*	@ResponseBody
	@RequestMapping(value = "/exportExcel")
	//@RequiresPermissions("register:export")
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
	}*/
	@ResponseBody
	@RequestMapping(value = "/exportExcel")
	//@RequiresPermissions("register:export")
	public String exportExcel(int pId,HttpServletResponse response){
		try{
			Register reg = registerService.find(pId);
			Map<String,Object> map = new HashMap<>();
			map.put("pId",pId);
			List<Sample> sampleList = sampleService.findAll(map);
			SamplingDTO dto = new SamplingDTO();
			dto.setRegister(reg);
			dto.setList(sampleList);
			registerService.expertExcel(response, dto);
			return "{ \"success\" : true }";
		}catch(Exception e){
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	@ResponseBody
	@RequestMapping(value = "/edit")
	//@RequiresPermissions("register:edit")
	public String edit(Register register) {
		try {
			Register reg = registerService.find(register.getId());
			Library lib = libraryService.find(reg.getLibraryId());
			if(register.getRegState() == 2) {
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("pId", register.getId());
				List<Sample> s = sampleService.findAll(params);
				SamplingUtil su = new SamplingUtil();
				for(Sample sample:s) {
					String sort = "00";
					if("小麦".equals(sample.getSort())){
						sort = "01";
					}else if("玉米".equals(sample.getSort())){
						sort = "02";
					}else if("食用油".equals(sample.getSort())){
						sort = "03";
					}else {
						sort = "04";
					}
					String name = String.format("%03d", reg.getLibraryId());	
					Map<String,Object > map = new  HashMap<String,Object>();
					map.put("prefix", 60+name+sort);
					SampleNo no = noService.findAll(map).get(0);
					String newSampleNo = su.SampleNumber(reg.getLibraryId(), sort,no.getNum()+1);
					String sampleWork = su.SampleWork(lib.getpLibraryName(), sample.getSort(), no.getNum()+1);
					sample.setSampleNo(newSampleNo);
					sample.setSampleWord(sampleWork);
					//生成二维码
					String path = UploadUtil.getAbsolutePath("barcode");
					File f = new File(path);  //无路径则创建 
					if(!f.exists()){
						f.mkdirs();
					}
					String barFileName = BarCodeUtil.rename("png");
					BarCodeUtil.generateFile(newSampleNo, path + "/"+ barFileName);
					/*String vpath = UploadUtil.getAbsolutePath("vbarcode");
					File vf = new File(vpath);  //无路径则创建 
					if(!vf.exists()){
						vf.mkdirs();
					}
					BufferedImage src = ImageIO.read(new File(path + "/"+ barFileName)); 
					BufferedImage des = BarCodeUtil.Rotate(src, 90);
					ImageIO.write(des, "jpg", new File(vpath + "/"+ barFileName));*/
					sample.setSamplePic(barFileName);
					sampleService.update(sample);
				}
			}
			register.setFormName(reg.getFormName());
			registerService.update(register);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/save")
	//@RequiresPermissions("register:add")
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
	//@RequiresPermissions("register:list")
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
