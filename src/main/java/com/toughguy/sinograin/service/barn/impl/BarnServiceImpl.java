package com.toughguy.sinograin.service.barn.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public void saveSampleAndRegister(String formName, Sample sample) {
		Register register = new Register();
		register.setFormName(formName);
		//状态未做处理
		registerService.save(register);
		sampleService.save(sample);

	}

}
