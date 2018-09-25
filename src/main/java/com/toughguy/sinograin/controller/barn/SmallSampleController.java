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
import com.toughguy.sinograin.model.barn.Buwanshanli;
import com.toughguy.sinograin.model.barn.Cedingjilu;
import com.toughguy.sinograin.model.barn.Mianjinxishuiliang;
import com.toughguy.sinograin.model.barn.Pinchang;
import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.model.barn.Shuifen;
import com.toughguy.sinograin.model.barn.SmallSample;
import com.toughguy.sinograin.model.barn.Yumipinchang;
import com.toughguy.sinograin.model.barn.Zhenjundusu;
import com.toughguy.sinograin.model.barn.Zhifangsuanzhi;
import com.toughguy.sinograin.pagination.PagerModel;
import com.toughguy.sinograin.service.barn.prototype.IBuwanshanliService;
import com.toughguy.sinograin.service.barn.prototype.ICedingjiluService;
import com.toughguy.sinograin.service.barn.prototype.IMianjinxishuiliangService;
import com.toughguy.sinograin.service.barn.prototype.IPinchangService;
import com.toughguy.sinograin.service.barn.prototype.ISampleService;
import com.toughguy.sinograin.service.barn.prototype.IShuifenService;
import com.toughguy.sinograin.service.barn.prototype.ISmallSampleService;
import com.toughguy.sinograin.service.barn.prototype.IYumipinchangService;
import com.toughguy.sinograin.service.barn.prototype.IZhenjundusuService;
import com.toughguy.sinograin.service.barn.prototype.IZhifangsuanzhiService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value = "/smallSample")
public class SmallSampleController {
	
	@Autowired
	private ISmallSampleService smallSampleService;
	@Autowired
	private BuwanshanliController buwanshanliController;
	@Autowired
	private ShuifenController shuifenController;
	@Autowired
	private CedingjiluController cedingjiluController;
	@Autowired
	private ISampleService sampleService;
	@Autowired
	private MianjinxishuiliangController mianjinxishuiliangController;
	@Autowired
	private ZhifangsuanzhiController zhifangsuanzhiController;
	@Autowired
	private MantoupinchangController mantoupinchangController;
	@Autowired
	private YumipinchangController yumipinchangController;
	@Autowired
	private ZhenjundusuController zhenjundusuController;
	@Autowired
	private ICedingjiluService cedingjiluService;
	@Autowired
	private IBuwanshanliService buwanshanliService;
	@Autowired
	private IShuifenService shuifenService;
	@Autowired
	private IMianjinxishuiliangService mianjinxishuiliangService;
	@Autowired
	private IPinchangService pinchangService;
	@Autowired
	private IYumipinchangService yumipinchangService;
	@Autowired
	private IZhenjundusuService zhenjundusuService;
	@Autowired
	private IZhifangsuanzhiService zhifangsuanzhiService;
//	@Autowired
//	private ISmallSampleService smallSampleService;
	
	
	@ResponseBody
	@RequestMapping("/getAll")
	//@RequiresPermissions("SmallSample:all")
	public List<SmallSample> getAll(){
		return smallSampleService.findAll();
	}
	
	@ResponseBody
	@RequestMapping("/get")
	//@RequiresPermissions("SmallSample:getById")
	public SmallSample get(int id){
		return smallSampleService.find(id);
	}
	
	@ResponseBody
	@RequestMapping(value = "/getBySmallSampleNum")
	@RequiresPermissions("sample:getBySmallSampleNum")
	public SmallSample getBySmallSampleNum(String smallSampleNum) {
		SmallSample smallSample =  smallSampleService.findBySmallSampleNum(smallSampleNum);
		if(smallSample.getCheckPoint().equals("1") || smallSample.equals("2") ||smallSample.equals("3")) {
			//不完善
			buwanshanliController.getBySmallSampleId(smallSample.getId());
			return smallSample;
		}else if(smallSample.equals("4")) {
			//水分
			shuifenController.getBySmallSampleId(smallSample.getId());
			return smallSample;
		}else if(smallSample.equals("5")) {
			//硬度
			cedingjiluController.getBySmallSampleId(smallSample.getId());
			return smallSample;
		}else if(smallSample.equals("6")) {
			Sample sample = sampleService.find(smallSample.getSampleId());
			if(sample.getSort().equals("小麦")) {
				//面筋
				mianjinxishuiliangController.getBySmallSampleId(smallSample.getId());
				return smallSample;
			} else {
				//脂肪酸 
				zhifangsuanzhiController.getBySmallSampleId(smallSample.getId());
				return smallSample;
			}
		}else if(smallSample.equals("7")) {
			Sample sample = sampleService.find(smallSample.getSampleId());
			if(sample.getSort().equals("小麦")) {
				//馒头品尝
				mantoupinchangController.getBySmallSampleId(smallSample.getId());
				return smallSample;
			} else {
				//玉米品尝
				yumipinchangController.getBySmallSampleId(smallSample.getId());
				return smallSample;
			}
		}else{
			//真菌毒素
			zhenjundusuController.getBySmallSampleId(smallSample.getId());
			return smallSample;
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/edit")
	//@RequiresPermissions("SmallSample:edit")
	public String edit(SmallSample smallSample) {
		try {
			smallSampleService.update(smallSample);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	@ResponseBody
	@RequestMapping(value = "/save")
	//@RequiresPermissions("SmallSample:save")
	public String save(SmallSample smallSample) {
		try {
			smallSampleService.save(smallSample);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/data")
	//@RequiresPermissions("SmallSample:list")
	public String data(String params) {
		try {
			ObjectMapper om = new ObjectMapper();
			Map<String, Object> map = new HashMap<String, Object>();
			if (!StringUtils.isEmpty(params)) {
				// 参数处理
				map = om.readValue(params, new TypeReference<Map<String, Object>>() {});
			}
			PagerModel<SmallSample> pg = smallSampleService.findPaginated(map);
			
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
	/**
	 * 扫描条形码走的方法
	 * @param smallSampleNum
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/findBySmallSampleNum")
	public String findBySmallSampleNum(String smallSampleNum) {
		SmallSample ss = smallSampleService.findBySmallSampleNum(smallSampleNum);
		int checkItems = Integer.parseInt(smallSampleNum.substring(smallSampleNum.length()-1));
		System.out.println(checkItems);
		String[] checkPoint = ss.getCheckPoint().split(",");
		String checks = "";
		JSONObject ssJson = JSONObject.fromObject(ss);
		checks += ssJson;
		if(checkItems == 1 || checkItems == 2) {
			Cedingjilu cedingjilu = new Cedingjilu();
			Buwanshanli buwanshanli = new Buwanshanli();
			for(String c:checkPoint) {
				if(c.equals("1")) {
					cedingjilu = cedingjiluService.findBySmallSampleId(ss.getId());
				} else if(c.equals("3") || c.equals("4") || c.equals("5") || c.equals("6")) {
					buwanshanli = buwanshanliService.findBySmallSampleId(ss.getId());
				}
			}
			JSONObject cedingjiluJson = JSONObject.fromObject(cedingjilu);
			if(!cedingjiluJson.isEmpty()) {
				checks += cedingjiluJson.toString();
			}
			JSONObject buwanshanliJson = JSONObject.fromObject(buwanshanli);
			if(!buwanshanliJson.isEmpty()) {
			checks += buwanshanliJson.toString();
			}
		} else if(checkItems == 3) {
			System.out.println("sssssss");
			Shuifen shuifen = shuifenService.findBySmallSampleId(ss.getId());
			JSONObject shuifenJson = JSONObject.fromObject(shuifen);
			if(!shuifenJson.isEmpty()) {
				checks += shuifenJson.toString();
			}
		} else if(checkItems == 4) {
			Cedingjilu cedingjilu = cedingjiluService.findBySmallSampleId(ss.getId());
			JSONObject cedingjiluJson = JSONObject.fromObject(cedingjilu);
			if(!cedingjiluJson.isEmpty()) {
				checks += cedingjiluJson.toString();
			}
		} else if(checkItems == 5) {
			Mianjinxishuiliang mianjinxishuiliang = mianjinxishuiliangService.findBySmallSampleId(ss.getId());
			JSONObject mianjinxishuiliangJson = JSONObject.fromObject(mianjinxishuiliang);
			if(!mianjinxishuiliangJson.isEmpty()) {
				checks += mianjinxishuiliangJson.toString();
			}
		} else if(checkItems == 6) {
			Sample s = sampleService.find(ss.getSampleId());
			if(s.getSort().equals("小麦")) {
				Pinchang pinchang = pinchangService.findBySmallSampleId(ss.getId());
				JSONObject pinchangJson = JSONObject.fromObject(pinchang);
				if(!pinchangJson.isEmpty()) {
					checks += pinchangJson.toString();
				}
			} else if(s.getSort().equals("玉米")){
				Yumipinchang yumipinchang = yumipinchangService.findBySmallSampleId(ss.getId());
				JSONObject yumipinchangJson = JSONObject.fromObject(yumipinchang);
				if(!yumipinchangJson.isEmpty()) {
					checks += yumipinchangJson.toString();
				}
			}
		} else if(checkItems == 7) {
			Zhenjundusu zhenjundushu = zhenjundusuService.findBySmallSampleId(ss.getId());
			JSONObject zhenjundushuJson = JSONObject.fromObject(zhenjundushu);
			if(!zhenjundushuJson.isEmpty()) {
				checks += zhenjundushuJson.toString();
			}
		} else if(checkItems == 8) {
			Zhifangsuanzhi zhifangsuanzhi = zhifangsuanzhiService.findBySmallSampleId(ss.getId());
			JSONObject zhifangsuanzhiJson = JSONObject.fromObject(zhifangsuanzhi);
			if(!zhifangsuanzhiJson.isEmpty()) {
				checks += zhifangsuanzhiJson.toString();
			}
		}
		return checks;
	}
	/**
	 * 提交小1表
	 */
	@ResponseBody
	@RequestMapping(value = "/addCheck1")
	public String submitcdjlAndBuwanshanli(Cedingjilu cedingjilu, Buwanshanli buwanshanli,int inspectState,String smallSampleNum,String inspector) {
		try {
			cedingjiluService.save(cedingjilu);
			buwanshanliService.save(buwanshanli);
			if(inspectState == -1) {
				SmallSample ss = smallSampleService.findBySmallSampleNum(smallSampleNum);
				ss.setInspectState(-1);
				ss.setInspector(inspector);
				ss.setCheckOrderApprovalStatus(-1);
				smallSampleService.update(ss);
			} else if(inspectState == 3) {
				SmallSample ss = smallSampleService.findBySmallSampleNum(smallSampleNum);
				ss.setInspectState(3);
				ss.setInspector(inspector);
				ss.setCheckOrderApprovalStatus(-1);
				smallSampleService.update(ss);
			}
			return "{ \"success\" : true }";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
		
	}
	/**
	 * 提交水分表
	 */
	@ResponseBody
	@RequestMapping(value = "/addCheck3")
	public String submitShuifen(Shuifen shuifen,int inspectState,String smallSampleNum,String inspector) {
		try {
			shuifenService.save(shuifen);
			if(inspectState == -1) {
				SmallSample ss = smallSampleService.findBySmallSampleNum(smallSampleNum);
				ss.setInspectState(-1);
				ss.setInspector(inspector);
				ss.setCheckOrderApprovalStatus(-1);
				smallSampleService.update(ss);
			} else if(inspectState == 3) {
				SmallSample ss = smallSampleService.findBySmallSampleNum(smallSampleNum);
				ss.setInspectState(3);
				ss.setInspector(inspector);
				ss.setCheckOrderApprovalStatus(-1);
				smallSampleService.update(ss);
			}
			return "{ \"success\" : true }";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
		
	}
	/**
	 * 提交面筋吸水量表
	 */
	@ResponseBody
	@RequestMapping(value = "/addCheck4")
	public String submitMianjinxishuiliang(Mianjinxishuiliang mianjinxishuiliang,int inspectState,String smallSampleNum,String inspector) {
		try {
			mianjinxishuiliangService.save(mianjinxishuiliang);
			if(inspectState == -1) {
				SmallSample ss = smallSampleService.findBySmallSampleNum(smallSampleNum);
				ss.setInspectState(-1);
				ss.setInspector(inspector);
				ss.setCheckOrderApprovalStatus(-1);
				smallSampleService.update(ss);
			} else if(inspectState == 3) {
				SmallSample ss = smallSampleService.findBySmallSampleNum(smallSampleNum);
				ss.setInspectState(3);
				ss.setInspector(inspector);
				ss.setCheckOrderApprovalStatus(-1);
				smallSampleService.update(ss);
			}
			return "{ \"success\" : true }";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
		
	}
}

