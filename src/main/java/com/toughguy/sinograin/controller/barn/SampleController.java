package com.toughguy.sinograin.controller.barn;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.toughguy.sinograin.dto.SamplingDTO;
import com.toughguy.sinograin.model.barn.CornExaminingReport;
import com.toughguy.sinograin.model.barn.Library;
import com.toughguy.sinograin.model.barn.Register;
import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.model.barn.SampleNo;
import com.toughguy.sinograin.model.barn.SmallSample;
import com.toughguy.sinograin.model.barn.WarehouseCounter;
import com.toughguy.sinograin.model.barn.WarehouseCounterPlace;
import com.toughguy.sinograin.model.barn.WheatExaminingReport;
import com.toughguy.sinograin.pagination.PagerModel;
import com.toughguy.sinograin.persist.barn.prototype.ICornExaminingReportDao;
import com.toughguy.sinograin.persist.barn.prototype.IWheatExaminingReportDao;
import com.toughguy.sinograin.service.barn.prototype.IBarnService;
import com.toughguy.sinograin.service.barn.prototype.ILibraryService;
import com.toughguy.sinograin.service.barn.prototype.ISampleNoService;
import com.toughguy.sinograin.service.barn.prototype.ISampleService;
import com.toughguy.sinograin.service.barn.prototype.ISmallSampleService;
import com.toughguy.sinograin.service.barn.prototype.IWarehouseCounterPlaceService;
import com.toughguy.sinograin.service.barn.prototype.IWarehouseCounterService;
import com.toughguy.sinograin.util.BarCodeUtil;
import com.toughguy.sinograin.util.JsonUtil;
import com.toughguy.sinograin.util.SamplingUtil;
import com.toughguy.sinograin.util.UploadUtil;

@Controller
@RequestMapping(value = "/sample")
public class SampleController {
	@Autowired
	private ISampleNoService noService;
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
	@Autowired
	private IWarehouseCounterPlaceService wcps;
	@Autowired
	private IWarehouseCounterService wcs;
	@Autowired
	private ILibraryService libraryService;

	@ResponseBody
	@RequestMapping(value = "/getAll")
	// @RequiresPermissions("sample:all")
	public List<Sample> getAll() {
		return sampleService.findAll();
	}

	@ResponseBody
	@RequestMapping(value = "/get")
	@RequiresPermissions("sample:getById")
	public Sample get(int id) {
		Sample s = sampleService.find(id);
		s.setStorage(s.getDepot() + "--" + s.getCounter() + "--" + s.getPlace());
		return s;
	}

	@ResponseBody
	@RequestMapping(value = "/remove")
	// @RequiresPermissions("sample:remove")
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
	@RequiresPermissions("sample:edit")
	public String edit(Sample sample) {
		try {
			Sample sample1 = sampleService.find(sample.getId());
			sample.setPosition(sample1.getPosition());
			if (sample.getSampleState() == 2) {
				String sampleNum = SamplingUtil.sampleNum(sample1.getSort());
				// 生成二维码
				String path = UploadUtil.getAbsolutePath("barcode");
				File f = new File(path); // 无路径则创建
				if (!f.exists()) {
					f.mkdirs();
				}
				String barFileName = BarCodeUtil.rename("png");
				BarCodeUtil.generateFile(sampleNum, path + "/" + barFileName);
				sample.setSampleNumPic(barFileName);
				sample.setSampleNum(sampleNum);
				sample.setSampleState(2);
			}
			wcps.findDepotAndCounterByPlaceId(sample.getPlaceId());
			WarehouseCounterPlace wp =  wcps.find(sample.getPlaceId());
			wp.setIsStorage(2);
			wcps.update(wp);
			WarehouseCounter whc = wcs.find(wp.getpId());
			whc.setWarehouseUseNumber(whc.getWarehouseUseNumber() + 1);
			wcs.update(whc);
			sampleService.update(sample);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}

	@ResponseBody
	@RequestMapping(value = "/getBySampleNo")
	@RequiresPermissions("sample:getBySampleNo")
	public Sample getBySampleNo(String sampleNo) {
		return sampleService.findBySampleNo(sampleNo);
	}

	@ResponseBody
	@RequestMapping(value = "/getBySampleNum")
	@RequiresPermissions("sample:getBySampleNum")
	public Sample getBySampleNum(String sampleNo) {
		return sampleService.findBySampleNum(sampleNo);
	}

	@ResponseBody
	@RequestMapping(value = "/saveOrEditAll")
	// @RequiresPermissions("sample:saveOrEditAll")
	public String saveOrEditAll(Register register, String sample) {
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
	// @RequiresPermissions("sample:save")
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
	@RequiresPermissions("sample:saveAll")
	public String saveSampleAndRegister(Register register, String sample) {
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
	// @RequiresPermissions("sample:split")
	public String splitSample(int id, int isPrint, String params, int taskId) {
		try {
			if (isPrint == 3) {
				ObjectMapper om = new ObjectMapper();
				Map<String, Object> map = new HashMap<String, Object>();
				if (!StringUtils.isEmpty(params)) {
					// 参数处理
					map = om.readValue(params, new TypeReference<Map<String, Object>>() {
					});
				}
				List<SmallSample> smallSamples = smallSampleService.findAll(map);
				String smallSampleNums = null;
				for (SmallSample smallSample : smallSamples) {
					if (smallSampleNums == null) {
						smallSampleNums = smallSample.getSmallSampleNum() + ",";
					} else {
						smallSampleNums = smallSampleNums + smallSample.getSmallSampleNum() + ",";
					}
				}
				String ss = smallSampleNums.substring(0, smallSampleNums.length() - 1);
				return ss;
			} else {
				Sample sample = sampleService.find(id);
				barnService.saveSmallSample(sample, taskId);
				ObjectMapper om = new ObjectMapper();
				Map<String, Object> map = new HashMap<String, Object>();
				if (!StringUtils.isEmpty(params)) {
					// 参数处理
					map = om.readValue(params, new TypeReference<Map<String, Object>>() {
					});
				}
				List<SmallSample> smallSamples = smallSampleService.findAll(map);
				String smallSampleNums = null;
				for (SmallSample smallSample : smallSamples) {
					if (smallSampleNums == null) {
						smallSampleNums = smallSample.getSmallSampleNum() + ",";
					} else {
						smallSampleNums = smallSampleNums + smallSample.getSmallSampleNum() + ",";
					}
				}
				String ss = smallSampleNums.substring(0, smallSampleNums.length() - 1);
				return ss;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}

	@ResponseBody
	@RequestMapping(value = "/data")
	@RequiresPermissions("sample:list")
	public String data(String params) {
		try {
			ObjectMapper om = new ObjectMapper();
			Map<String, Object> map = new HashMap<String, Object>();
			if (!StringUtils.isEmpty(params)) {
				// 参数处理
				map = om.readValue(params, new TypeReference<Map<String, Object>>() {
				});
			}
			PagerModel<Sample> pg = sampleService.findPaginated(map);
			// 序列化查询结果为JSON
			for(Sample p:pg.getData()) {
				p.setStorage(p.getDepot() + "--" + p.getCounter() + "--" + p.getPlace());
			}
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("total", pg.getTotal());
			result.put("rows", pg.getData());
			return om.writeValueAsString(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"total\" : 0, \"rows\" : [] }";
		}
	}
	
	/**
	 * 分页查询临时钎样
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/temporaryData")
	@RequiresPermissions("sample:list")
	public String temporaryData(String params) {
		try {
			ObjectMapper om = new ObjectMapper();
			Map<String, Object> map = new HashMap<String, Object>();
			if (!StringUtils.isEmpty(params)) {
				// 参数处理
				map = om.readValue(params, new TypeReference<Map<String, Object>>() {
				});
			}
			PagerModel<Sample> pg = sampleService.findTemporaryPaginated(map);
			// 序列化查询结果为JSON
			for(Sample p:pg.getData()) {
				p.setStorage(p.getDepot() + "--" + p.getCounter() + "--" + p.getPlace());
			}
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
	@RequiresPermissions("sample:list")
	public String dataMobile(String params) {
		try {
			ObjectMapper om = new ObjectMapper();
			Map<String, Object> map = new HashMap<String, Object>();
			if (!StringUtils.isEmpty(params)) {
				// 参数处理
				map = om.readValue(params, new TypeReference<Map<String, Object>>() {
				});
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

	// 导出小麦总表
	@ResponseBody
	@RequestMapping(value = "/ExeclPOI")
	@RequiresPermissions("sample:reportXMorYM")
	public String ExeclPOI(HttpServletResponse response, String ids, String title) {
		try {
			sampleService.ExeclPOI(response, ids, title);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}

	// 导出玉米总表
	@RequestMapping("/Export/POI")
	@ResponseBody
	@RequiresPermissions("sample:reportXMorYM")
	public String Export(HttpServletResponse response, String ids, String title) {
		try {
			// 返回结果
			sampleService.Export(response, ids, title);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}

	@ResponseBody
	@RequestMapping(value = "/findSamplesByTask")
	// @RequiresPermissions("sample:findSamplesByTask")
	public List<Sample> findSamplesByTask(String taskName) {
		return sampleService.findSamplesByTask(taskName);
	}

	@ResponseBody
	@RequestMapping(value = "/dataWheatReport")
	@RequiresPermissions("sample:dataWheatReport")
	public List<WheatExaminingReport> dataWheatReport(String ids) {
		List<WheatExaminingReport> ws = new ArrayList<WheatExaminingReport>();
		String[] id = ids.split(",");
		List<String> inspectors = new ArrayList<String>();
		List<Date> date = new ArrayList<Date>();
		for (int i = 0; i < id.length; i++) {
			WheatExaminingReport w = wheatExaminingReportDao.findBasicSituation(Integer.parseInt(id[i]));
			List<WheatExaminingReport> wheats = wheatExaminingReportDao.findQualityAcceptance(Integer.parseInt(id[i]));
			for (int j = 0; j < wheats.size(); j++) {
				int newNum = Integer.parseInt(wheats.get(j).getSmallSampleNum().substring(9));
				w.setQualityGrade(wheats.get(j).getQualityGrade());
				w.setRealCapacity(wheats.get(j).getRealCapacity());

				if (newNum == 04) {
					w.setShuifen_pingjunzhi(wheats.get(j).getShuifen_pingjunzhi());
					inspectors.add(wheats.get(j).getSfjiance());
					date.add(wheats.get(j).getSfriqi());
				} else if (newNum == 01) {
					w.setZazhizongliang_1(wheats.get(j).getZazhizongliang_1());
					w.setKuangwuzhihanliang_pingjunzhi(wheats.get(j).getKuangwuzhihanliang_pingjunzhi());
					w.setBuwanshanlihanliang_pingjunzhi_1(wheats.get(j).getBuwanshanlihanliang_pingjunzhi_1());
					if(wheats.get(j).getBwsljiance() != null && wheats.get(j).getBwsljiance().length() != 0) {
						inspectors.add(wheats.get(j).getBwsljiance());
					}
					if(wheats.get(j).getFenyangjiance() != null && wheats.get(j).getFenyangjiance().length() != 0) {
						inspectors.add(wheats.get(j).getFenyangjiance());
					}
					date.add(wheats.get(j).getBwslriqi());
				} else if (newNum == 05) {
					w.setYingduzhishu_pingjunzhi(wheats.get(j).getYingduzhishu_pingjunzhi());
					w.setSezeqiwei_pingjunzhi(wheats.get(j).getSezeqiwei_pingjunzhi());
					inspectors.add(wheats.get(j).getCdjljiance());
					date.add(wheats.get(j).getCdjlriqi());
				} else if (newNum == 06) {
					w.setPingjunzhiganmianjinzhiliang(wheats.get(j).getPingjunzhiganmianjinzhiliang());
					w.setShimianjin_pingjunzhi(wheats.get(j).getShimianjin_pingjunzhi());
					inspectors.add(wheats.get(j).getMjxsljiance());
					date.add(wheats.get(j).getMjxslriqi());
				} else if (newNum == 07) {
					w.setPinchangpingfenzhi(wheats.get(j).getPinchangpingfenzhi());
					inspectors.add(wheats.get(j).getMtpfjiance());
					date.add(wheats.get(j).getMtpfriqi());
				}
			}
			String ins = StringUtils.join(inspectors.toArray(),",");
			w.setInspectors(ins);
			Date newDate = null;
			Calendar c1 = Calendar.getInstance();
			Calendar c2 = Calendar.getInstance();
			for(Date d: date) {
				if(newDate == null) {
					newDate = d;
				}
				c1.setTime(newDate);
				c2.setTime(d);
				int result = c1.compareTo(c2);
				if(result==0) {
					System.out.println("c1相等c2");
				} else if(result<0) {
					newDate = d;
				} else if(result>0) {
					System.out.println("c1大于c2");
				}
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			w.setInspectionTime(sdf.format(newDate));
			ws.add(w);
		}
		return ws;
	}

	@ResponseBody
	@RequestMapping(value = "/dataCornReport")
	// @RequiresPermissions("sample:dataCornReport")
	public List<CornExaminingReport> dataCornReport(String ids) {
		List<CornExaminingReport> cs = new ArrayList<CornExaminingReport>();
		String[] id = ids.split(",");
		List<String> inspectors = new ArrayList<String>();
		List<Date> date = new ArrayList<Date>();
		for (int i = 0; i < id.length; i++) {
			CornExaminingReport c = cornExaminingReportDao.findBasicSituation(Integer.parseInt(id[i]));
			List<CornExaminingReport> corns = cornExaminingReportDao.findQualityAcceptance(Integer.parseInt(id[i]));
			for (int j = 0; j < corns.size(); j++) {
				int newNum = Integer.parseInt(corns.get(j).getSmallSampleNum().substring(9));
				c.setQualityGrade(corns.get(j).getQualityGrade());
				c.setRealCapacity(corns.get(j).getRealCapacity());
				if (newNum == 04) {
					c.setShuifen_pingjunzhi(corns.get(j).getShuifen_pingjunzhi());
					inspectors.add(corns.get(j).getSfjiance());
					date.add(corns.get(j).getSfriqi());
				} else if (newNum == 02) {
					c.setZazhizongliang_1(corns.get(j).getZazhizongliang_1());
					if(corns.get(j).getBwsljiance() != null && corns.get(j).getBwsljiance().length() != 0) {
						inspectors.add(corns.get(j).getBwsljiance());
					}
					if(corns.get(j).getFenyangjiance() != null && corns.get(j).getFenyangjiance().length() != 0) {
						inspectors.add(corns.get(j).getFenyangjiance());
					}
					date.add(corns.get(j).getBwslriqi());
				} else if (newNum == 01) {
					c.setBuwanshanlihanliang_pingjunzhi_1(corns.get(j).getBuwanshanlihanliang_pingjunzhi_1());
					if(corns.get(j).getBwsljiance() != null && corns.get(j).getBwsljiance().length() != 0) {
						inspectors.add(corns.get(j).getBwsljiance());
					}
					if(corns.get(j).getFenyangjiance() != null && corns.get(j).getFenyangjiance().length() != 0) {
						inspectors.add(corns.get(j).getFenyangjiance());
					}
					date.add(corns.get(j).getBwslriqi());
				} else if (newNum == 03) {
					c.setShengmeilihanliang_pingjunzhi(corns.get(j).getShengmeilihanliang_pingjunzhi());
					if(corns.get(j).getBwsljiance() != null && corns.get(j).getBwsljiance().length() != 0) {
						inspectors.add(corns.get(j).getBwsljiance());
					}
					if(corns.get(j).getFenyangjiance() != null && corns.get(j).getFenyangjiance().length() != 0) {
						inspectors.add(corns.get(j).getFenyangjiance());
					}
					date.add(corns.get(j).getBwslriqi());
				} else if (newNum == 05) {
					c.setSezeqiwei_pingjunzhi(corns.get(j).getSezeqiwei_pingjunzhi());
					inspectors.add(corns.get(j).getCdjljiance());
					date.add(corns.get(j).getCdjlriqi());
				} else if (newNum == 06) {
					c.setZhifangsuanzhi_pingjunzhi(corns.get(j).getZhifangsuanzhi_pingjunzhi());
					inspectors.add(corns.get(j).getZfsjiance());
					date.add(corns.get(j).getZfsriqi());
				} else if (newNum == 07) {
					c.setPinchangpingfenzhi(corns.get(j).getPinchangpingfenzhi());
					inspectors.add(corns.get(j).getYmpfjiance());
					date.add(corns.get(j).getYmpfriqi());
				}
			}
			String ins = StringUtils.join(inspectors.toArray(),",");
			c.setInspectors(ins);
			Date newDate = null;
			Calendar c1 = Calendar.getInstance();
			Calendar c2 = Calendar.getInstance();
			for(Date d: date) {
				if(newDate == null) {
					newDate = d;
				}
				c1.setTime(newDate);
				c2.setTime(d);
				int result = c1.compareTo(c2);
				if(result==0) {
					System.out.println("c1相等c2");
				} else if(result<0) {
					newDate = d;
				} else if(result>0) {
					System.out.println("c1大于c2");
				}
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			c.setInspectionTime(sdf.format(newDate));
			cs.add(c);
			
		}
		return cs;
	}

	/**
	 * 导出小麦质量
	 */
	@ResponseBody
	@RequestMapping(value = "/ExportXMzhiliang")
	@RequiresPermissions("sample:ExportXMorYMzhiliang")
	public String ExportXMzhiliang(HttpServletResponse response, String ids, String title) {
		try {
			// 返回结果
			sampleService.ExportXMzhiliang(response, ids, title);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			return "{ \"success\" : false }";
		}
	}

	/**
	 * 导出玉米质量
	 */
	@ResponseBody
	@RequestMapping(value = "/ExportYMzhiliang")
	@RequiresPermissions("sample:ExportXMorYMzhiliang")
	public String ExportYMzhiliang(HttpServletResponse response, String ids, String title) {
		try {
			// 返回结果
			sampleService.ExportYMzhiliang(response, ids, title);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			return "{ \"success\" : false }";
		}
	}

	/**
	 * 查询平台所有小麦玉米食用油库存总量
	 */
	@ResponseBody
	@RequestMapping(value = "/getAllCereals")
	public Map findAllCereals() {
			Sample sample = sampleService.findAllCereals();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("XMNumber", sample.getXMNumber());
			map.put("YMNumber", sample.getYMNumber());
			map.put("SYYNumber", sample.getSYYNumber());
			return map;
	}
	
	/**
	 * 根据样品柜id查询所有样品
	 */
	@ResponseBody
	@RequestMapping(value = "/getByCounterId")
	public List<Sample> findByCounterId(String params) {
		try {
			ObjectMapper om = new ObjectMapper();
			Map<String, Object> map = new HashMap<String, Object>();
			if (!StringUtils.isEmpty(params)) {
				// 参数处理
				map = om.readValue(params, new TypeReference<Map<String, Object>>() {
				});
			}
			List<Sample> ss = sampleService.findByCounterId(map);
			for(Sample s:ss) {
				s.setStorage(s.getDepot() + "--" + s.getCounter() + "--" + s.getPlace());
			}
			return ss;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 非正常流程扦来的样品
	 * @param sample register
	 * @return sample
	 */
	@ResponseBody
	@RequestMapping(value = "/saveRuku")
	public Sample saveRuku(Register register,Sample sample) {
		try {
			if(sample.getOtherState() == 1) {  
                String sort=sample.getSort();
					if("小麦".equals(sample.getSort())){
						sort = "01";
					}else if("玉米".equals(sample.getSort())){
						sort = "02";
					}else if("食用油".equals(sample.getSort())){
						sort = "03";
					}else {
						sort = "04";
					}
				Library library = libraryService.find(sample.getLibraryId());
				String PlibraryId = String.format("%03d", library.getpLibraryId());
				Map<String,Object > map = new  HashMap<String,Object>();
				map.put("prefix", 60+PlibraryId+sort);
				System.out.println(PlibraryId);
				System.out.println(sort);
				SampleNo no = noService.findAll(map).get(0);
				int num = 0;
				if(no.getNum()%1000 == 999){
					num = no.getNum()+2;
				}else{
					num = no.getNum()+1;
				}
				no.setNum(num);
				noService.update(no);
				String SampleNo = SamplingUtil.sampleNo(library.getpLibraryId(), sort,num%1000);  //扦样编号
				System.out.println(SampleNo + "sampleNo");
				sample.setSampleNo(SampleNo);
//				String sampleNum = SamplingUtil.sampleNum(sample.getSort());  //检验编号
//				sample.setSampleNum(sampleNum);
				sample.setSampleState(2);   // 非正常流程 扦样状态默认为已入库
				sample.setTemporaryLibraryId(sample.getLibraryId());
				sampleService.saveRuku(sample);
			}
			return sample;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 正常入库
	 */
	@ResponseBody
	@RequestMapping(value = "/saveRukuXinxi")
	public String saveRukuXinxi(Sample sample) {
		try {			
			//1，生成检验编号与二维码
			Sample newSample = sampleService.find(sample.getId());
			String sampleNum = SamplingUtil.sampleNum(newSample.getSort());
			// 生成二维码
			String path = UploadUtil.getAbsolutePath("barcode");
			File f = new File(path); // 无路径则创建
			if (!f.exists()) {
				f.mkdirs();
			}
			String barFileName = BarCodeUtil.rename("png");
			BarCodeUtil.generateFile(sampleNum, path + "/" + barFileName);
			//2，修改检验编号，二维码路径，状态，库房管理员
			newSample.setSampleNumPic(barFileName);
			newSample.setSampleNum(sampleNum);
			newSample.setSampleState(2);  //状态为已入库
			newSample.setAutograph(sample.getAutograph());
			//3，根据前台传来的柜位置id查出位置，将其状态改为已存放
			WarehouseCounterPlace wp =  wcps.find(sample.getPlaceId());
			wp.setIsStorage(2);
			wcps.update(wp);
			//4，根据柜位置查出柜id，将库房使用数+1
			WarehouseCounter whc = wcs.find(wp.getpId());
			whc.setWarehouseUseNumber(whc.getWarehouseUseNumber() + 1);
			wcs.update(whc);
			//5，修改样品中存放位置的id
			newSample.setPlaceId(sample.getPlaceId());
			//6，修改入库时间为当前时间
			Date d = new Date();
			newSample.setStorageTime(new java.sql.Date(d.getTime()));
			System.out.println(newSample.getStorageTime());
			sampleService.update(newSample);
			return "{ \"success\" : true,\"sampleNum\":"+ newSample.getSampleNum() +" }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
 	/**
	 * 导出样品登记薄
	 * @param response
	 * @param sampleNos  扦样编号集
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/ExportRegister")
	@RequiresPermissions("sample:ExportRegister")
	public String ExportRegister(HttpServletResponse response, String storageTime) {
		try {
			// 返回结果
			sampleService.ExportRegister(response, storageTime);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			return "{ \"success\" : false }";
		}
	}
	
	/**
	 * 转移入库柜
	 */
	@ResponseBody
	@RequestMapping(value = "/editPlace")
	@RequiresPermissions("sample:editPlace")
	public String editPlace(Sample sample,int oldPlaceId) {
		try {
			WarehouseCounterPlace place = wcps.find(oldPlaceId);
			place.setIsStorage(1);
			wcps.update(place);
			WarehouseCounter whc = wcs.find(place.getpId());
			whc.setWarehouseUseNumber(whc.getWarehouseUseNumber() - 1);
			wcs.update(whc);
			WarehouseCounterPlace place2 = wcps.find(sample.getPlaceId());
			place2.setIsStorage(2);
			wcps.update(place2);
			WarehouseCounter whc2 = wcs.find(place2.getpId());
			whc2.setWarehouseUseNumber(whc2.getWarehouseUseNumber() + 1);
			wcs.update(whc2);
			sampleService.update(sample);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}

	/**
	 * 处理入库柜
	 */
	@ResponseBody
	@RequestMapping(value = "/dispose")
	@RequiresPermissions("sample:dispose")
	public String dispose(Sample sample) {
		try {
			String str_ids = sample.getIds();
			String[] idss = str_ids.split(",");
			int[] int_ids = new int[idss.length];
			for(int i=0;i<idss.length;i++) {
				int_ids[i] = Integer.parseInt(idss[i]);
				Sample s = sampleService.find(int_ids[i]);
				WarehouseCounterPlace place = wcps.find(s.getPlaceId());
				place.setIsStorage(1);
				wcps.update(place);
				WarehouseCounter whc = wcs.find(place.getpId());
				whc.setWarehouseUseNumber(whc.getWarehouseUseNumber() - 1);
				wcs.update(whc);
			}
			sampleService.updateDispose(sample);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	/**
	 * 移动端扦样
	 * @param sample
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/standSample")
	public String standSample(Sample sample) {
		try {
			Sample s = sampleService.find(sample.getId());
			System.out.println(s);
			Date d = new Date();
			s.setSampleTime(new java.sql.Date(d.getTime()));
			//扦样编号的生成
			int libraryId = s.getLibraryId();
			Library l = libraryService.find(libraryId);
			String PlibraryId = String.format("%03d", l.getpLibraryId());
			 String sort=s.getSort();
				if("小麦".equals(s.getSort())){
					sort = "01";
				}else if("玉米".equals(s.getSort())){
					sort = "02";
				}else if("食用油".equals(s.getSort())){
					sort = "03";
				}else {
					sort = "04";
				}
			Map<String,Object > map = new  HashMap<String,Object>();
			map.put("prefix", 60+PlibraryId+sort);
			SampleNo no = noService.findAll(map).get(0);
			int num = 0;
			if(no.getNum()%1000 == 999){
				num = no.getNum()+2;
			}else{
				num = no.getNum()+1;
			}
			no.setNum(num);
			noService.update(no);
			String sampleNo = SamplingUtil.sampleNo(l.getpLibraryId(), sort,num%1000);  //扦样编号
			s.setSampleNo(sampleNo);
			String path = UploadUtil.getAbsolutePath("barcode");
			File f = new File(path); // 无路径则创建
			if (!f.exists()) {
				f.mkdirs();
			}
			String barFileName = BarCodeUtil.rename("png");
			BarCodeUtil.generateFile(sampleNo, path + "/" + barFileName);
			s.setSamplePic(barFileName);
			String pLibraryName = libraryService.find(l.getpLibraryId()).getLibraryName();
			String sampleWord = pLibraryName + "-" + s.getSort() + "-" + String.format("%03d", num%1000);
			s.setSampleWord(sampleWord);
			s.setSampleState(1);
			s.setAutograph(sample.getAutograph());
			sampleService.update(s);
			return "{ \"success\" : true ,\"sampleNo\":"+ sampleNo +"}";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	/**
	 * 将样品放入任务中
	 */
	@ResponseBody
	@RequestMapping(value = "/putIntoTask")
	public String putIntoTask(Sample sample) {
		System.out.println(sample.getIds());
		System.out.println(sample.getTaskId());
		try {
			String str_ids = sample.getIds();
			String[] idss = str_ids.split(",");
			int[] int_ids = new int[idss.length];
			for(int i=0;i<idss.length;i++) {
				int_ids[i] = Integer.parseInt(idss[i]);
				Sample s = sampleService.find(int_ids[i]);
				s.setTaskId(sample.getTaskId());
				sampleService.update(s);
			}
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	
	
	@ResponseBody
	@RequestMapping(value = "/getByTaskId")
	public List<Sample> getByTaskId(int taskId) {
		return sampleService.findByTaskId(taskId);
	}
}
