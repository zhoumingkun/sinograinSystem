package com.toughguy.sinograin.persist.barn.prototype;


import java.util.List;
import java.util.Map;

import com.toughguy.sinograin.model.barn.Zhifangsuanzhi;
import com.toughguy.sinograin.persist.prototype.IGenericDao;

public interface IZhifangsuanzhiDao extends IGenericDao<Zhifangsuanzhi, Integer>{
	/**
	 * 根据小样id查询检验单
	 * @param smallSampleId
	 * @return
	 */
	public Zhifangsuanzhi findBySmallSampleId(int smallSampleId);
	/**
	 * 查询待审批的所有检验单
	 * @param map
	 * @return
	 */
	public List<Zhifangsuanzhi> findByCheckOrderApprovalStatus(String sort);
}
