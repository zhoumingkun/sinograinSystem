package com.toughguy.sinograin.controller.barn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toughguy.sinograin.dto.SummaryCheckDTO;
import com.toughguy.sinograin.model.barn.Buwanshanli;
import com.toughguy.sinograin.model.barn.Cedingjilu;
import com.toughguy.sinograin.model.barn.Mantoupinchang;
import com.toughguy.sinograin.model.barn.Mianjinxishuiliang;
import com.toughguy.sinograin.model.barn.Pinchang;
import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.model.barn.Shuifen;
import com.toughguy.sinograin.model.barn.SmallSample;
import com.toughguy.sinograin.model.barn.Yumipinchang;
import com.toughguy.sinograin.model.barn.Zhenjundusu;
import com.toughguy.sinograin.model.barn.Zhifangsuanzhi;
import com.toughguy.sinograin.persist.barn.prototype.IShuifenDao;
import com.toughguy.sinograin.persist.barn.prototype.IZhifangsuanzhiDao;
import com.toughguy.sinograin.service.barn.prototype.IBuwanshanliService;
import com.toughguy.sinograin.service.barn.prototype.ICedingjiluService;
import com.toughguy.sinograin.service.barn.prototype.IMantoupinchangService;
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
@RequestMapping("/summaryCheck")
public class SummaryCheckController {
	@Autowired
	private ICedingjiluService cedingjiluService;
	@Autowired
	private IBuwanshanliService buwanshanliService;
	@Autowired
	private IShuifenService shuifenService;
	@Autowired
	private IZhenjundusuService zhenjundusuService;
	@Autowired
	private IZhifangsuanzhiService zhifangsuanzhiService;
	@Autowired
	private IYumipinchangService yumipinchangService;
	@Autowired
	private IMianjinxishuiliangService mianjinxishuiliangService;
	@Autowired
	private IMantoupinchangService mantoupinchangService;
	@Autowired
	private ISmallSampleService smallSampleService;
	@Autowired
	private ISampleService sampleService;
	
	@ResponseBody
	@RequestMapping(value = "/findCheckSum")
	public List<SummaryCheckDTO> findCheckSum(String sort) {
		if(sort == null || "".equals(sort)) {
			List<SummaryCheckDTO> s1 = xiaomaiSummaryCheckDTOs();
			List<SummaryCheckDTO> s2 = yumiSummaryCheckDTOs();
			for(SummaryCheckDTO s:s1) {
				s2.add(s);
			}
			return s2;
		} else if(sort.equals("小麦")){
			return xiaomaiSummaryCheckDTOs();
		} else if(sort.equals("玉米")) {
			return yumiSummaryCheckDTOs();
		} else {
			return null;
		}
	}
	@ResponseBody
	@RequestMapping(value = "/agree")
	public String agree(String smallSampleNum,String checkMember) {
		try {
			SmallSample ss = smallSampleService.findBySmallSampleNum(smallSampleNum);
			ss.setCheckOrderApprovalStatus(1);
			ss.setCheckMember(checkMember);
			smallSampleService.update(ss);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/disagree")
	public String disagree(String smallSampleNum,String checkMember,String approveRemark) {
		try {
			SmallSample ss = smallSampleService.findBySmallSampleNum(smallSampleNum);
			ss.setCheckOrderApprovalStatus(2);
			ss.setCheckMember(checkMember);
			ss.setApproveRemark(approveRemark);
			smallSampleService.update(ss);
			return "{ \"success\" : true }";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{ \"success\" : false }";
		}
	}
	
	private List<SummaryCheckDTO> xiaomaiSummaryCheckDTOs() {
		List<SummaryCheckDTO> scds = new ArrayList<SummaryCheckDTO>();
		SummaryCheckDTO scd1 = new SummaryCheckDTO();
		scd1.setCheckName("测定记录");
		scd1.setSort("小麦");
		List<Cedingjilu> cedingjilus = cedingjiluService.findByCheckOrderApprovalStatus("小麦");
		if(cedingjilus != null) {
			scd1.setSum(cedingjilus.size());
		} else {
			scd1.setSum(0);
		}
		scds.add(scd1);
		
		SummaryCheckDTO scd3 = new SummaryCheckDTO();
		scd3.setCheckName("杂质、不完善粒测定记录");
		scd3.setSort("小麦");
		List<Buwanshanli> buwanshanlis = buwanshanliService.findByCheckOrderApprovalStatus("小麦");
		if(buwanshanlis != null) {
			scd3.setSum(buwanshanlis.size());
		} else {
			scd3.setSum(0);
		}
		scds.add(scd3);
		
		SummaryCheckDTO scd5 = new SummaryCheckDTO();
		scd5.setCheckName("水分测定记录");
		scd5.setSort("小麦");
		List<Shuifen> shuifens = shuifenService.findByCheckOrderApprovalStatus("小麦");
		if(shuifens != null) {
			scd5.setSum(shuifens.size());
		} else {
			scd5.setSum(0);
		}
		scds.add(scd5);
		
		SummaryCheckDTO scd7 = new SummaryCheckDTO();
		scd7.setCheckName("真菌毒素检测记录");
		scd7.setSort("小麦");
		List<Zhenjundusu> zhenjundusus = zhenjundusuService.findByCheckOrderApprovalStatus("小麦");
		if(zhenjundusus != null) {
			scd7.setSum(zhenjundusus.size());
		} else {
			scd7.setSum(0);
		}
		scds.add(scd7);
		
		SummaryCheckDTO scd9 = new SummaryCheckDTO();
		scd9.setCheckName("面筋吸水量测定记录");
		scd9.setSort("小麦");
		List<Mianjinxishuiliang> mianjinxishuiliangs = mianjinxishuiliangService.findByCheckOrderApprovalStatus("小麦");
		if(mianjinxishuiliangs != null) {
			scd9.setSum(mianjinxishuiliangs.size());
		} else {
			scd9.setSum(0);
		}
		scds.add(scd9);
		
		SummaryCheckDTO scd10 = new SummaryCheckDTO();
		scd10.setCheckName("馒头品尝评分记录表");
		scd10.setSort("小麦");
		List<Mantoupinchang> mantoupinchangs = mantoupinchangService.findByCheckOrderApprovalStatus("小麦");
		if(mantoupinchangs != null) {
			scd10.setSum(mantoupinchangs.size());
		} else {
			scd10.setSum(0);
		}
		scds.add(scd10);
		return scds;
	}
	private List<SummaryCheckDTO> yumiSummaryCheckDTOs() {
		List<SummaryCheckDTO> scds = new ArrayList<SummaryCheckDTO>();
		
		SummaryCheckDTO scd2 = new SummaryCheckDTO();
		scd2.setCheckName("测定记录");
		scd2.setSort("玉米");
		List<Cedingjilu> cedingjilus = cedingjiluService.findByCheckOrderApprovalStatus("玉米");
		if(cedingjilus != null) {
			scd2.setSum(cedingjilus.size());
		} else {
			scd2.setSum(0);
		}
		scds.add(scd2);

		SummaryCheckDTO scd4 = new SummaryCheckDTO();
		scd4.setCheckName("杂质、不完善粒测定记录");
		scd4.setSort("玉米");
		List<Buwanshanli> buwanshanlis = buwanshanliService.findByCheckOrderApprovalStatus("玉米");
		if(buwanshanlis != null) {
			scd4.setSum(buwanshanlis.size());
		} else {
			scd4.setSum(0);
		}
		scds.add(scd4);
		
		SummaryCheckDTO scd6 = new SummaryCheckDTO();
		scd6.setCheckName("水分测定记录");
		scd6.setSort("玉米");
		List<Shuifen> shuifens = shuifenService.findByCheckOrderApprovalStatus("玉米");
		if(shuifens != null) {
			scd6.setSum(shuifens.size());
		} else {
			scd6.setSum(0);
		}
		scds.add(scd6);
		
		SummaryCheckDTO scd8 = new SummaryCheckDTO();
		scd8.setCheckName("真菌毒素检测记录");
		scd8.setSort("玉米");
		List<Zhenjundusu> zhenjundusus = zhenjundusuService.findByCheckOrderApprovalStatus("玉米");
		if(zhenjundusus != null) {
			scd8.setSum(zhenjundusus.size());
		} else {
			scd8.setSum(0);
		}
		scds.add(scd8);
		
		SummaryCheckDTO scd11 = new SummaryCheckDTO();
		scd11.setCheckName("脂肪酸值测定记录");
		scd11.setSort("玉米");
		List<Zhifangsuanzhi> zhifangsuanzhis = zhifangsuanzhiService.findByCheckOrderApprovalStatus("玉米");
		if(zhifangsuanzhis != null) {
			scd11.setSum(zhifangsuanzhis.size());
		} else {
			scd11.setSum(0);
		}
		scds.add(scd11);
		
		SummaryCheckDTO scd12 = new SummaryCheckDTO();
		scd12.setCheckName("玉米品尝评分记录表");
		scd12.setSort("玉米");
		List<Yumipinchang> yumipinchangs = yumipinchangService.findByCheckOrderApprovalStatus("玉米");
		if(yumipinchangs != null) {
			scd12.setSum(yumipinchangs.size());
		} else {
			scd12.setSum(0);
		}
		scds.add(scd12);
		return scds;
	}
	@ResponseBody
	@RequestMapping(value = "/findCheckAndSample")
	public String findCheckSample(String checkName,String sort) {
		String str = "[";
		if(checkName.equals("测定记录")) {
			List<Cedingjilu> cs = cedingjiluService.findByCheckOrderApprovalStatus(sort);
			if(cs != null) {
				for(Cedingjilu c:cs) {
					SmallSample smallSample = smallSampleService.find(c.getSmallSampleId());
					str += smallSample.toString() + ",";
				}
			}
		} else if(checkName.equals("杂质、不完善粒测定记录")) {
			List<Buwanshanli> bs = buwanshanliService.findByCheckOrderApprovalStatus(sort);
			if(bs != null) {
				for(Buwanshanli b:bs) {
					SmallSample smallSample = smallSampleService.find(b.getSmallSampleId());
					str += smallSample.toString() + ",";
//					JSONObject jo = JSONObject.fromObject(smallSample);
//					if(!jo.isEmpty()) {
//						str += jo.toString();
//					}
				}
			}
		} else if(checkName.equals("水分测定记录")) {
			List<Shuifen> ss = shuifenService.findByCheckOrderApprovalStatus(sort);
			if(ss != null) {
				for(Shuifen s:ss) {
					SmallSample smallSample = smallSampleService.find(s.getSmallSampleId());
					str += smallSample.toString() + ",";
//					JSONObject jo = JSONObject.fromObject(smallSample);
//					if(!jo.isEmpty()) {
//						str += jo.toString();
//					}
				}
			}
		} else if(checkName.equals("真菌毒素检测记录")) {
			List<Zhenjundusu> zs = zhenjundusuService.findByCheckOrderApprovalStatus(sort);
			if(zs != null) {
				for(Zhenjundusu z:zs) {
					SmallSample smallSample = smallSampleService.find(z.getSmallSampleId());
					str += smallSample.toString() + ",";
//					JSONObject jo = JSONObject.fromObject(smallSample);
//					if(!jo.isEmpty()) {
//						str += jo.toString();
//					}
				}
			}
		} else if(checkName.equals("面筋吸水量测定记录")) {
			List<Mianjinxishuiliang> ms = mianjinxishuiliangService.findByCheckOrderApprovalStatus(sort);
			if(ms != null) {
				for(Mianjinxishuiliang m:ms) {
					SmallSample smallSample = smallSampleService.find(m.getSmallSampleId());
					str += smallSample.toString() + ",";
//					JSONObject jo = JSONObject.fromObject(smallSample);
//					if(!jo.isEmpty()) {
//						str += jo.toString();
//					}
				}
			}
		} else if(checkName.equals("馒头品尝评分记录表")) {
			List<Mantoupinchang> ms = mantoupinchangService.findByCheckOrderApprovalStatus(sort);
			if(ms != null) {
				for(Mantoupinchang m:ms) {
					SmallSample smallSample = smallSampleService.find(m.getSmallSampleId());
					str += smallSample.toString() + ",";
//					JSONObject jo = JSONObject.fromObject(smallSample);
//					if(!jo.isEmpty()) {
//						str += jo.toString();
//					}
				}
			}
		} else if(checkName.equals("脂肪酸值测定记录")) {
			List<Zhifangsuanzhi> zfs = zhifangsuanzhiService.findByCheckOrderApprovalStatus(sort);
			if(zfs != null) {
				for(Zhifangsuanzhi zf:zfs) {
					SmallSample smallSample = smallSampleService.find(zf.getSmallSampleId());
					str += smallSample.toString() + ",";
//					JSONObject jo = JSONObject.fromObject(smallSample);
//					if(!jo.isEmpty()) {
//						str += jo.toString();
//					}
				}
			}
		} else if(checkName.equals("玉米品尝评分记录表")) {
			List<Yumipinchang> ys = yumipinchangService.findByCheckOrderApprovalStatus(sort);
			if(ys != null) {
				for(Yumipinchang y:ys) {
					SmallSample smallSample = smallSampleService.find(y.getSmallSampleId());
					str += smallSample.toString() + ",";
//					JSONObject jo = JSONObject.fromObject(smallSample);
//					if(!jo.isEmpty()) {
//						str += jo.toString();
//					}
				}
			}
		}
		return str.substring(0, str.length()-1) + "]";
	}
}
