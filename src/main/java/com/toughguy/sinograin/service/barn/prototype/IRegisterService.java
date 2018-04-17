package com.toughguy.sinograin.service.barn.prototype;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.toughguy.sinograin.dto.SamplingDTO;
import com.toughguy.sinograin.model.barn.Register;
import com.toughguy.sinograin.service.prototype.IGenericService;

public interface IRegisterService extends IGenericService<Register, Integer> {

	/**
	 * 根据库id查找扦样表
	 */
	public List<Register> findByLibraryId(Map<String, Object> params);
	
	/**
	 * 导出扦样表
	 */
	public void expertExcel(HttpServletResponse response,SamplingDTO sample)throws Exception;
	
	/**
	 * 删除扦样登记表
	 */
	public void deleteRegisterAndSample(int id);
}
