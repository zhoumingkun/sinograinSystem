package com.toughguy.sinograin.persist.barn.prototype;

import java.util.List;

import com.toughguy.sinograin.model.barn.Mantoupinchang;
import com.toughguy.sinograin.persist.prototype.IGenericDao;

public interface IMantoupinchangDao extends IGenericDao<Mantoupinchang, Integer>  {
	/**
	 * 根据小样id查询检验单
	 * @param smallSampleId
	 * @return
	 */
	public Mantoupinchang findBySmallSampleId(int smallSampleId);
	/**
	 * 查询待审批的所有检验单
	 * @param map
	 * @return
	 */
	public List<Mantoupinchang> findByCheckOrderApprovalStatus(String sort);
}
