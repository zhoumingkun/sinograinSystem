package com.toughguy.sinograin.controller.barn;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.toughguy.sinograin.dto.XMPresentation;
import com.toughguy.sinograin.dto.YMPresentation;
import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.service.barn.prototype.ISampleService;
import com.toughguy.sinograin.model.barn.TestItem;
import com.toughguy.sinograin.persist.barn.prototype.ITestItemDao;
import com.toughguy.sinograin.service.barn.prototype.ITestItemService;
import com.toughguy.sinograin.util.POIUtils;
import com.toughguy.sinograin.util.UploadUtil;
import com.toughguy.sinograin.util.WordUtils;
import com.toughguy.sinograin.util.XwpfTUtil;

/**
 * 导出word 检验报告
 * @author 
 *
 */
@Controller
@RequestMapping("/export")
public class ExportWord {
	@Autowired
	private ITestItemService testItemService;
	@Autowired
	private ISampleService sampleService;
	/**
     * POI小麦检验报告导出word
     * @throws Exception
     */
     @RequestMapping(value="exportWordXM")
     @RequiresPermissions("export:exportWordXM")
     public void exportWordXM(HttpServletResponse response,String sampleNum) throws Exception {
    	 	Sample s = sampleService.findBySampleNum(sampleNum);
    	 	Map<String, Object> params = replace(s.getId());
            XwpfTUtil xwpfTUtil = new XwpfTUtil();  
            
            XWPFDocument doc;  
            String fileNameInResource = "upload/base/小麦检验报告.docx";
            InputStream is;  
            is = new FileInputStream(fileNameInResource); 
//            is = getClass().getClassLoader().getResourceAsStream(fileNameInResource);      //本身就在编译路径下。。。。
            
            doc = new XWPFDocument(is);  
            
            xwpfTUtil.replaceInPara(doc, params);  
            //替换表格里面的变量  
            xwpfTUtil.replaceInTable(doc, params);  
            OutputStream os = response.getOutputStream();  
       
            response.setContentType("application/vnd.ms-excel");  
            response.setHeader("Content-disposition","attachment;filename="+new String( "小麦检验报告".getBytes("gb2312"), "ISO8859-1" )+".docx");  
      
            doc.write(os);  
      
            xwpfTUtil.close(os);  
            xwpfTUtil.close(is);  
      
            os.flush();  
            os.close();  
        }

	
    /**
     * POI玉米检验报告导出word
     * @throws Exception
     */
    @RequestMapping(value="exportWordYM")
    @RequiresPermissions("export:exportWordYM")
     public void exportWordYM(HttpServletResponse response,String sampleNum) throws Exception {  
    		Sample s = sampleService.findBySampleNum(sampleNum);
    		Map<String, Object> params = replace(s.getId());
    		XwpfTUtil xwpfTUtil = new XwpfTUtil();  
      
            XWPFDocument doc;  
            String fileNameInResource = "upload/base/玉米检验报告.docx";
            InputStream is;  
            is = new FileInputStream(fileNameInResource);  
//            is = getClass().getClassLoader().getResourceAsStream(fileNameInResource);      //本身就在编译路径下。。。。
            
            doc = new XWPFDocument(is);  
            
            xwpfTUtil.replaceInPara(doc, params);  
            //替换表格里面的变量  
            xwpfTUtil.replaceInTable(doc, params);  
            OutputStream os = response.getOutputStream();  
      
            response.setContentType("application/vnd.ms-excel");  
            response.setHeader("Content-disposition","attachment;filename="+new String( "玉米检验报告".getBytes("gb2312"), "ISO8859-1" )+".docx");  
      
            doc.write(os);  
      
            xwpfTUtil.close(os);  
            xwpfTUtil.close(is);  
      
            os.flush();  
            os.close();  
        }  
    
    /**
     * POI样品确认单导出word
     * @throws Exception
     */
     @RequestMapping(value="exportWordTestItem")
     @RequiresPermissions("export:exportWordTestItem")
     public void exportWordTestItem(HttpServletResponse response,int sampleId) throws Exception {  
            Map<String, Object> params = new HashMap<String, Object>();  
            Sample sample = sampleService.find(sampleId);
            params.put("${sampleNum}", "监" + sample.getSampleNum());
            List<TestItem> ts = testItemService.findResult(sampleId);
            for(int i=0; i<ts.size(); i++) {
            	String testItemWord = null;
            	if(1 == ts.get(i).getTestItem()) {
					testItemWord = "容重";
				}else if(2 == ts.get(i).getTestItem()){
					testItemWord = "水分";
				}else if(3 == ts.get(i).getTestItem()){
					testItemWord = "杂质";
				}else if(4 == ts.get(i).getTestItem()){
					testItemWord = "矿物质";
				}else if(5 == ts.get(i).getTestItem()){
					testItemWord = "不完善粒";
				}else if(6 == ts.get(i).getTestItem()){
					testItemWord = "生霉粒";
				}else if(7 == ts.get(i).getTestItem()){
					testItemWord = "色泽气味(质量指标)";
				}else if(8 == ts.get(i).getTestItem()){
					testItemWord = "硬度指数";
				}else if(9 == ts.get(i).getTestItem()){
					testItemWord = "面筋吸水量";
				}else if(10 == ts.get(i).getTestItem()){
					testItemWord = "脂肪酸值";
				}else if(11 == ts.get(i).getTestItem()){
					testItemWord = "品尝评分值";
				}else if(12 == ts.get(i).getTestItem()){
					testItemWord = "色泽气味(储存品质指标)";
				}else if(13 == ts.get(i).getTestItem()){
					testItemWord = "真菌毒素(黄曲霉毒素B1)";
				}else if(14 == ts.get(i).getTestItem()){
					testItemWord = "真菌毒素(脱氧雪腐镰刀菌烯醇)";
				}else if(15 == ts.get(i).getTestItem()){
					testItemWord = "真菌毒素(玉米赤霉烯酮)";
				}else if(16 == ts.get(i).getTestItem()){
					testItemWord = "重金属(铅)";
				}else if(17 == ts.get(i).getTestItem()){
					testItemWord = "重金属(镉)";
				}else if(18 == ts.get(i).getTestItem()){
					testItemWord = "重金属(汞)";
				}else if(19 == ts.get(i).getTestItem()){
					testItemWord = "重金属(砷)";
				}
            	params.put("${checked" + (i+1) + "}", testItemWord);
            	params.put("${result" + (i+1) + "}", ts.get(i).getResult());
            	params.put("${principal" + (i+1) + "}", ts.get(i).getPrincipal());
            }
            try {
				Map<String, Object> sampleNumPic = new HashMap<String, Object>();
				sampleNumPic.put("width", 189);
				sampleNumPic.put("height", 119);
				sampleNumPic.put("type", "png");
				sampleNumPic.put("content", WordUtils.inputStream2ByteArray(new FileInputStream(UploadUtil.getAbsolutePath("barcode") + "/" + sample.getSampleNumPic()), true));
				params.put("${sampleNumPic}", sampleNumPic);
				WordUtils wordutil = new WordUtils();
				List<String[]> testList = new ArrayList<String[]>();
				String path = "upload/base/样品确认单.docx";
				String fileName= new String("样品确认单.docx".getBytes("UTF-8"),"iso-8859-1");    //生成word文件的文件名
				wordutil.getWord(path, params, testList, fileName, response);
            } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
        }
     /**
      * 导出word小麦检测报告替换文字方法
      * @param sampleId
      */
     private Map<String, Object> replace(int sampleId) {
    	 Map<String, Object> params = new HashMap<String, Object>();  
         Sample sample = sampleService.find(sampleId);
         boolean isFuhe = false;
         params.put("${sampleNum}", sample.getSampleNum());
         params.put("${sampleNum1}", "监" + sample.getSampleNum());
         params.put("${pLibraryName}","中央储备粮" + sample.getpLibraryName()+ "直属库");  
         params.put("${sort}", sample.getSort());  
         params.put("${libraryName}", sample.getLibraryName());  
         params.put("${position}",  sample.getPosition());  
         params.put("${gainTime}",  sample.getGainTime());  
         params.put("${quality}",  sample.getQuality());  
         params.put("${amount}",  sample.getAmount());  
         params.put("${autograph}", sample.getAutograph());  
         params.put("${sampleTime}", sample.getSampleTime().toString());  
         params.put("${remark}", sample.getRemark()); 
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
         params.put("${newDate}", sdf.format(new Date()));  
         String checkedWords = "";
         String[] checkeds = sample.getCheckeds().split(",");
         for(int i=0;i<checkeds.length;i++) {
         	if("1".equals(checkeds[i])){
         		checkedWords += "容重,";
				}else if("2".equals(checkeds[i])){
					checkedWords += "水分,";
				}else if("3".equals(checkeds[i])){
					checkedWords += "杂质,";
				}else if("4".equals(checkeds[i])){
					checkedWords += "矿物质,";
				}else if("5".equals(checkeds[i])){
					checkedWords += "不完善粒,";
				}else if("6".equals(checkeds[i])){
					checkedWords += "生霉粒,";
				}else if("7".equals(checkeds[i])){
					checkedWords += "色泽气味(质量指标),";
				}else if("8".equals(checkeds[i])){
					checkedWords += "硬度指数,";
				}else if("9".equals(checkeds[i])){
					checkedWords += "面筋吸水量,";
				}else if("10".equals(checkeds[i])){
					checkedWords += "脂肪酸值,";
				}else if("11".equals(checkeds[i])){
					checkedWords += "品尝评分值,";
				}else if("12".equals(checkeds[i])){
					checkedWords += "色泽气味(储存品质指标),";
				}else if("13".equals(checkeds[i])){
					checkedWords += "真菌毒素(黄曲霉毒素B1),";
				}else if("14".equals(checkeds[i])){
					checkedWords += "真菌毒素(脱氧雪腐镰刀菌烯醇),";
				}else if("15".equals(checkeds[i])){
					checkedWords += "真菌毒素(玉米赤霉烯酮),";
				}else if("16".equals(checkeds[i])){
					checkedWords += "重金属(铅),";
				}else if("17".equals(checkeds[i])){
					checkedWords += "重金属(镉),";
				}else if("18".equals(checkeds[i])){
					checkedWords += "重金属(汞),";
				}else if("19".equals(checkeds[i])){
					checkedWords += "重金属(砷),";
				}
         }
        String substring = checkedWords.substring(0,checkedWords.length()-1);
 		if(sample.getSort().equals("小麦")) {
 			substring = substring.replace("容重,水分,杂质,矿物质,不完善粒,色泽气味(质量指标),硬度指数,面筋吸水量,品尝评分值,色泽气味(储存品质指标),真菌毒素(脱氧雪腐镰刀菌烯醇),重金属(铅),重金属(镉),重金属(汞),重金属(砷)", "全指标项目");
 			substring = substring.replace("容重,水分,杂质,矿物质,不完善粒,色泽气味(质量指标),硬度指数", "质量指标全项目");
 			substring = substring.replace("面筋吸水量,品尝评分值,色泽气味(储存品质指标)", "储存品质指标全项目");
 			substring = substring.replace("真菌毒素(脱氧雪腐镰刀菌烯醇),重金属(铅),重金属(镉),重金属(汞),重金属(砷)", "食品卫生指标全项目");
 		} else {
 			substring = substring.replace("容重,水分,杂质,不完善粒,生霉粒,色泽气味(质量指标),脂肪酸值,品尝评分值,色泽气味(储存品质指标),真菌毒素(黄曲霉毒素B1),真菌毒素(脱氧雪腐镰刀菌烯醇),真菌毒素(玉米赤霉烯酮),重金属(铅),重金属(镉),重金属(汞),重金属(砷)", "全指标项目");
 			substring = substring.replace("容重,水分,杂质,不完善粒,生霉粒,色泽气味(质量指标)", "质量指标全项目");
 			substring = substring.replace("脂肪酸值,品尝评分值,色泽气味(储存品质指标)", "储存品质指标全项目");
 			substring = substring.replace("真菌毒素(黄曲霉毒素B1),真菌毒素(脱氧雪腐镰刀菌烯醇),真菌毒素(玉米赤霉烯酮),重金属(铅),重金属(镉),重金属(汞),重金属(砷)", "食品卫生指标全项目");
 		}
         params.put("${checkeds}", substring); 
    	 List<TestItem> testItems = testItemService.findResult(sampleId);
    	 if(sample.getSort().equals("小麦")) {
    		 int jieguopanding1 = 0;  //面筋吸水量的结果判定   
    		 int jieguopanding2 = 0;  //品尝评分值的结果判定       
    		 for(TestItem t:testItems) {
    	         	if(t.getTestItem() == 1) {
    	         		params.put("${rongzhongjiancejieguo}", t.getResult());  
    	         		int result = Integer.parseInt(t.getResult());
    	         		if(result >= 750) {
    	         			params.put("${rongzhongdanxiangpingjia}", "达标");
    	         			isFuhe = true;
    	         		} else {
    	         			params.put("${rongzhongdanxiangpingjia}", "不达标"); 
    	         			isFuhe = false;
    	         		}
    	         	} else if(t.getTestItem() == 2) {
    	         		params.put("${shuifenjiancejieguo}", t.getResult());  
    	         		Double result = Double.parseDouble(t.getResult());
    	         		if(result <= 12.5) {
    	         			params.put("${shuifendanxiangpingjia}", "达标");
    	         			isFuhe = true;
    	         		} else {
    	         			params.put("${shuifendanxiangpingjia}", "不达标");
    	         			isFuhe = false;
    	         		}
    	         	} else if(t.getTestItem() == 3) {
    	         		params.put("${zazhizongliangjiancejieguo}", t.getResult());  
    	         		Double result = Double.parseDouble(t.getResult());
    	         		if(result <= 1.0) {
    	         			params.put("${zazhizongliangdanxiangpingjia}", "达标");  
    	         			isFuhe = true;
    	         		} else {
    	         			params.put("${zazhizongliangdanxiangpingjia}", "不达标");
    	         			isFuhe = false;
    	         		}
    	         	} else if(t.getTestItem() == 4) {
    	         		params.put("${zazhikuangwuzhijiancejieguo}", t.getResult());  
    	         		Double result = Double.parseDouble(t.getResult());
    	         		if(result <= 0.5) {
    	         			params.put("${zazhikuangwuzhidanxiangpingjia}", "达标");
    	         			isFuhe = true;
    	         		} else {
    	         			params.put("${zazhikuangwuzhidanxiangpingjia}", "不达标");
    	         			isFuhe = false;
    	         		}
    	         	} else if(t.getTestItem() == 5) {
    	         		params.put("${buwanshanlijiancejieguo}", t.getResult());  
    	         		Double result = Double.parseDouble(t.getResult());
    	         		if(result <= 8.0) {
    	         			params.put("${buwanshanlidanxiangpingjia}", "达标");
    	         			isFuhe = true;
    	         		} else {
    	         			params.put("${buwanshanlidanxiangpingjia}", "不达标");
    	         			isFuhe = false;
    	         		}
    	         	} else if(t.getTestItem() == 7) {
    	         		params.put("${sezeqiweijiancejieguo1}", t.getResult());  
    	         		if(t.getResult().equals("正常")) {
    	         			params.put("${sezeqiweidanxiangpingjia}", "达标");
    	         			isFuhe = true;
    	         		} else {
    	         			params.put("${sezeqiweidanxiangpingjia}", "不达标");
    	         			isFuhe = false;
    	         		}
    	         	} else if(t.getTestItem() == 8) {
    	         		params.put("${yingduzhishujiancejieguo}", t.getResult());  
    	         		Double result = Double.parseDouble(t.getResult());
    	         		if(result >= 60) {
    	         			params.put("${yingduzhishudanxiangpingjia}", "硬质小麦");  
    	         		} else if(result > 45 && result < 60){
    	         			params.put("${yingduzhishudanxiangpingjia}", "混合小麦");  
    	         		} else if(result <= 45) {
    	         			params.put("${yingduzhishudanxiangpingjia}", "软质小麦");  
    	         		}
    	         	} else if(t.getTestItem() == 9) {
    	         		params.put("${mianjinxishuijianyanjieguo}", t.getResult());  
    	         		int result = Integer.parseInt(t.getResult());
    	         		if(result >= 180) {
    	         			jieguopanding1 = 1;
    	         		} else if(result < 180){
    	         			jieguopanding1 = 2;
    	         		} else {
    	         			jieguopanding1 = 3;
    	         		}
    	         	} else if(t.getTestItem() == 11) {
    	         		params.put("${pinchangpinfenjianyanjieguo}", t.getResult());  
    	         		int result = Integer.parseInt(t.getResult());
    	         		if(result >= 70) {
    	         			jieguopanding2 = 1;
    	         		} else if(result >= 60 && result < 70){
    	         			jieguopanding2 = 2;
    	         		} else if(result <60) {
    	         			jieguopanding2 = 3;
    	         		}
    	         	} else if(t.getTestItem() == 12) {
    	         		params.put("${sezeqiweijiancejieguo2}", t.getResult());  
    	         	}
    	         	
    	         	if(jieguopanding1 < jieguopanding2) {
    	         		if(jieguopanding2 == 2) {
    	         			params.put("${jieguopanding}", "轻度不宜存");
    	         			isFuhe = false;
    	         		} else if(jieguopanding2 == 3) {
    	         			params.put("${jieguopanding}", "重度不宜存");
    	         			isFuhe = false;
    	         		}
    	         	} else if(jieguopanding1 > jieguopanding2) {
    	         		if(jieguopanding1 == 2) {
    	         			params.put("${jieguopanding}", "轻度不宜存");
    	         			isFuhe = false;
    	         		} else if(jieguopanding1 == 3) {
    	         			params.put("${jieguopanding}", "重度不宜存");
    	         			isFuhe = false;
    	         		}
    	         	} else {
    	         		params.put("${jieguopanding}", "宜存");
    	         		isFuhe = true;
    	         	}
    	         }
    		 if(isFuhe) {
    			 params.put("${isFuhe}", "经检验该仓小麦，符合中央储备粮储存质量要求。");
    		 } else {
    			 params.put("${isFuhe}", "经检验该仓小麦，不符合中央储备粮储存质量要求。");
    		 }
    	 } else if(sample.getSort().equals("玉米")) {
    		 int jieguopanding1 = 0;  //面筋吸水量的结果判定   
    		 int jieguopanding2 = 0;  //品尝评分值的结果判定       
    		 int jieguopanding3 = 0;  //色泽气味的结果判定
    		 for(TestItem t:testItems) {
    	         	if(t.getTestItem() == 1) {
    	         		params.put("${rongzhongjiancejieguo}", t.getResult());  
    	         		int result = Integer.parseInt(t.getResult());
    	         		if(result >= 650) {
    	         			params.put("${rongzhongdanxiangpingjia}", "达标");
    	         			isFuhe = true;
    	         		} else {
    	         			params.put("${rongzhongdanxiangpingjia}", "不达标"); 
    	         			isFuhe = false;
    	         		}
    	         	} else if(t.getTestItem() == 2) {
    	         		params.put("${shuifenjiancejieguo}", t.getResult());  
    	         		Double result = Double.parseDouble(t.getResult());
    	         		if(result <= 14.0) {
    	         			params.put("${shuifendanxiangpingjia}", "达标");
    	         			isFuhe = true;
    	         		} else {
    	         			params.put("${shuifendanxiangpingjia}", "不达标");
    	         			isFuhe = false;
    	         		}
    	         	} else if(t.getTestItem() == 3) {
    	         		params.put("${zazhijiancejieguo}", t.getResult());  
    	         		Double result = Double.parseDouble(t.getResult());
    	         		if(result <= 1.0) {
    	         			params.put("${zazhidanxiangpingjia}", "达标");  
    	         			isFuhe = true;
    	         		} else {
    	         			params.put("${zazhidanxiangpingjia}", "不达标");
    	         			isFuhe = false;
    	         		}
    	         	} else if(t.getTestItem() == 5) {
    	         		params.put("${buwanshanlizongliangjiancejieguo}", t.getResult());  
    	         		Double result = Double.parseDouble(t.getResult());
    	         		if(result <= 8.0) {
    	         			params.put("${buwanshanlizongliangdanxiangpingjia}", "达标");
    	         			isFuhe = true;
    	         		} else {
    	         			params.put("${buwanshanlizongliangdanxiangpingjia}", "不达标");
    	         			isFuhe = false;
    	         		}
    	         	} else if(t.getTestItem() == 6) {
    	         		params.put("${buwanshanlishengmeilijiancejieguo}", t.getResult());  
    	         		Double result = Double.parseDouble(t.getResult());
    	         		if(result <= 2.0) {
    	         			params.put("${buwanshanlishengmeilidanxiangpingjia}", "达标");
    	         			isFuhe = true;
    	         		} else {
    	         			params.put("${buwanshanlishengmeilidanxiangpingjia}", "不达标");
    	         			isFuhe = false;
    	         		}
    	         	} else if(t.getTestItem() == 7) {
    	         		params.put("${sezeqiweijianchejieguo1}", t.getResult());  
    	         		if(t.getResult().equals("正常")) {
    	         			params.put("${sezeqiweidanxiangpingjia}", "达标");
    	         			isFuhe = true;
    	         		} else {
    	         			params.put("${sezeqiweidanxiangpingjia}", "不达标");
    	         			isFuhe = false;
    	         		}
    	         	} else if(t.getTestItem() == 10) {
    	         		params.put("${zhifangsuanzhijianyanjieguo}", t.getResult());  
    	         		int result = Integer.parseInt(t.getResult());
    	         		if(result <= 65) {
    	         			jieguopanding1 = 1;
    	         		} else if(result <= 78){
    	         			jieguopanding1 = 2;
    	         		} else if(result > 78){
    	         			jieguopanding1 = 3;
    	         		}
    	         	} else if(t.getTestItem() == 11) {
    	         		params.put("${pinchangpinfenjianyanjieguo}", t.getResult());  
    	         		int result = Integer.parseInt(t.getResult());
    	         		if(result >= 70) {
    	         			jieguopanding2 = 1;
    	         		} else if(result >= 60){
    	         			jieguopanding2 = 2;
    	         		} else if(result <60) {
    	         			jieguopanding2 = 3;
    	         		}
    	         	} else if(t.getTestItem() == 12) {
    	         		params.put("${sezeqiweijianchejieguo2}", t.getResult());
    	         		if(t.getResult().equals("正常")) {
    	         			jieguopanding3 = 1;
    	         		} else {
    	         			jieguopanding3 = 2;
    	         		}
    	         	}
    	         	
    	         	if(jieguopanding1 < jieguopanding2) {
    	         		if(jieguopanding2 == 2 && jieguopanding3 == 1) {
    	         			params.put("${jieguopanding}", "轻度不宜存");
    	         			isFuhe = false;
    	         		} else if(jieguopanding2 == 3 && jieguopanding3 == 2) {
    	         			params.put("${jieguopanding}", "重度不宜存");
    	         			isFuhe = false;
    	         		}
    	         	} else if(jieguopanding1 > jieguopanding2) {
    	         		if(jieguopanding1 == 2 && jieguopanding3 == 1) {
    	         			params.put("${jieguopanding}", "轻度不宜存");
    	         			isFuhe = false;
    	         		} else if(jieguopanding1 == 3 && jieguopanding3 == 2) {
    	         			params.put("${jieguopanding}", "重度不宜存");
    	         			isFuhe = false;
    	         		}
    	         	} else if(jieguopanding1 != 0 && jieguopanding2 != 0 && jieguopanding3 != 0){
    	         		params.put("${jieguopanding}", "");
    	         		isFuhe = true;
    	         	}
    	         }
    	 }
        	 if(sample.getSort().equals("小麦")) {
        		 if(isFuhe) {
        			 params.put("${isFuhe}", "经检验该仓小麦，符合中央储备粮储存质量要求。");
        		 } else {
        			 params.put("${isFuhe}", "经检验该仓小麦，不符合中央储备粮储存质量要求。");
        		 }
        	 } else {
        		 if(isFuhe) {
        			 params.put("${isFuhe}", "经检验该仓玉米，符合中央储备粮储存质量要求。");
        		 } else {
        			 params.put("${isFuhe}", "经检验该仓玉米，不符合中央储备粮储存质量要求。");
        		 }
        		 
        	 }
         return params;
     }
}
