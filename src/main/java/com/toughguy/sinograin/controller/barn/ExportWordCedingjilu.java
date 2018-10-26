package com.toughguy.sinograin.controller.barn;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.toughguy.sinograin.dto.XMPresentation;
import com.toughguy.sinograin.dto.YMPresentation;
import com.toughguy.sinograin.model.barn.Buwanshanli;
import com.toughguy.sinograin.model.barn.Cedingjilu;
import com.toughguy.sinograin.model.barn.Mantoupinchang;
import com.toughguy.sinograin.model.barn.Mianjinxishuiliang;
import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.model.barn.Shuifen;
import com.toughguy.sinograin.model.barn.SmallSample;
import com.toughguy.sinograin.service.barn.prototype.IBuwanshanliService;
import com.toughguy.sinograin.service.barn.prototype.ICedingjiluService;
import com.toughguy.sinograin.service.barn.prototype.IMantoupinchangService;
import com.toughguy.sinograin.service.barn.prototype.IMianjinxishuiliangService;
import com.toughguy.sinograin.service.barn.prototype.ISampleService;
import com.toughguy.sinograin.service.barn.prototype.IShuifenService;
import com.toughguy.sinograin.service.barn.prototype.ISmallSampleService;
import com.toughguy.sinograin.model.barn.TestItem;
import com.toughguy.sinograin.model.barn.Yumipinchang;
import com.toughguy.sinograin.model.barn.Zhenjundusu;
import com.toughguy.sinograin.model.barn.Zhifangsuanzhi;
import com.toughguy.sinograin.persist.barn.prototype.ITestItemDao;
import com.toughguy.sinograin.service.barn.prototype.ITestItemService;
import com.toughguy.sinograin.service.barn.prototype.IYumipinchangService;
import com.toughguy.sinograin.service.barn.prototype.IZhenjundusuService;
import com.toughguy.sinograin.service.barn.prototype.IZhifangsuanzhiService;
import com.toughguy.sinograin.util.POIUtils;
import com.toughguy.sinograin.util.UploadUtil;
import com.toughguy.sinograin.util.WordUtils;
import com.toughguy.sinograin.util.XwpfTUtil;


/**
 * 导出word 测定记录
 * @author 
 *
 */
@Controller
@RequestMapping("/exportCedingjilu")
public class ExportWordCedingjilu {
	@Autowired
	private ITestItemService testItemService;
	@Autowired
	private ISampleService sampleService;
	@Autowired
	private ICedingjiluService cedingjiluService;
	@Autowired
	private IBuwanshanliService buwanshanliService;
	@Autowired
	private IShuifenService shuifenService;
	@Autowired
	private IMianjinxishuiliangService mianjinxishuiliangService;
	@Autowired
	private IZhifangsuanzhiService zhifangsuanzhiService;
	@Autowired
	private IZhenjundusuService zhenjundusuService;
	@Autowired
	private IMantoupinchangService mantoupinchangService;
	@Autowired
	private IYumipinchangService yumipinchangService;
	@Autowired
	private ISmallSampleService smallSampleService;
	
	/**
     * POI测定记录导出word
     * @throws Exception
     */
     @RequestMapping(value="exportCedingjilu")
//     @RequiresPermissions("exportCedingjilu:exportCedingjilu")
     public void exportCedingjilu(HttpServletResponse response,String smallSampleNum,String sampleNum,String sort) throws Exception {
//    	 	Sample s = sampleService.findBySampleNum(sampleNum);
//    	 	Map<String, Object> params = replace(s.getId());
    	 	
    	 	Map<String, Object> params = new HashMap<String, Object>();  
    	 	SmallSample ss = smallSampleService.findBySmallSampleNum(smallSampleNum);
    	 	Cedingjilu cedingjilu = cedingjiluService.findBySmallSampleId(ss.getId());
       	 
       	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            params.put("${newDate}", sdf.format(new Date()));
       	    params.put("${c_table_version}", cedingjilu.getC_table_version());
            params.put("${c_riqi}", sdf.format(cedingjilu.getC_riqi()));
            params.put("${c_shiwen}",cedingjilu.getC_shiwen());
            params.put("${c_xiangduishidu}",cedingjilu.getC_xiangduishidu());  
            params.put("${c_sampleNum}",sampleNum);  
            params.put("${c_sort}",sort);
            System.out.println(sampleNum);
            System.out.println(sort);
            if(cedingjilu.getC_jiancefangfa().equals("GB")){
           	 params.put("${c_jiancefangfa}", "☑GB              □GB/T");
            }else {
     			 params.put("${c_jiancefangfa}", "□GB     ☑GB/T"); 
     		}
            if(cedingjilu.getC_yiqishebei_mingcheng_1().equals("1")){
           	 params.put("${c_yiqishebei_mingcheng_1}", "☑容重器");
            }else {
     			 params.put("${c_yiqishebei_mingcheng_1}", "□容重器"); 
     		}
            if(cedingjilu.getC_yiqishebei_mingcheng_2().equals("1")){
            	params.put("${c_yiqishebei_mingcheng_2}", "☑硬度仪");
            }else {
            	params.put("${c_yiqishebei_mingcheng_2}", "□硬度仪");
     		}
            if(cedingjilu.getC_yiqishebei_mingcheng_3().equals("1")){
           	 params.put("${c_yiqishebei_mingcheng_3}", "☑筛选器");
            }else {
     			 params.put("${c_yiqishebei_mingcheng_3}", "□筛选器"); 
     		}
            if(cedingjilu.getC_yiqishebei_bianhao_1() != null){
           	 params.put("${c_yiqishebei_bianhao_1}", cedingjilu.getC_yiqishebei_bianhao_1());
            }else if(cedingjilu.getC_yiqishebei_bianhao_1()==null){
     			 params.put("${c_yiqishebei_bianhao_1}", " "); 
     		}
            if(cedingjilu.getC_yiqishebei_bianhao_2() != null){
           	 params.put("${c_yiqishebei_bianhao_2}", cedingjilu.getC_yiqishebei_bianhao_2());
            }else if(cedingjilu.getC_yiqishebei_bianhao_2()==null){
     			 params.put("${c_yiqishebei_bianhao_2}", " "); 
     		}
            if(cedingjilu.getC_yiqishebei_bianhao_3() != null){
           	 params.put("${c_yiqishebei_bianhao_3}", cedingjilu.getC_yiqishebei_bianhao_3());
            }else if(cedingjilu.getC_yiqishebei_bianhao_3()==null){
     			 params.put("${c_yiqishebei_bianhao_3}", " "); 
     		}
            params.put("${rongzhong_1}", cedingjilu.getRongzhong_1());
            params.put("${rongzhong_2}", cedingjilu.getRongzhong_2());
//            params.put("${yingduzhishu_1}", cedingjilu.getYingduzhishu_1());
//            params.put("${yingduzhishu_2}", cedingjilu.getYingduzhishu_2());
            if(cedingjilu.getYingduzhishu_1() != null){
              	 params.put("${yingduzhishu_1}", cedingjilu.getYingduzhishu_1());
               }else if(cedingjilu.getYingduzhishu_1()==null){
        			 params.put("${yingduzhishu_1}", " "); 
        		}
            if(cedingjilu.getYingduzhishu_2() != null){
             	 params.put("${yingduzhishu_2}", cedingjilu.getYingduzhishu_2());
              }else if(cedingjilu.getYingduzhishu_2()==null){
       			 params.put("${yingduzhishu_2}", " "); 
       		}
            params.put("${sezeqiwei_1}", cedingjilu.getSezeqiwei_1());
            params.put("${sezeqiwei_2}", cedingjilu.getSezeqiwei_2());
            params.put("${jiareshiyan_1}", cedingjilu.getJiareshiyan_1());
            params.put("${jiareshiyan_2}", cedingjilu.getJiareshiyan_2());
            params.put("${jiagongjingdu_1}", cedingjilu.getJiagongjingdu_1());
            params.put("${jiagongjingdu_2}", cedingjilu.getJiagongjingdu_2());
            params.put("${pise_1}", cedingjilu.getPise_1());
            params.put("${pise_2}", cedingjilu.getPise_2());
            params.put("${pingjunzhi}", cedingjilu.getPingjunzhi());
            params.put("${c_beizhu}", cedingjilu.getBeizhu());
            params.put("${c_jiance}", cedingjilu.getJiance()); 
            params.put("${c_jiaohe}", cedingjilu.getJiaohe());
            
            SmallSample ss1 = smallSampleService.findBySmallSampleNum(smallSampleNum);
     	 	Buwanshanli buwanshanli = buwanshanliService.findBySmallSampleId(ss1.getId());
       	 
    	    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
//         params.put("${newDate}", sdf.format(new Date()));
    	 params.put("${b_table_version}", buwanshanli.getB_table_version());
         params.put("${b_riqi}", sdf1.format(buwanshanli.getB_riqi()));
         params.put("${b_shiwen}",buwanshanli.getB_shiwen());
         params.put("${b_xiangduishidu}",buwanshanli.getB_xiangduishidu());  
//         params.put("${sampleNum}", buwanshanli.getSampleNum());  
//         params.put("${sort}",  buwanshanli.getSort()); 
         params.put("${sampleNum}",sampleNum);  
         params.put("${sort}",sort);
         
         if(buwanshanli.getB_jiancefangfa().equals("GB/T5494—2008")){
        	 params.put("${b_jiancefangfa}", "☑GB/T5494—2008");
         }else {
  			 params.put("${b_jiancefangfa}", "□GB/T5494—2008"); 
  		}
         if(buwanshanli.getB_yiqishebei_mingcheng_1().equals("1")){
        	 params.put("${b_yiqishebei_mingcheng_1}", "☑分析天平");
         }else {
        	 params.put("${b_yiqishebei_mingcheng_1}", "□分析天平"); 
  		}
         if(buwanshanli.getB_yiqishebei_mingcheng_2().equals("1")){
        	 params.put("${b_yiqishebei_mingcheng_2}", "☑天平");
         }else {
        	 params.put("${b_yiqishebei_mingcheng_2}", "□天平"); 
  		}
         if(buwanshanli.getB_yiqishebei_mingcheng_3().equals("1")){
        	 params.put("${b_yiqishebei_mingcheng_3}", "☑筛选器");
         }else{
  			 params.put("${b_yiqishebei_mingcheng_3}", "□筛选器"); 
  		}
         if(buwanshanli.getB_yiqishebei_bianhao_1() != null){
        	 params.put("${b_yiqishebei_bianhao_1}", buwanshanli.getB_yiqishebei_bianhao_1());
         }else if(buwanshanli.getB_yiqishebei_bianhao_1()==null){
  			 params.put("${b_yiqishebei_bianhao_1}", " "); 
  		}
         if(buwanshanli.getB_yiqishebei_bianhao_2() != null){
        	 params.put("${b_yiqishebei_bianhao_2}", buwanshanli.getB_yiqishebei_bianhao_2());
         }else if(buwanshanli.getB_yiqishebei_bianhao_2()==null){
  			 params.put("${b_yiqishebei_bianhao_2}", " "); 
  		}
         if(buwanshanli.getB_yiqishebei_bianhao_3() != null){
        	 params.put("${b_yiqishebei_bianhao_3}", buwanshanli.getB_yiqishebei_bianhao_3());
         }else if(buwanshanli.getB_yiqishebei_bianhao_3()==null){
  			 params.put("${b_yiqishebei_bianhao_3}", " "); 
  		}
         params.put("${dayangzhiliang_1}", buwanshanli.getDayangzhiliang_1());
         params.put("${dayangzhiliang_2}", buwanshanli.getDayangzhiliang_2());
         params.put("${dayangzazhizhiliang_1}", buwanshanli.getDayangzazhizhiliang_1());
         params.put("${dayangzazhizhiliang_2}", buwanshanli.getDayangzazhizhiliang_2());
         params.put("${dayangzazhihanliang_1}", buwanshanli.getDayangzazhihanliang_1());
         params.put("${dayangzazhihanliang_2}", buwanshanli.getDayangzazhihanliang_2());
         params.put("${dayangzazhihanliang_pingjunzhi}", buwanshanli.getDayangzazhihanliang_pingjunzhi());
         params.put("${xiaoyangzhiliang_1}", buwanshanli.getXiaoyangzhiliang_1());
         params.put("${xiaoyangzhiliang_2}", buwanshanli.getXiaoyangzhiliang_2());
         params.put("${xiaoyangzazhizhiliang_1}", buwanshanli.getXiaoyangzazhizhiliang_1());
         params.put("${xiaoyangzazhizhiliang_2}", buwanshanli.getXiaoyangzazhizhiliang_2());
         params.put("${xiaoyangzazhihanliang_1}", buwanshanli.getXiaoyangzazhihanliang_1());
         params.put("${xiaoyangzazhihanliang_2}", buwanshanli.getXiaoyangzazhihanliang_2());
         params.put("${xiaoyangzazhihanliang_pingjunzhi}", buwanshanli.getXiaoyangzazhihanliang_pingjunzhi());
//         params.put("${kuangwuzhizhiliang_1}", buwanshanli.getKuangwuzhizhiliang_1());
//         params.put("${kuangwuzhizhiliang_2}", buwanshanli.getKuangwuzhizhiliang_2());
//         params.put("${kuangwuzhihanliang_1}", buwanshanli.getKuangwuzhihanliang_1());
//         params.put("${kuangwuzhihanliang_2}", buwanshanli.getKuangwuzhihanliang_2());
         if(buwanshanli.getKuangwuzhizhiliang_1() != null){
        	 params.put("${kuangwuzhizhiliang_1}", buwanshanli.getKuangwuzhizhiliang_1());
         }else if(buwanshanli.getKuangwuzhizhiliang_1()==null){
  			 params.put("${kuangwuzhizhiliang_1}", " "); 
  		}
         if(buwanshanli.getKuangwuzhizhiliang_2() != null){
        	 params.put("${kuangwuzhizhiliang_2}", buwanshanli.getKuangwuzhizhiliang_2());
         }else if(buwanshanli.getKuangwuzhizhiliang_2()==null){
  			 params.put("${kuangwuzhizhiliang_2}", " "); 
  		}
         if(buwanshanli.getKuangwuzhihanliang_1() != null){
        	 params.put("${kuangwuzhihanliang_1}", buwanshanli.getKuangwuzhihanliang_1());
         }else if(buwanshanli.getKuangwuzhihanliang_1()==null){
  			 params.put("${kuangwuzhihanliang_1}", " "); 
  		}
         if(buwanshanli.getKuangwuzhihanliang_2() != null){
        	 params.put("${kuangwuzhihanliang_2}", buwanshanli.getKuangwuzhihanliang_2());
         }else if(buwanshanli.getKuangwuzhihanliang_2()==null){
  			 params.put("${kuangwuzhihanliang_2}", " "); 
  		}
         if(buwanshanli.getKuangwuzhihanliang_pingjunzhi() != null){
        	 params.put("${kuangwuzhihanliang_pingjunzhi}", buwanshanli.getKuangwuzhihanliang_pingjunzhi());
         }else if(buwanshanli.getKuangwuzhihanliang_pingjunzhi()==null){
  			 params.put("${kuangwuzhihanliang_pingjunzhi}", " "); 
  		}
         
//         params.put("${kuangwuzhihanliang_pingjunzhi}", buwanshanli.getKuangwuzhihanliang_pingjunzhi());
         params.put("${zazhizongliang_1}", buwanshanli.getZazhizongliang_1());
         params.put("${buwanshanlizhiliang_1}", buwanshanli.getBuwanshanlizhiliang_1());
         params.put("${buwanshanlizhiliang_2}", buwanshanli.getBuwanshanlizhiliang_2());
         params.put("${buwanshanlihanliang_1}", buwanshanli.getBuwanshanlihanliang_1());
         params.put("${buwanshanlihanliang_2}", buwanshanli.getBuwanshanlihanliang_2());
         params.put("${buwanshanlihanliang_pingjunzhi_1}", buwanshanli.getBuwanshanlihanliang_pingjunzhi_1());
         params.put("${buwanshanlihanliang_pingjunzhi_2}", buwanshanli.getBuwanshanlihanliang_pingjunzhi_2());
//         params.put("${shengmeilizhiliang_1}", buwanshanli.getShengmeilizhiliang_1());
//         params.put("${shengmeilizhiliang_2}", buwanshanli.getShengmeilizhiliang_2());
//         params.put("${shengmeilihanliang_1}", buwanshanli.getShengmeilihanliang_1());
//         params.put("${shengmeilihanliang_2}", buwanshanli.getShengmeilihanliang_2());
//         params.put("${shengmeilihanliang_pingjunzhi}", buwanshanli.getShengmeilihanliang_pingjunzhi());
         if(buwanshanli.getShengmeilizhiliang_1() != null){
        	 params.put("${shengmeilizhiliang_1}", buwanshanli.getShengmeilizhiliang_1());
         }else if(buwanshanli.getShengmeilizhiliang_1()==null){
  			 params.put("${shengmeilizhiliang_1}", " "); 
  		}
         if(buwanshanli.getShengmeilizhiliang_2() != null){
        	 params.put("${shengmeilizhiliang_2}", buwanshanli.getShengmeilizhiliang_2());
         }else if(buwanshanli.getShengmeilizhiliang_2()==null){
  			 params.put("${shengmeilizhiliang_2}", " "); 
  		}
         if(buwanshanli.getShengmeilihanliang_1() != null){
        	 params.put("${shengmeilihanliang_1}", buwanshanli.getShengmeilihanliang_1());
         }else if(buwanshanli.getShengmeilihanliang_1()==null){
  			 params.put("${shengmeilihanliang_1}", " "); 
  		}
         if(buwanshanli.getShengmeilihanliang_2() != null){
        	 params.put("${shengmeilihanliang_2}", buwanshanli.getShengmeilihanliang_2());
         }else if(buwanshanli.getShengmeilihanliang_2()==null){
  			 params.put("${shengmeilihanliang_2}", " "); 
  		}
         if(buwanshanli.getShengmeilihanliang_pingjunzhi() != null){
        	 params.put("${shengmeilihanliang_pingjunzhi}", buwanshanli.getShengmeilihanliang_pingjunzhi());
         }else if(buwanshanli.getShengmeilihanliang_pingjunzhi()==null){
  			 params.put("${shengmeilihanliang_pingjunzhi}", " "); 
  		}
         params.put("${beizhu}", buwanshanli.getBeizhu());
         params.put("${fenyangjiance}", buwanshanli.getFenyangjiance());
         params.put("${buwanshanli_zazhi_jiance}", buwanshanli.getBuwanshanli_zazhi_jiance());
         params.put("${jiaohe}", buwanshanli.getJiaohe());
            XwpfTUtil xwpfTUtil = new XwpfTUtil();  
            
            XWPFDocument doc;  
            String fileNameInResource = "upload/base/测定记录及杂质不完善粒.docx";
            InputStream is;  
            is = new FileInputStream(fileNameInResource); 
//            is = getClass().getClassLoader().getResourceAsStream(fileNameInResource);      //本身就在编译路径下。。。。
            
            doc = new XWPFDocument(is);  
            
            xwpfTUtil.replaceInPara(doc, params);  
            //替换表格里面的变量  
            System.out.println(params.size());
            xwpfTUtil.replaceInTable(doc, params);  
            OutputStream os = response.getOutputStream();  
       
            response.setContentType("application/vnd.ms-excel");  
            response.setHeader("Content-disposition","attachment;filename="+new String( "测定记录及杂质不完善粒".getBytes("gb2312"), "ISO8859-1" )+".docx");  
      
            doc.write(os);  
      
            xwpfTUtil.close(os);  
            xwpfTUtil.close(is);  
      
            os.flush();  
            os.close();  
        }
     
     /**
      * POI杂质不完善粒测定记录导出word
      * @throws Exception
      */
      @RequestMapping(value="exportBWSLCedingjilu")
//      @RequiresPermissions("exportCedingjilu:exportCedingjilu")
      public void exportBWSLCedingjilu(HttpServletResponse response,String smallSampleNum,String sampleNum,String sort) throws Exception {
//     	 	Sample s = sampleService.findBySampleNum(sampleNum);
//     	 	Map<String, Object> params = replace(s.getId());
     	 	
     	 	Map<String, Object> params = new HashMap<String, Object>();  
//        	    Buwanshanli buwanshanli = buwanshanliService.find(id);
     	 	SmallSample ss1 = smallSampleService.findBySmallSampleNum(smallSampleNum);
     	 	Buwanshanli buwanshanli = buwanshanliService.findBySmallSampleId(ss1.getId());
       	 
    	    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
//         params.put("${newDate}", sdf.format(new Date()));
    	 params.put("${b_table_version}", buwanshanli.getB_table_version());
         params.put("${riqi}", sdf1.format(buwanshanli.getB_riqi()));
         params.put("${shiwen}",buwanshanli.getB_shiwen());
         params.put("${xiangduishidu}",buwanshanli.getB_xiangduishidu());  
//         params.put("${sampleNum}", buwanshanli.getSampleNum());  
//         params.put("${sort}",  buwanshanli.getSort()); 
         params.put("${sampleNum}",sampleNum);  
         params.put("${sort}",sort);
         
         if(buwanshanli.getB_jiancefangfa().equals("GB/T5494—2008")){
        	 params.put("${jiancefangfa}", "☑GB/T5494—2008");
         }else {
  			 params.put("${jiancefangfa}", "□GB/T5494—2008"); 
  		}
         if(buwanshanli.getB_yiqishebei_mingcheng_1().equals("1")){
        	 params.put("${yiqishebei_mingcheng_1}", "☑分析天平");
         }else {
  			 params.put("${yiqishebei_mingcheng_1}", "□分析天平"); 
  		}
         if(buwanshanli.getB_yiqishebei_mingcheng_2().equals("1")){
        	 params.put("${yiqishebei_mingcheng_2}", "☑天平");
         }else {
  			 params.put("${yiqishebei_mingcheng_2}", "□天平"); 
  		}
         if(buwanshanli.getB_yiqishebei_mingcheng_3().equals("1")){
        	 params.put("${yiqishebei_mingcheng_3}", "☑筛选器");
         }else{
  			 params.put("${yiqishebei_mingcheng_3}", "□筛选器"); 
  		}
         if(buwanshanli.getB_yiqishebei_bianhao_1() != null){
        	 params.put("${yiqishebei_bianhao_1}", buwanshanli.getB_yiqishebei_bianhao_1());
         }else if(buwanshanli.getB_yiqishebei_bianhao_1()==null){
  			 params.put("${yiqishebei_mingcheng_1}", " "); 
  		}
         if(buwanshanli.getB_yiqishebei_bianhao_2() != null){
        	 params.put("${yiqishebei_bianhao_2}", buwanshanli.getB_yiqishebei_bianhao_2());
         }else if(buwanshanli.getB_yiqishebei_bianhao_2()==null){
  			 params.put("${yiqishebei_bianhao_2}", " "); 
  		}
         if(buwanshanli.getB_yiqishebei_bianhao_3() != null){
        	 params.put("${yiqishebei_bianhao_3}", buwanshanli.getB_yiqishebei_bianhao_3());
         }else if(buwanshanli.getB_yiqishebei_bianhao_3()==null){
  			 params.put("${yiqishebei_mingcheng_3}", " "); 
  		}
         params.put("${dayangzhiliang_1}", buwanshanli.getDayangzhiliang_1());
         params.put("${dayangzhiliang_2}", buwanshanli.getDayangzhiliang_2());
         params.put("${dayangzazhizhiliang_1}", buwanshanli.getDayangzazhizhiliang_1());
         params.put("${dayangzazhizhiliang_2}", buwanshanli.getDayangzazhizhiliang_2());
         params.put("${dayangzazhihanliang_1}", buwanshanli.getDayangzazhihanliang_1());
         params.put("${dayangzazhihanliang_2}", buwanshanli.getDayangzazhihanliang_2());
         params.put("${dayangzazhihanliang_pingjunzhi}", buwanshanli.getDayangzazhihanliang_pingjunzhi());
         params.put("${xiaoyangzhiliang_1}", buwanshanli.getXiaoyangzhiliang_1());
         params.put("${xiaoyangzhiliang_2}", buwanshanli.getXiaoyangzhiliang_2());
         params.put("${xiaoyangzazhizhiliang_1}", buwanshanli.getXiaoyangzazhizhiliang_1());
         params.put("${xiaoyangzazhizhiliang_2}", buwanshanli.getXiaoyangzazhizhiliang_2());
         params.put("${xiaoyangzazhihanliang_1}", buwanshanli.getXiaoyangzazhihanliang_1());
         params.put("${xiaoyangzazhihanliang_2}", buwanshanli.getXiaoyangzazhihanliang_2());
         params.put("${xiaoyangzazhihanliang_pingjunzhi}", buwanshanli.getXiaoyangzazhihanliang_pingjunzhi());
//         params.put("${kuangwuzhizhiliang_1}", buwanshanli.getKuangwuzhizhiliang_1());
//         params.put("${kuangwuzhizhiliang_2}", buwanshanli.getKuangwuzhizhiliang_2());
//         params.put("${kuangwuzhihanliang_1}", buwanshanli.getKuangwuzhihanliang_1());
//         params.put("${kuangwuzhihanliang_2}", buwanshanli.getKuangwuzhihanliang_2());
         if(buwanshanli.getKuangwuzhizhiliang_1() != null){
        	 params.put("${kuangwuzhizhiliang_1}", buwanshanli.getKuangwuzhizhiliang_1());
         }else if(buwanshanli.getKuangwuzhizhiliang_1()==null){
  			 params.put("${kuangwuzhizhiliang_1}", " "); 
  		}
         if(buwanshanli.getKuangwuzhizhiliang_2() != null){
        	 params.put("${kuangwuzhizhiliang_2}", buwanshanli.getKuangwuzhizhiliang_2());
         }else if(buwanshanli.getKuangwuzhizhiliang_2()==null){
  			 params.put("${kuangwuzhizhiliang_2}", " "); 
  		}
         if(buwanshanli.getKuangwuzhihanliang_1() != null){
        	 params.put("${kuangwuzhihanliang_1}", buwanshanli.getKuangwuzhihanliang_1());
         }else if(buwanshanli.getKuangwuzhihanliang_1()==null){
  			 params.put("${kuangwuzhihanliang_1}", " "); 
  		}
         if(buwanshanli.getKuangwuzhihanliang_2() != null){
        	 params.put("${kuangwuzhihanliang_2}", buwanshanli.getKuangwuzhihanliang_2());
         }else if(buwanshanli.getKuangwuzhihanliang_2()==null){
  			 params.put("${kuangwuzhihanliang_2}", " "); 
  		}
         if(buwanshanli.getKuangwuzhihanliang_pingjunzhi() != null){
        	 params.put("${kuangwuzhihanliang_pingjunzhi}", buwanshanli.getKuangwuzhihanliang_pingjunzhi());
         }else if(buwanshanli.getKuangwuzhihanliang_pingjunzhi()==null){
  			 params.put("${kuangwuzhihanliang_pingjunzhi}", " "); 
  		}
         
//         params.put("${kuangwuzhihanliang_pingjunzhi}", buwanshanli.getKuangwuzhihanliang_pingjunzhi());
         params.put("${zazhizongliang_1}", buwanshanli.getZazhizongliang_1());
         params.put("${buwanshanlizhiliang_1}", buwanshanli.getBuwanshanlizhiliang_1());
         params.put("${buwanshanlizhiliang_2}", buwanshanli.getBuwanshanlizhiliang_2());
         params.put("${buwanshanlihanliang_1}", buwanshanli.getBuwanshanlihanliang_1());
         params.put("${buwanshanlihanliang_2}", buwanshanli.getBuwanshanlihanliang_2());
         params.put("${buwanshanlihanliang_pingjunzhi_1}", buwanshanli.getBuwanshanlihanliang_pingjunzhi_1());
         params.put("${buwanshanlihanliang_pingjunzhi_2}", buwanshanli.getBuwanshanlihanliang_pingjunzhi_2());
//         params.put("${shengmeilizhiliang_1}", buwanshanli.getShengmeilizhiliang_1());
//         params.put("${shengmeilizhiliang_2}", buwanshanli.getShengmeilizhiliang_2());
//         params.put("${shengmeilihanliang_1}", buwanshanli.getShengmeilihanliang_1());
//         params.put("${shengmeilihanliang_2}", buwanshanli.getShengmeilihanliang_2());
//         params.put("${shengmeilihanliang_pingjunzhi}", buwanshanli.getShengmeilihanliang_pingjunzhi());
         if(buwanshanli.getShengmeilizhiliang_1() != null){
        	 params.put("${shengmeilizhiliang_1}", buwanshanli.getShengmeilizhiliang_1());
         }else if(buwanshanli.getShengmeilizhiliang_1()==null){
  			 params.put("${shengmeilizhiliang_1}", " "); 
  		}
         if(buwanshanli.getShengmeilizhiliang_2() != null){
        	 params.put("${shengmeilizhiliang_2}", buwanshanli.getShengmeilizhiliang_2());
         }else if(buwanshanli.getShengmeilizhiliang_2()==null){
  			 params.put("${shengmeilizhiliang_2}", " "); 
  		}
         if(buwanshanli.getShengmeilihanliang_1() != null){
        	 params.put("${shengmeilihanliang_1}", buwanshanli.getShengmeilihanliang_1());
         }else if(buwanshanli.getShengmeilihanliang_1()==null){
  			 params.put("${shengmeilihanliang_1}", " "); 
  		}
         if(buwanshanli.getShengmeilihanliang_2() != null){
        	 params.put("${shengmeilihanliang_2}", buwanshanli.getShengmeilihanliang_2());
         }else if(buwanshanli.getShengmeilihanliang_2()==null){
  			 params.put("${shengmeilihanliang_2}", " "); 
  		}
         if(buwanshanli.getShengmeilihanliang_pingjunzhi() != null){
        	 params.put("${shengmeilihanliang_pingjunzhi}", buwanshanli.getShengmeilihanliang_pingjunzhi());
         }else if(buwanshanli.getShengmeilihanliang_pingjunzhi()==null){
  			 params.put("${shengmeilihanliang_pingjunzhi}", " "); 
  		}
         params.put("${beizhu}", buwanshanli.getBeizhu());
         params.put("${fenyangjiance}", buwanshanli.getFenyangjiance());
         params.put("${buwanshanli_zazhi_jiance}", buwanshanli.getBuwanshanli_zazhi_jiance());
         params.put("${jiaohe}", buwanshanli.getJiaohe());
             XwpfTUtil xwpfTUtil = new XwpfTUtil();  
             
             XWPFDocument doc;  
             String fileNameInResource = "upload/base/杂质不完善粒测定记录.docx";
             InputStream is;  
             is = new FileInputStream(fileNameInResource); 
//             is = getClass().getClassLoader().getResourceAsStream(fileNameInResource);      //本身就在编译路径下。。。。
             
             doc = new XWPFDocument(is);  
             
             xwpfTUtil.replaceInPara(doc, params);  
             //替换表格里面的变量  
             xwpfTUtil.replaceInTable(doc, params);  
             OutputStream os = response.getOutputStream();  
        
             response.setContentType("application/vnd.ms-excel");  
             response.setHeader("Content-disposition","attachment;filename="+new String( "杂质不完善粒测定记录".getBytes("gb2312"), "ISO8859-1" )+".docx");  
       
             doc.write(os);  
       
             xwpfTUtil.close(os);  
             xwpfTUtil.close(is);  
       
             os.flush();  
             os.close();  
         }
      /**
       * POI水分测定记录导出word
       * @throws Exception
       */
       @RequestMapping(value="exportSFCedingjilu")
//       @RequiresPermissions("exportCedingjilu:exportCedingjilu")
       public void exportSFCedingjilu(HttpServletResponse response,String smallSampleNum,String sampleNum,String sort) throws Exception {
//      	 	Sample s = sampleService.findBySampleNum(sampleNum);
//      	 	Map<String, Object> params = replace(s.getId());
      	 	
      	 	Map<String, Object> params = new HashMap<String, Object>();
      	 	SmallSample ss = smallSampleService.findBySmallSampleNum(smallSampleNum);
         	Shuifen shuifen = shuifenService.findBySmallSampleId(ss.getId());
         	
         	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//              params.put("${newDate}", sdf.format(new Date()));
              params.put("${s_table_version}", shuifen.getS_table_version());
              params.put("${s_riqi}", sdf.format(shuifen.getS_riqi()));
              params.put("${s_shiwen}",shuifen.getS_shiwen());
              params.put("${s_xiangduishidu}",shuifen.getS_xiangduishidu()); 
              
              params.put("${sampleNum}",sampleNum);  
              params.put("${sort}",sort);
              System.out.println(sampleNum);
           	  System.out.println(sort);
              if(shuifen.getS_jiancefangfa().equals("GB/T5497—1985")){
             	 params.put("${s_jiancefangfa}", "☑GB/T5497—1985     □GB/T5528—");
              }else if(shuifen.getS_jiancefangfa().equals("GB/T5528—")){
       			 params.put("${s_jiancefangfa}", "□GB/T5497—1985                ☑GB/T5528—"); 
       		}
              if(shuifen.getS_yiqishebei_mingcheng_1().equals("1")){
             	 params.put("${s_yiqishebei_mingcheng_1}", "☑分析天平");
              }else {
       			 params.put("${s_yiqishebei_mingcheng_1}", "□分析天平"); 
       		}
              if(shuifen.getS_yiqishebei_mingcheng_2().equals("1")){
             	 params.put("${s_yiqishebei_mingcheng_2}", "☑电热恒热干燥箱");
              }else {
       			 params.put("${s_yiqishebei_mingcheng_2}", "□电热恒热干燥箱"); 
       		}
              if(shuifen.getS_yiqishebei_bianhao_1() != null){
             	 params.put("${s_yiqishebei_bianhao_1}", shuifen.getS_yiqishebei_bianhao_1());
              }else if(shuifen.getS_yiqishebei_bianhao_1()==null){
       			 params.put("${s_yiqishebei_bianhao_1}", " "); 
       		}
              if(shuifen.getS_yiqishebei_bianhao_2() != null){
             	 params.put("${s_yiqishebei_bianhao_2}", shuifen.getS_yiqishebei_bianhao_2());
              }else if(shuifen.getS_yiqishebei_bianhao_2()==null){
       			 params.put("${s_yiqishebei_bianhao_2}", " "); 
       		}
              params.put("${qimin_bianhao_1}", shuifen.getQimin_bianhao_1());
              params.put("${qimin_bianhao_2}", shuifen.getQimin_bianhao_2());
              params.put("${hongqianqiminzhiliang_1}", shuifen.getHongqianqiminzhiliang_1());
              params.put("${hongqianqiminzhiliang_2}", shuifen.getHongqianqiminzhiliang_2());
              params.put("${hongqianqiminzhiliang_3}", shuifen.getHongqianqiminzhiliang_3());
              params.put("${hongqianqiminzhiliang_4}", shuifen.getHongqianqiminzhiliang_4());
              params.put("${shiyangzhiliang_1}", shuifen.getShiyangzhiliang_1());
              params.put("${shiyangzhiliang_2}", shuifen.getShiyangzhiliang_2());
              params.put("${hengzhongqiminjishiyang_hengzhonghouzhiliang_1}", shuifen.getHengzhongqiminjishiyang_hengzhonghouzhiliang_1());
              params.put("${hengzhongqiminjishiyang_hengzhonghouzhiliang_2}", shuifen.getHengzhongqiminjishiyang_hengzhonghouzhiliang_2());
              params.put("${hengzhongqiminjishiyang_hengzhonghouzhiliang_3}", shuifen.getHengzhongqiminjishiyang_hengzhonghouzhiliang_3());
              params.put("${hengzhongqiminjishiyang_hengzhonghouzhiliang_4}", shuifen.getHengzhongqiminjishiyang_hengzhonghouzhiliang_4());
              params.put("${shuifenhanliang_1}", shuifen.getShuifenhanliang_1());
              params.put("${shuifenhanliang_2}", shuifen.getShuifenhanliang_2());
              params.put("${pingjunzhi_1}", shuifen.getPingjunzhi_1());
              params.put("${pingjunzhi_2}", shuifen.getPingjunzhi_2());
              if(shuifen.getPingxingcha_xiangduicha().equals("平行差")){
              	 params.put("${pingxingcha_xiangduicha}", "☑平行差  □相对差（%）");
               }else {
        			 params.put("${pingxingcha_xiangduicha}", "□平行差  ☑相对差（%）"); 
        		}
              params.put("${pingxingcha_xiangduicha_zhi}", shuifen.getPingxingcha_xiangduicha_zhi());
              params.put("${beizhu}", shuifen.getBeizhu());
              params.put("${jiance}", shuifen.getJiance());
              params.put("${jiaohe}", shuifen.getJiaohe());
              XwpfTUtil xwpfTUtil = new XwpfTUtil();  
              
              XWPFDocument doc;  
              String fileNameInResource = "upload/base/水分测定记录.docx";
              InputStream is;  
              is = new FileInputStream(fileNameInResource); 
//              is = getClass().getClassLoader().getResourceAsStream(fileNameInResource);      //本身就在编译路径下。。。。
              
              doc = new XWPFDocument(is);  
              
              xwpfTUtil.replaceInPara(doc, params);  
              //替换表格里面的变量  
              xwpfTUtil.replaceInTable(doc, params);  
              OutputStream os = response.getOutputStream();  
         
              response.setContentType("application/vnd.ms-excel");  
              response.setHeader("Content-disposition","attachment;filename="+new String( "水分测定记录".getBytes("gb2312"), "ISO8859-1" )+".docx");  
        
              doc.write(os);  
        
              xwpfTUtil.close(os);  
              xwpfTUtil.close(is);  
        
              os.flush();  
              os.close();  
          }
       /**
        * POI面筋吸水量测定记录导出word
        * @throws Exception
        */
        @RequestMapping(value="exportMJXSLCedingjilu")
//        @RequiresPermissions("exportCedingjilu:exportCedingjilu")
        public void exportMJXSLCedingjilu(HttpServletResponse response,String smallSampleNum,String sampleNum,String sort) throws Exception {
//       	 	Sample s = sampleService.findBySampleNum(sampleNum);
//       	 	Map<String, Object> params = replace(s.getId());
       	 	
       	 	Map<String, Object> params = new HashMap<String, Object>();  
//          	    Mianjinxishuiliang mianjinxishuiliang = mianjinxishuiliangService.find(id);
          	  SmallSample ss = smallSampleService.findBySmallSampleNum(smallSampleNum);
          	Mianjinxishuiliang mianjinxishuiliang = mianjinxishuiliangService.findBySmallSampleId(ss.getId());
          	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//               params.put("${newDate}", sdf.format(new Date()));
          	   params.put("${m_table_version}", mianjinxishuiliang.getM_table_version());
               params.put("${m_riqi}", sdf.format(mianjinxishuiliang.getM_riqi()));
               params.put("${m_shiwen}",mianjinxishuiliang.getM_shiwen());
               params.put("${m_xiangduishidu}",mianjinxishuiliang.getM_xiangduishidu());  
               params.put("${sampleNum}",sampleNum);  
               params.put("${sort}",sort); 
               
               if(mianjinxishuiliang.getM_jiancefangfa().equals("GB/T5506.2—2008")){
              	 params.put("${jiancefangfa}", "☑GB/T5506.2—2008    □GB/T5506.4—2008");
               }else {
        			 params.put("${jiancefangfa}", "□GB/T5506.2—2008           ☑GB/T5506.4—2008"); 
        		}
               if(mianjinxishuiliang.getM_yiqishebei_mingcheng_1().equals("1")){
              	 params.put("${m_yiqishebei_mingcheng_1}", "☑分析天平");
               }else{
        			 params.put("${m_yiqishebei_mingcheng_1}", "□分析天平"); 
        		}
               if(mianjinxishuiliang.getM_yiqishebei_mingcheng_2().equals("1")){
              	 params.put("${m_yiqishebei_mingcheng_2}", "☑面筋测定仪");
               }else {
        			 params.put("${m_yiqishebei_mingcheng_2}", "□面筋测定仪"); 
        		}
               if(mianjinxishuiliang.getM_yiqishebei_mingcheng_3().equals("1")){
                	 params.put("${m_yiqishebei_mingcheng_3}", "☑旋风磨");
                 }else {
          			 params.put("${m_yiqishebei_mingcheng_3}", "□旋风磨"); 
          		}
               if(mianjinxishuiliang.getM_yiqishebei_bianhao_1() != null){
              	 params.put("${m_yiqishebei_bianhao_1}", mianjinxishuiliang.getM_yiqishebei_bianhao_1());
               }else if(mianjinxishuiliang.getM_yiqishebei_bianhao_1()==null){
        			 params.put("${m_yiqishebei_mingcheng_1}", " "); 
        		}
               if(mianjinxishuiliang.getM_yiqishebei_bianhao_2() != null){
              	 params.put("${m_yiqishebei_bianhao_2}", mianjinxishuiliang.getM_yiqishebei_bianhao_2());
               }else if(mianjinxishuiliang.getM_yiqishebei_bianhao_2()==null){
        			 params.put("${m_yiqishebei_bianhao_2}", " "); 
        		}
               if(mianjinxishuiliang.getM_yiqishebei_bianhao_3() != null){
                	 params.put("${m_yiqishebei_bianhao_3}", mianjinxishuiliang.getM_yiqishebei_bianhao_3());
                 }else if(mianjinxishuiliang.getM_yiqishebei_bianhao_3()==null){
          			 params.put("${m_yiqishebei_bianhao_3}", " "); 
          		}
               params.put("${shiyangzhiliang_1}", mianjinxishuiliang.getShiyangzhiliang_1());
               params.put("${shiyangzhiliang_2}", mianjinxishuiliang.getShiyangzhiliang_2());
               params.put("${shimianjinzhiliang_1}", mianjinxishuiliang.getShimianjinzhiliang_1());
               params.put("${shimianjinzhiliang_2}", mianjinxishuiliang.getShimianjinzhiliang_2());
               params.put("${ganmianjinzhiliang_1}", mianjinxishuiliang.getGanmianjinzhiliang_1());
               params.put("${ganmianjinzhiliang_2}", mianjinxishuiliang.getGanmianjinzhiliang_2());
               params.put("${mianjinxishuiliang_1}", mianjinxishuiliang.getMianjinxishuiliang_1());
               params.put("${mianjinxishuiliang_2}", mianjinxishuiliang.getMianjinxishuiliang_2());
               params.put("${pingjunzhiganmianjinzhiliang}", mianjinxishuiliang.getPingjunzhiganmianjinzhiliang());
               params.put("${beizhu}", mianjinxishuiliang.getBeizhu());
               params.put("${jiance}", mianjinxishuiliang.getJiance());
               params.put("${jiaohe}", mianjinxishuiliang.getJiaohe());
               XwpfTUtil xwpfTUtil = new XwpfTUtil();  
               
               XWPFDocument doc;  
               String fileNameInResource = "upload/base/面筋吸水量测定记录.docx";
               InputStream is;  
               is = new FileInputStream(fileNameInResource); 
//               is = getClass().getClassLoader().getResourceAsStream(fileNameInResource);      //本身就在编译路径下。。。。
               
               doc = new XWPFDocument(is);  
               
               xwpfTUtil.replaceInPara(doc, params);  
               //替换表格里面的变量  
               xwpfTUtil.replaceInTable(doc, params);  
               OutputStream os = response.getOutputStream();  
          
               response.setContentType("application/vnd.ms-excel");  
               response.setHeader("Content-disposition","attachment;filename="+new String( "面筋吸水量测定记录".getBytes("gb2312"), "ISO8859-1" )+".docx");  
         
               doc.write(os);  
         
               xwpfTUtil.close(os);  
               xwpfTUtil.close(is);  
         
               os.flush();  
               os.close();  
           }
        /**
         * POI脂肪酸值测定记录导出word
         * @throws Exception
         */
         @RequestMapping(value="exportZFSZCedingjilu")
//         @RequiresPermissions("exportCedingjilu:exportCedingjilu")
         public void exportZFSZCedingjilu(HttpServletResponse response,String smallSampleNum,String sampleNum,String sort) throws Exception {
//        	 	Sample s = sampleService.findBySampleNum(sampleNum);
//        	 	Map<String, Object> params = replace(s.getId());
        	 	
        	 	Map<String, Object> params = new HashMap<String, Object>();  
//           	    Zhifangsuanzhi zhifangsuanzhi = zhifangsuanzhiService.find(id);
        	 	 SmallSample ss = smallSampleService.findBySmallSampleNum(smallSampleNum);
        	 	Zhifangsuanzhi zhifangsuanzhi = zhifangsuanzhiService.findBySmallSampleId(ss.getId());
           	 
           	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
//                params.put("${newDate}", sdf.format(new Date()));
           	    params.put("${zf_table_version}", zhifangsuanzhi.getZf_table_version());
                params.put("${riqi}", sdf.format(zhifangsuanzhi.getZf_riqi()));
                params.put("${shiwen}",zhifangsuanzhi.getZf_shiwen());
                params.put("${xiangduishidu}",zhifangsuanzhi.getZf_xiangduishidu());  
                params.put("${sampleNum}",sampleNum);  
                params.put("${sort}",sort);
                
                if(zhifangsuanzhi.getZf_jiancefangfa().equals("GB/T20569-2006附录A")){
               	 params.put("${jiancefangfa}", "☑GB/T20569-2006附录A  □GB/T15684—  □GB/T5510—");
                }else if(zhifangsuanzhi.getZf_jiancefangfa().equals("GB/T15684—")){
         			 params.put("${jiancefangfa}", "□GB/T20569-2006附录A       ☑GB/T15684—  □GB/T5510—"); 
         		}else{
         			params.put("${jiancefangfa}", "□GB/T20569-2006附录A   □GB/T15684—     ☑GB/T5510—");
         		}
                if(zhifangsuanzhi.getZf_yiqishebei_mingcheng_1().equals("1")){
               	 params.put("${yiqishebei_mingcheng_1}", "☑分析天平");
                }else {
         			 params.put("${yiqishebei_mingcheng_1}", "□分析天平"); 
         		}
                if(zhifangsuanzhi.getZf_yiqishebei_mingcheng_2().equals("1")){
               	 params.put("${yiqishebei_mingcheng_2}", "☑滴定管");
                }else {
         			 params.put("${yiqishebei_mingcheng_2}", "□滴定管"); 
         		}
                if(zhifangsuanzhi.getZf_yiqishebei_bianhao_1() != null){
               	 params.put("${yiqishebei_bianhao_1}", zhifangsuanzhi.getZf_yiqishebei_bianhao_1());
                }else if(zhifangsuanzhi.getZf_yiqishebei_bianhao_1()==null){
         			 params.put("${yiqishebei_bianhao_1}", " "); 
         		}
                if(zhifangsuanzhi.getZf_yiqishebei_bianhao_2() != null){
               	 params.put("${yiqishebei_bianhao_2}", zhifangsuanzhi.getZf_yiqishebei_bianhao_2());
                }else if(zhifangsuanzhi.getZf_yiqishebei_bianhao_2()==null){
         			 params.put("${yiqishebei_bianhao_2}", " "); 
         		}
                params.put("${shiyangzhiliang_1}", zhifangsuanzhi.getShiyangzhiliang_1());
                params.put("${shiyangzhiliang_2}", zhifangsuanzhi.getShiyangzhiliang_2());
                params.put("${shiyangshuifen}", zhifangsuanzhi.getShiyangshuifen());
                params.put("${koh_rongyenongdu}", zhifangsuanzhi.getKoh_rongyenongdu());
                params.put("${didingzhongdiandushu_1}", zhifangsuanzhi.getDidingzhongdiandushu_1());
                params.put("${didingzhongdiandushu_2}", zhifangsuanzhi.getDidingzhongdiandushu_2());
                params.put("${didingqishidushu_1}", zhifangsuanzhi.getDidingqishidushu_1());
                params.put("${didingqishidushu_2}", zhifangsuanzhi.getDidingqishidushu_2());
                params.put("${koh_rongyeyongliang_1}", zhifangsuanzhi.getKoh_rongyeyongliang_1());
                params.put("${koh_rongyeyongliang_2}", zhifangsuanzhi.getKoh_rongyeyongliang_2());
                params.put("${kongbaishiyan_koh_yongliang}", zhifangsuanzhi.getKongbaishiyan_koh_yongliang());
                params.put("${zhifangsuanzhi_1}", zhifangsuanzhi.getZhifangsuanzhi_1());
                params.put("${zhifangsuanzhi_2}", zhifangsuanzhi.getZhifangsuanzhi_2());
                params.put("${pingjunzhi}", zhifangsuanzhi.getPingjunzhi());
                if(zhifangsuanzhi.getPingxingcha_xiangduicha().equals("平行差")){
                 	 params.put("${pingxingcha_xiangduicha}", "☑平行差  □相对差（%）");
                  }else {
           			 params.put("${pingxingcha_xiangduicha}", "□平行差  ☑相对差（%）"); 
           		}
                params.put("${pingxingcha_xiangduicha_zhi}", zhifangsuanzhi.getPingxingcha_xiangduicha_zhi());
                params.put("${beizhu}", zhifangsuanzhi.getBeizhu());
                params.put("${jiance}", zhifangsuanzhi.getJiance());
                params.put("${jiaohe}", zhifangsuanzhi.getJiaohe());
                XwpfTUtil xwpfTUtil = new XwpfTUtil();  
                
                XWPFDocument doc;  
                String fileNameInResource = "upload/base/脂肪酸值测定记录.docx";
                InputStream is;  
                is = new FileInputStream(fileNameInResource); 
//                is = getClass().getClassLoader().getResourceAsStream(fileNameInResource);      //本身就在编译路径下。。。。
                
                doc = new XWPFDocument(is);  
                
                xwpfTUtil.replaceInPara(doc, params);  
                //替换表格里面的变量  
                xwpfTUtil.replaceInTable(doc, params);  
                OutputStream os = response.getOutputStream();  
           
                response.setContentType("application/vnd.ms-excel");  
                response.setHeader("Content-disposition","attachment;filename="+new String( "脂肪酸值测定记录".getBytes("gb2312"), "ISO8859-1" )+".docx");  
          
                doc.write(os);  
          
                xwpfTUtil.close(os);  
                xwpfTUtil.close(is);  
          
                os.flush();  
                os.close();  
            }
         /**
          * POI真菌毒素测定记录导出word
          * @throws Exception
          */
          @RequestMapping(value="exportZJDSCedingjilu")
//          @RequiresPermissions("exportCedingjilu:exportCedingjilu")
          public void exportZJDSCedingjilu(HttpServletResponse response,String smallSampleNum,String sampleNum,String sort) throws Exception {
//         	 	Sample s = sampleService.findBySampleNum(sampleNum);
//         	 	Map<String, Object> params = replace(s.getId());
         	 	
         	 	Map<String, Object> params = new HashMap<String, Object>();  
//            	    Zhenjundusu zhenjundusu = zhenjundusuService.find(id);
         	 	 SmallSample ss = smallSampleService.findBySmallSampleNum(smallSampleNum);
         	 	Zhenjundusu zhenjundusu = zhenjundusuService.findBySmallSampleId(ss.getId());
            	 
            	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//                 params.put("${newDate}", sdf.format(new Date()));
            	 params.put("${zj_table_version}", zhenjundusu.getZj_table_version());
                 params.put("${riqi}", sdf.format(zhenjundusu.getZj_riqi()));
                 params.put("${shiwen}",zhenjundusu.getZj_shiwen());
                 params.put("${xiangduishidu}",zhenjundusu.getZj_xiangduishidu());  
                 params.put("${sampleNum}",sampleNum);  
                 params.put("${sort}",sort);
                 
                 if(zhenjundusu.getZj_jiancefangfa().equals("LS/T6113-2015")){
                	 params.put("${jiancefangfa}", "☑LS/T6113-2015   □LS/T6111-2015   □LS/T6112-2015   □LS/T6114-2015");
                }else if(zhenjundusu.getZj_jiancefangfa().equals("LS/T6111-2015")){
          			 params.put("${jiancefangfa}", "□LS/T6113-2015        ☑LS/T6111-2015   □LS/T6112-2015   □LS/T6114-2015"); 
          		}else if(zhenjundusu.getZj_jiancefangfa().equals("LS/T6112-2015")){
          			params.put("${jiancefangfa}", "□LS/T6113-2015   □LS/T6111-2015          ☑LS/T6112-2015   □LS/T6114-2015");
          		}else{
          			params.put("${jiancefangfa}", "□LS/T6113-2015   □LS/T6111-2015    □LS/T6112-2015       ☑LS/T6114-2015");
          		}
                 if(zhenjundusu.getZj_yiqishebei_mingcheng_1().equals("1")){
                	 params.put("${yiqishebei_mingcheng_1}", "☑锤式旋风磨");
                }else {
          			 params.put("${yiqishebei_mingcheng_1}", "□锤式旋风磨"); 
          		}
                 if(zhenjundusu.getZj_yiqishebei_mingcheng_2().equals("1")){
                	 params.put("${yiqishebei_mingcheng_2}", "☑真菌毒素快速检测系统");
                 }else{
          			 params.put("${yiqishebei_mingcheng_2}", "□真菌毒素快速检测系统"); 
          		}
                 if(zhenjundusu.getZj_yiqishebei_bianhao_1() != null){
                	 params.put("${yiqishebei_bianhao_1}", zhenjundusu.getZj_yiqishebei_bianhao_1());
                 }else if(zhenjundusu.getZj_yiqishebei_bianhao_1()==null){
          			 params.put("${yiqishebei_bianhao_1}", " "); 
          		}
                 if(zhenjundusu.getZj_yiqishebei_bianhao_2() != null){
                	 params.put("${yiqishebei_bianhao_2}", zhenjundusu.getZj_yiqishebei_bianhao_2());
                 }else if(zhenjundusu.getZj_yiqishebei_bianhao_2()==null){
          			 params.put("${yiqishebei_bianhao_2}", " "); 
          		}
                 params.put("${outudusu_1}", zhenjundusu.getOutudushu_1());
                 params.put("${outudusu_2}", zhenjundusu.getOutudushu_2());
                 params.put("${outudushu_pingjunzhi}", zhenjundusu.getOutudushu_pingjunzhi());
                 params.put("${huangqumeidusu_1}", zhenjundusu.getHuangqumeidusu_1());
                 params.put("${huangqumeidusu_2}", zhenjundusu.getHuangqumeidusu_2());
                 params.put("${huangqumeidusu_pingjunzhi}", zhenjundusu.getHuangqumeidusu_pingjunzhi());
                 params.put("${yumichimeixitong_1}", zhenjundusu.getYumichimeixitong_1());
                 params.put("${yumichimeixitong_2}", zhenjundusu.getYumichimeixitong_2());
                 params.put("${yumichimeixitong_pingjunzhi}", zhenjundusu.getYumichimeixitong_pingjunzhi());
                 params.put("${zhequmeidusu_1}", zhenjundusu.getZhequmeidusu_1());
                 params.put("${zhequmeidusu_2}", zhenjundusu.getZhequmeidusu_2());
                 params.put("${zhequmeidusu_pingjunzhi}", zhenjundusu.getZhequmeidusu_pingjunzhi());
                 params.put("${beizhu}", zhenjundusu.getBeizhu());
                 params.put("${jiance}", zhenjundusu.getJiance());
                 params.put("${jiaohe}", zhenjundusu.getJiaohe());
                 XwpfTUtil xwpfTUtil = new XwpfTUtil();  
                 
                 XWPFDocument doc;  
                 String fileNameInResource = "upload/base/毒素测定原始记录.docx";
                 InputStream is;  
                 is = new FileInputStream(fileNameInResource); 
//                 is = getClass().getClassLoader().getResourceAsStream(fileNameInResource);      //本身就在编译路径下。。。。
                 
                 doc = new XWPFDocument(is);  
                 
                 xwpfTUtil.replaceInPara(doc, params);  
                 //替换表格里面的变量  
                 xwpfTUtil.replaceInTable(doc, params);  
                 OutputStream os = response.getOutputStream();  
            
                 response.setContentType("application/vnd.ms-excel");  
                 response.setHeader("Content-disposition","attachment;filename="+new String( "毒素测定原始记录".getBytes("gb2312"), "ISO8859-1" )+".docx");  
           
                 doc.write(os);  
           
                 xwpfTUtil.close(os);  
                 xwpfTUtil.close(is);  
           
                 os.flush();  
                 os.close();  
             }
          /**
           * POI馒头品尝记录导出word
           * @throws Exception
           */
           @RequestMapping(value="exportMTPCjilu")
//           @RequiresPermissions("exportCedingjilu:exportCedingjilu")
           public void exportMTPCjilu(HttpServletResponse response,String smallSampleNum,String sampleNum,String sort) throws Exception {
//          	 	Sample s = sampleService.findBySampleNum(sampleNum);
//          	 	Map<String, Object> params = replace(s.getId());
          	 	
          	 	Map<String, Object> params = new HashMap<String, Object>();  
//             	    Mantoupinchang mantoupinchang = mantoupinchangService.find(id);
          	 	SmallSample ss = smallSampleService.findBySmallSampleNum(smallSampleNum);
          	 	Mantoupinchang mantoupinchang = mantoupinchangService.findBySmallSampleId(ss.getId());
             	 
             	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//                  params.put("${newDate}", sdf.format(new Date()));
             	  params.put("${table_version}", mantoupinchang.getTable_version());
                  params.put("${riqi}", sdf.format(mantoupinchang.getRiqi()));
                  params.put("${pinpingyuan}",mantoupinchang.getPinpingyuan());
                  params.put("${sampleNum}",sampleNum);  
                  
                  params.put("${birong}", mantoupinchang.getBirong());
                  params.put("${biaomianseze}", mantoupinchang.getBiaomianseze());
                  params.put("${tanxing}", mantoupinchang.getTanxing());
                  params.put("${qiwei}", mantoupinchang.getQiwei());
                  params.put("${shiwei}", mantoupinchang.getShiwei());
                  params.put("${renxing}", mantoupinchang.getRenxing());
                  params.put("${nianxing}", mantoupinchang.getNianxing());
                  params.put("${pinchangpingfenzhi}", mantoupinchang.getPinchangpingfenzhi());
                  XwpfTUtil xwpfTUtil = new XwpfTUtil();  
                  
                  XWPFDocument doc;  
                  String fileNameInResource = "upload/base/馒头品尝.docx";
                  InputStream is;  
                  is = new FileInputStream(fileNameInResource); 
//                  is = getClass().getClassLoader().getResourceAsStream(fileNameInResource);      //本身就在编译路径下。。。。
                  
                  doc = new XWPFDocument(is);  
                  
                  xwpfTUtil.replaceInPara(doc, params);  
                  //替换表格里面的变量  
                  xwpfTUtil.replaceInTable(doc, params);  
                  OutputStream os = response.getOutputStream();  
             
                  response.setContentType("application/vnd.ms-excel");  
                  response.setHeader("Content-disposition","attachment;filename="+new String( "馒头品尝记录".getBytes("gb2312"), "ISO8859-1" )+".docx");  
            
                  doc.write(os);  
            
                  xwpfTUtil.close(os);  
                  xwpfTUtil.close(is);  
            
                  os.flush();  
                  os.close();  
              }
           /**
            * POI玉米品尝记录导出word
            * @throws Exception
            */
            @RequestMapping(value="exportYMPCjilu")
//            @RequiresPermissions("exportCedingjilu:exportCedingjilu")
            public void exportYMPCjilu(HttpServletResponse response,String smallSampleNum,String sampleNum,String sort) throws Exception {
//           	 	Sample s = sampleService.findBySampleNum(sampleNum);
//           	 	Map<String, Object> params = replace(s.getId());
           	 	
           	 	Map<String, Object> params = new HashMap<String, Object>();  
//              	    Yumipinchang yumipinchang = yumipinchangService.find(id);
           	 SmallSample ss = smallSampleService.findBySmallSampleNum(smallSampleNum);
           	Yumipinchang yumipinchang = yumipinchangService.findBySmallSampleId(ss.getId());
              	 
              	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//                   params.put("${newDate}", sdf.format(new Date()));
              	   params.put("${ym_table_version}", yumipinchang.getYm_table_version());
                   params.put("${riqi}", sdf.format(yumipinchang.getYm_riqi()));
                   params.put("${ym_pinpingyuan}",yumipinchang.getYm_pinpingyuan());
                   params.put("${sampleNum}",sampleNum);
                   
                   params.put("${wotouqiwei}", yumipinchang.getWotouqiwei());
                   params.put("${wotouseze}", yumipinchang.getWotouseze());
                   params.put("${waiguanxingzhuang}", yumipinchang.getWaiguanxingzhuang());
                   params.put("${neibuxingzhuang}", yumipinchang.getNeibuxingzhuang());
                   params.put("${ziwei}", yumipinchang.getZiwei());
                   params.put("${pinchangpingfenzhi}", yumipinchang.getPinchangpingfenzhi());
                   XwpfTUtil xwpfTUtil = new XwpfTUtil();  
                   
                   XWPFDocument doc;  
                   String fileNameInResource = "upload/base/玉米品尝.docx";
                   InputStream is;  
                   is = new FileInputStream(fileNameInResource); 
//                   is = getClass().getClassLoader().getResourceAsStream(fileNameInResource);      //本身就在编译路径下。。。。
                   
                   doc = new XWPFDocument(is);  
                   
                   xwpfTUtil.replaceInPara(doc, params);  
                   //替换表格里面的变量  
                   xwpfTUtil.replaceInTable(doc, params);  
                   OutputStream os = response.getOutputStream();  
              
                   response.setContentType("application/vnd.ms-excel");  
                   response.setHeader("Content-disposition","attachment;filename="+new String( "玉米品尝".getBytes("gb2312"), "ISO8859-1" )+".docx");  
             
                   doc.write(os);  
             
                   xwpfTUtil.close(os);  
                   xwpfTUtil.close(is);  
             
                   os.flush();  
                   os.close();  
               }
}
