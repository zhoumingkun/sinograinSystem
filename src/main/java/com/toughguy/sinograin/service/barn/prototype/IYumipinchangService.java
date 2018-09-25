package com.toughguy.sinograin.service.barn.prototype;

import java.util.List;
import java.util.Map;

import com.toughguy.sinograin.model.barn.Yumipinchang;
import com.toughguy.sinograin.service.prototype.IGenericService;

public interface IYumipinchangService extends IGenericService<Yumipinchang, Integer>{
	
	/**
	 * 根据小样id查询检验单
	 * @param smallSampleId
	 * @return
	 */
	public Yumipinchang findBySmallSampleId(int smallSampleId);
	/**
	 * 查询待审批的所有检验单
	 * @param map
	 * @return
	 */
	public List<Yumipinchang> findByCheckOrderApprovalStatus(String sort);
}
