package com.toughguy.sinograin.controller.barn;
import java.io.File;
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
import com.toughguy.sinograin.dto.SamplingDTO;
import com.toughguy.sinograin.model.barn.CornExaminingReport;
import com.toughguy.sinograin.model.barn.Register;
import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.model.barn.SmallSample;
import com.toughguy.sinograin.model.barn.WheatExaminingReport;
import com.toughguy.sinograin.pagination.PagerModel;
import com.toughguy.sinograin.persist.barn.prototype.ICornExaminingReportDao;
import com.toughguy.sinograin.persist.barn.prototype.IWheatExaminingReportDao;
import com.toughguy.sinograin.service.barn.prototype.IBarnService;
import com.toughguy.sinograin.service.barn.prototype.ISampleService;
import com.toughguy.sinograin.service.barn.prototype.ISmallSampleService;
import com.toughguy.sinograin.util.BarCodeUtil;
import com.toughguy.sinograin.util.JsonUtil;
import com.toughguy.sinograin.util.SamplingUtil;
import com.toughguy.sinograin.util.UploadUtil;

@Controller
@RequestMapping(value = "/sample")
public class SampleController {

	@Autowired
	private ISampleService sampleService;
	@Autowired
	private IBarnService barnService;
	@Autowired
	private ISmallSampleService smallSampleService;
	@Autowired
	private IWheatExaminingReportDao wheatExaminingReportDao;
	@Autowired
	private ICornExaminingReportDao cornExaminingReportDao;
	
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
			if(sample.getSampleState()== 2){
				String sampleNum = SamplingUtil.sampleNum();
				//生成二维码
				String path = UploadUtil.getAbsolutePath("barcode");
				File f = new File(path);  //无路径则创建 
				if(!f.exists()){
					f.mkdirs();
				}
				String barFileName = BarCodeUtil.rename("png");
				BarCodeUtil.generateFile(sampleNum, path + "/"+ barFileName);
				sample.setSampleNumPic(barFileName);
				sample.setSampleNum(sampleNum);
			}
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
	@RequestMapping(value = "/getBySampleNum")
	//@RequiresPermissions("sample:edit")
	public Sample getBySampleNum(String sampleNo) {
			return sampleService.findBySampleNum(sampleNo);
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
	@RequestMapping(value = "/split")
	//@RequiresPermissions("SmallSample:add")
	public String splitSample(int id,int isPrint,String params,int taskId) {
		try {
			if(isPrint == 3) {
				ObjectMapper om = new ObjectMapper();
				Map<String, Object> map = new HashMap<String, Object>();
				if (!StringUtils.isEmpty(params)) {
					// 参数处理
					map = om.readValue(params, new TypeReference<Map<String, Object>>() {});
				}
				List<SmallSample> smallSamples =  smallSampleService.findAll(map);
				String smallSampleNums = null;
				for(SmallSample smallSample:smallSamples) {
					if(smallSampleNums == null) {
						smallSampleNums = smallSample.getSmallSampleNum() + ",";
					} else {
						smallSampleNums = smallSampleNums + smallSample.getSmallSampleNum() + ",";
					}
				}
				String ss = smallSampleNums.substring(0, smallSampleNums.length()-1);
				return ss;
			} else{
				Sample sample = sampleService.find(id);
				barnService.saveSmallSample(sample,taskId);
				ObjectMapper om = new ObjectMapper();
				Map<String, Object> map = new HashMap<String, Object>();
				if (!StringUtils.isEmpty(params)) {
					// 参数处理
					map = om.readValue(params, new TypeReference<Map<String, Object>>() {});
				}
				List<SmallSample> smallSamples =  smallSampleService.findAll(map);
				String smallSampleNums = null;
				for(SmallSample smallSample:smallSamples) {
					if(smallSampleNums == null) {
						smallSampleNums = smallSample.getSmallSampleNum() + ",";
					} else {
						smallSampleNums = smallSampleNums + smallSample.getSmallSampleNum() + ",";
					}
				}
				String ss = smallSampleNums.substring(0, smallSampleNums.length()-1);
				return ss;
			}
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

	//导出小麦总表
	@ResponseBody
	@RequestMapping(value = "/ExeclPOI")
	//@RequiresPermissions("sample:edit")
	public String ExeclPOI(HttpServletResponse response,String ids,String title) {
		try {			
			sampleService.ExeclPOI(response,ids,title);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}

	//导出玉米总表
	@RequestMapping("/Export/POI")
	@ResponseBody
	public  String Export(HttpServletResponse response,String ids,String title){
		try {
			//返回结果
			sampleService.Export(response,ids,title);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}

	@ResponseBody
	@RequestMapping(value = "/findSamplesByTask")
	//@RequiresPermissions("sample:edit")
	public List<Sample> findSamplesByTask(String taskName) {		
		return sampleService.findSamplesByTask(taskName);
	}
	

	@ResponseBody
	@RequestMapping(value = "/dataWheatReport")
	//@RequiresPermissions("sample:edit")
	public List<WheatExaminingReport> dataWheatReport(String ids) {
		List<WheatExaminingReport> ws = new ArrayList<WheatExaminingReport>();
		String[] id = ids.split(",");
		for (int i = 0; i < id.length; i++) {
			WheatExaminingReport w = wheatExaminingReportDao.findBasicSituation(Integer.parseInt(id[i]));
			List<WheatExaminingReport> wheats = wheatExaminingReportDao.findQualityAcceptance(Integer.parseInt(id[i]));
			for(int j=1;j< wheats.size(); j++) {
				int newNum = Integer.parseInt(wheats.get(j).getSmallSampleNum().substring(9));
				w.setQualityGrade(wheats.get(j).getQualityGrade());
				w.setRealCapacity(wheats.get(j).getRealCapacity());
				
				if(newNum == 04) {
					w.setShuifen_pingjunzhi(wheats.get(j).getShuifen_pingjunzhi());
				}
				else if(newNum == 01) {
					w.setZazhizongliang_1(wheats.get(j).getZazhizongliang_1());
					w.setKuangwuzhihanliang_pingjunzhi(wheats.get(j).getKuangwuzhihanliang_pingjunzhi());
					w.setBuwanshanlihanliang_pingjunzhi_1(wheats.get(j).getBuwanshanlihanliang_pingjunzhi_1());
				}
				else if(newNum == 05) {
					w.setYingduzhishu_pingjunzhi(wheats.get(j).getYingduzhishu_pingjunzhi());
					w.setSezeqiwei_pingjunzhi(wheats.get(j).getSezeqiwei_pingjunzhi());
				}
				else if(newNum == 06) {
					w.setPingjunzhiganmianjinzhiliang(wheats.get(j).getPingjunzhiganmianjinzhiliang());
				    w.setShimianjin_pingjunzhi(wheats.get(j).getShimianjin_pingjunzhi());
				}
				else if(newNum == 07) {
					w.setPinchangpingfenzhi(wheats.get(j).getPinchangpingfenzhi());
				}
			}
 			ws.add(w);
		}
		return ws;
	}
	@ResponseBody
	@RequestMapping(value = "/dataCornReport")
	//@RequiresPermissions("sample:edit")
	public List<CornExaminingReport> dataCornReport(String ids) {
		List<CornExaminingReport> cs = new ArrayList<CornExaminingReport>();
		String[] id = ids.split(",");
		for (int i = 0; i < id.length; i++) {
			CornExaminingReport c = cornExaminingReportDao.findBasicSituation(Integer.parseInt(id[i]));
			List<CornExaminingReport> corns = cornExaminingReportDao.findQualityAcceptance(Integer.parseInt(id[i]));
			for(int j=1;j < corns.size(); j++) {
				int newNum = Integer.parseInt(corns.get(j).getSmallSampleNum().substring(9));
				c.setQualityGrade(corns.get(j).getQualityGrade());
				c.setRealCapacity(corns.get(j).getRealCapacity());
				if(newNum == 04) {
					c.setShuifen_pingjunzhi(corns.get(j).getShuifen_pingjunzhi());
				}
				else if(newNum == 02) {
					c.setZazhizongliang_1(corns.get(j).getZazhizongliang_1());
				}
				else if(newNum == 01) {
					c.setBuwanshanlihanliang_pingjunzhi_1(corns.get(j).getBuwanshanlihanliang_pingjunzhi_1());
					
				}
				else if(newNum == 03) {
					c.setShengmeilihanliang_pingjunzhi(corns.get(j).getShengmeilihanliang_pingjunzhi());
				}
				else if(newNum == 05) {
					c.setSezeqiwei_pingjunzhi(corns.get(j).getSezeqiwei_pingjunzhi());
				}
				else if(newNum == 06) {
					c.setZhifangsuanzhi_pingjunzhi(corns.get(j).getZhifangsuanzhi_pingjunzhi());
				}
				else if(newNum == 07) {
					c.setPinchangpingfenzhi(corns.get(j).getPinchangpingfenzhi());
				}
			}
 			cs.add(c);
		}
		return cs;
	}
	
	/**
	 * 导出小麦质量
	 */
	@RequestMapping(value = "/ExportXMzhiliang")
	//@RequiresPermissions("sample:edit")
	public String ExportXMzhiliang(HttpServletResponse response,String ids,String title){
		try {
			//返回结果
			sampleService.ExportXMzhiliang(response,ids,title);
			return "{ \"success\" : true }";
		}catch (Exception e) {
			return "{ \"success\" : false }";
		}
	}
	/**
	 * 导出玉米质量
	 */
	@ResponseBody
	@RequestMapping(value = "/ExportYMzhiliang")
	//@RequiresPermissions("sample:edit")
	public String ExportYMzhiliang(HttpServletResponse response,String ids,String title){
		try {
			//返回结果
			sampleService.ExportYMzhiliang(response,ids,title);
			return "{ \"success\" : true }";
		}catch (Exception e) {
			return "{ \"success\" : false }";
		}
	}

	
}

