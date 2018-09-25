package com.toughguy.sinograin.service.barn.impl;

import static org.mockito.Matchers.intThat;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toughguy.sinograin.dto.SamplingDTO;
import com.toughguy.sinograin.model.barn.Handover;
import com.toughguy.sinograin.model.barn.Library;
import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.model.barn.SmallSample;
import com.toughguy.sinograin.service.barn.prototype.IBarnService;
import com.toughguy.sinograin.service.barn.prototype.IHandoverService;
import com.toughguy.sinograin.service.barn.prototype.ILibraryService;
import com.toughguy.sinograin.service.barn.prototype.IRegisterService;
import com.toughguy.sinograin.service.barn.prototype.ISampleService;
import com.toughguy.sinograin.service.barn.prototype.ISmallSampleService;
import com.toughguy.sinograin.util.BarCodeUtil;
import com.toughguy.sinograin.util.SamplingUtil;
import com.toughguy.sinograin.util.UploadUtil;

import groovy.util.logging.Log4j2.Log4j2LoggingStrategy;

@Service
public class BarnServiceImpl implements IBarnService {
	
	@Autowired
	private IRegisterService registerService;
	@Autowired
	private ISampleService sampleService;
	@Autowired
	private IHandoverService handoverService;
	@Autowired
	private ISmallSampleService smallSampleService;
	@Autowired
	private ILibraryService libraryService;
	
	@Override
	public void saveSampleAndRegister(SamplingDTO sampleDTO) {	
		//状态未做处理在controller层存入状态
		registerService.save(sampleDTO.getRegister());
		int rId = sampleDTO.getRegister().getId();
		for(Sample s : sampleDTO.getList()){
			s.setpId(rId);
			s.setSampleState(-1);
			sampleService.save(s);
		}
	}

	@Override
	public void saveOrEditAll(SamplingDTO sampleDTO) {
		registerService.update(sampleDTO.getRegister());
		int rId = sampleDTO.getRegister().getId();
		for(Sample s:sampleDTO.getList()){
			if(s.getId() > 0){
				sampleService.update(s);
			}else{
				s.setpId(rId);
				s.setSampleState(-1);
				sampleService.save(s);			
			}
		}
	}

	@Override
	public void dealCheck(Handover handover,int flag,String[] deleteIds) {
		String [] sampleIds = handover.getSampleIds().split(",");
		String [] checkeds = handover.getCheckeds().split(",");
		if(flag ==1 ){ 	//增加样品交接单
			updateCheckeds(sampleIds,checkeds);
			handoverService.save(handover);	
		}else if(flag == 2){ //修改样品交接单
			deleteCheckeds(sampleIds,checkeds);
			updateCheckeds(sampleIds,checkeds);
			if(!(deleteIds == null ||deleteIds.equals(""))) {
				deleteSampleIdCheckeds(deleteIds);
			}
			handoverService.update(handover);	
		}else{	//删除样品交接单
			deleteCheckeds(sampleIds,checkeds);
			handoverService.delete(handover.getId());	
		}
					
	}
	//添加样品中对应检测项
	private void updateCheckeds(String [] ids,String [] checkeds){
		Sample sample  = null;
		List<String> checkList =  new ArrayList<String>(Arrays.asList(checkeds)); 
		for(String id :ids){
			sample = sampleService.find(Integer.parseInt(id));
//			if(StringUtils.isEmpty(sample.getCheckeds())){
//				sample.setCheckeds(StringUtils.join(checkeds,","));
//			}else{
//				String [] oldCheckeds = sample.getCheckeds().split(",");
//				List<String> oldCheckList =  new ArrayList<String>(Arrays.asList(oldCheckeds));
//				checkList.removeAll(oldCheckList); 		// 移除所有一致检测项
//				oldCheckList.addAll(checkList); 		//将剩余检测项放入集合
////				StringUtils.join(oldCheckList,",");
//				sample.setCheckeds(StringUtils.join(oldCheckList,","));
//				}
			sample.setSampleState(3);
			sampleService.update(sample);
			}
		}
	//删除样品类中的对应检测项
	private void deleteCheckeds(String [] ids,String [] checkeds){
		Sample sample = null;
		List<String> checkList =  new ArrayList<String>(Arrays.asList(checkeds)); 
		for(String id : ids){
			sample = sampleService.find(Integer.parseInt(id));
			String [] oldCheckeds = sample.getCheckeds().split(",");
			List<String> oldCheckList =  new ArrayList<String>(Arrays.asList(oldCheckeds));
			oldCheckList.removeAll(checkList);
			StringUtils.join(checkList,",");
			sample.setCheckeds(StringUtils.join(checkList,","));
			sampleService.update(sample);
		}
	}
	//删除交接单中删除的样品的检测项
		private void deleteSampleIdCheckeds(String [] deleteIds){
			Sample sample = null; 
			for(String id : deleteIds){
				sample = sampleService.find(Integer.parseInt(id));
				sample.setCheckeds("");
				sampleService.update(sample);
			}
		}
	@Override
	public void saveSmallSample(Sample sample) {
		Map<String,Object> map = SamplingUtil.smallSampleNums(sample);
		List<String> nums = (List<String>)map.get("list");
		for(String num: nums){
			SmallSample smallSample = new SmallSample();
			//获取检测项
			if(num.substring(num.length()-1).equals("1")) {
				String point = String.valueOf(map.get("checkPoint1"));
				smallSample.setCheckPoint(point);
			} else if(num.substring(num.length()-1).equals("3")) {
				String point = String.valueOf(map.get("checkPoint3"));
				smallSample.setCheckPoint(point);
			} else if(num.substring(num.length()-1).equals("4")) {
				String point = String.valueOf(map.get("checkPoint4"));
				smallSample.setCheckPoint(point);
			} else if(num.substring(num.length()-1).equals("5")) {
				String point = String.valueOf(map.get("checkPoint5"));
				smallSample.setCheckPoint(point);
			}  else if(num.substring(num.length()-1).equals("6")) {
				String point = String.valueOf(map.get("checkPoint6"));
				smallSample.setCheckPoint(point);
			}else if(num.substring(num.length()-1).equals("7")) {
				String point = String.valueOf(map.get("checkPoint7"));
				smallSample.setCheckPoint(point);
			} else if(num.substring(num.length()-1).equals("8")) {
				String point = String.valueOf(map.get("checkPoint8"));
				smallSample.setCheckPoint(point);
			}
			//生成二维码
			String path = UploadUtil.getAbsolutePath("smaBarcode");
			File f = new File(path);  //无路径则创建 
			if(!f.exists()){
				f.mkdirs();
			}
			String barFileName = BarCodeUtil.rename("png");
			BarCodeUtil.generateFile(num, path + "/"+ barFileName);
			smallSample.setSmallSamplePic(barFileName);
			smallSample.setSampleId(sample.getId());
			smallSample.setSmallSampleNum(num);
			smallSample.setState(1);
			if(num.substring(num.length()-1).equals("1")) {
				smallSample.setSmallSampleWord(num + "小1");
			} else if(num.substring(num.length()-1).equals("3")) {
				smallSample.setSmallSampleWord(num + "水");
			} else if(num.substring(num.length()-1).equals("4")) {
				smallSample.setSmallSampleWord(num + "硬");
			} else if(num.substring(num.length()-1).equals("5")) {
				smallSample.setSmallSampleWord(num + "面");
			} else if(num.substring(num.length()-1).equals("6")) {
				smallSample.setSmallSampleWord(num + "品");
			} else if(num.substring(num.length()-1).equals("7")) {
				smallSample.setSmallSampleWord(num + "卫");
			} else if(num.substring(num.length()-1).equals("8")) {
				smallSample.setSmallSampleWord(num + "脂");
			}
			smallSampleService.save(smallSample);
		}
		sample.setSampleState(5);
		sampleService.update(sample);
	}

	/**
	 * 临时保存扦样表和样品方法
	 */
	@Override
	public void temporarySaveSampleAndRegister(SamplingDTO sampleDTO) {
		// TODO Auto-generated method stub
		//状态未做处理在controller层存入状态
		registerService.save(sampleDTO.getRegister());
		int rId = sampleDTO.getRegister().getId();
		for(Sample s : sampleDTO.getList()){
			s.setpId(rId);
			s.setSampleState(1);
			String sampleWord = s.getSampleWord();
			String[] sampleWords = sampleWord.split("-");
			int libraryId = 0;
			String sortNum = null;
			Library l = libraryService.findByLibraryName(sampleWords[0]);
			libraryId = l.getId();
			if(sampleWords[1].equals("小麦")) {
				sortNum = "01";
			} else if(sampleWords[1].equals("玉米")) {
				sortNum = "02";
			}
			String sampleNo = "60" + String.format("%03d", libraryId) + sortNum + sampleWords[2];
			s.setSampleNo(sampleNo);
			String path = UploadUtil.getAbsolutePath("barcode");
			File f = new File(path); // 无路径则创建
			if (!f.exists()) {
				f.mkdirs();
			}
			String barFileName = BarCodeUtil.rename("png");
			BarCodeUtil.generateFile(sampleNo, path + "/" + barFileName);
			s.setSamplePic(barFileName);
			sampleService.save(s);
		}
	}
	
}
