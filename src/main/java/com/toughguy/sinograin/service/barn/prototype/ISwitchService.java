package com.toughguy.sinograin.service.barn.prototype;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.toughguy.sinograin.dto.SamplingDTO;
import com.toughguy.sinograin.model.barn.Register;
import com.toughguy.sinograin.model.barn.Switch;
import com.toughguy.sinograin.service.prototype.IGenericService;

public interface ISwitchService extends IGenericService<Switch, Integer> {

	/**
	 * 
	 */
	public Switch findSwitch();
	
}
