package com.toughguy.sinograin.service.barn.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toughguy.sinograin.dto.SamplingDTO;
import com.toughguy.sinograin.model.barn.Handover;
import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.model.barn.SmallSample;
import com.toughguy.sinograin.service.barn.prototype.IBarnService;
import com.toughguy.sinograin.service.barn.prototype.IHandoverService;
import com.toughguy.sinograin.service.barn.prototype.IRegisterService;
import com.toughguy.sinograin.service.barn.prototype.ISampleService;
import com.toughguy.sinograin.service.barn.prototype.ISmallSampleService;
import com.toughguy.sinograin.util.BarCodeUtil;
import com.toughguy.sinograin.util.SamplingUtil;
import com.toughguy.sinograin.util.UploadUtil;

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
	public void dealCheck(Handover handover,int flag) {
		String [] sampleIds = handover.getSampleIds().split(",");
		String [] checkeds = handover.getCheckeds().split(",");	
				if(flag ==1 ){ 	//增加样品交接单
					updateCheckeds(sampleIds,checkeds);
					handoverService.save(handover);	
				}else if(flag == 2){ //修改样品交接单
					deleteCheckeds(sampleIds,checkeds);
					updateCheckeds(sampleIds,checkeds);
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
			if(StringUtils.isEmpty(sample.getCheckeds())){
				sample.setCheckeds(StringUtils.join(checkeds,","));
			}else{
				String [] oldCheckeds = sample.getCheckeds().split(",");
				List<String> oldCheckList =  new ArrayList<String>(Arrays.asList(oldCheckeds));
				checkList.removeAll(oldCheckList); 		// 移除所有一致检测项
				oldCheckList.addAll(checkList); 		//将剩余检测项放入集合
				StringUtils.join(checkList,",");
				}
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
			sampleService.update(sample);
		}
	}

	@Override
	public void saveSmallSample(Sample sample) {
		List<String> nums = SamplingUtil.smallSampleNums(sample);
		if(!CollectionUtils.isEmpty(nums)){
			for(String s: nums){
				SmallSample smallSample = new SmallSample();
				//获取检测项
				int point =Integer.parseInt(s.substring(s.length()-1)) ;
				smallSample.setCheckPoint(point);
				//生成二维码
				String path = UploadUtil.getAbsolutePath("smaBarcode");
				File f = new File(path);  //无路径则创建 
				if(!f.exists()){
					f.mkdirs();
				}
				String barFileName = BarCodeUtil.rename("png");
				BarCodeUtil.generateFile(s, path + "/"+ barFileName);
				smallSample.setSmallSamplePic(barFileName);
				smallSample.setSampleId(sample.getId());
				smallSample.setSmallSampleNum("监"+s);
				smallSampleService.save(smallSample);
			}
			sample.setSampleState(3);
			sampleService.update(sample);
		}	
	}
	
}
