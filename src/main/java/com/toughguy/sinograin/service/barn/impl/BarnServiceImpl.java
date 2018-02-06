package com.toughguy.sinograin.service.barn.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toughguy.sinograin.dto.SamplingDTO;
import com.toughguy.sinograin.model.barn.Register;
import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.service.barn.prototype.IBarnService;
import com.toughguy.sinograin.service.barn.prototype.IRegisterService;
import com.toughguy.sinograin.service.barn.prototype.ISampleService;

@Service
public class BarnServiceImpl implements IBarnService {
	
	@Autowired
	private IRegisterService registerService;
	@Autowired
	private ISampleService sampleService;
	
	@Override
	public void saveSampleAndRegister(SamplingDTO sampleDTO) {	
		//状态未做处理在controller层存入状态
		registerService.save(sampleDTO.getRegister());
		int rId = sampleDTO.getRegister().getId();
		for(Sample s : sampleDTO.getList()){
			s.setpId(rId);
			sampleService.save(s);
		}
	}
}
