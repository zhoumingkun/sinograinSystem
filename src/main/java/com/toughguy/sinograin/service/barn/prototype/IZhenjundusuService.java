package com.toughguy.sinograin.service.barn.prototype;


import java.util.List;
import java.util.Map;

import com.toughguy.sinograin.model.barn.Zhenjundusu;
import com.toughguy.sinograin.service.prototype.IGenericService;

public interface IZhenjundusuService extends IGenericService<Zhenjundusu, Integer>{
	/**
	 * 根据小样id查询检验单
	 * @param smallSampleId
	 * @return
	 */
	public Zhenjundusu findBySmallSampleId(int smallSampleId);
	/**
	 * 查询待审批的所有检验单
	 * @param map
	 * @return
	 */
	public List<Zhenjundusu> findByCheckOrderApprovalStatus(String sort);
}
