package com.toughguy.sinograin.persist.barn.prototype;

import java.util.List;
import java.util.Map;

import com.toughguy.sinograin.model.barn.Pinchang;
import com.toughguy.sinograin.persist.prototype.IGenericDao;

public interface IPinchangDao extends IGenericDao<Pinchang, Integer>  {
	/**
	 * 根据小样id查询检验单
	 * @param smallSampleId
	 * @return
	 */
	public Pinchang findBySmallSampleId(int smallSampleId);
	/**
	 * 查询待审批的所有检验单
	 * @param map
	 * @return
	 */
	public List<Pinchang> findByCheckOrderApprovalStatus(String sort);
}
