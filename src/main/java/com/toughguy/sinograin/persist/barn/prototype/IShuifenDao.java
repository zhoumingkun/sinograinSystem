package com.toughguy.sinograin.persist.barn.prototype;

import java.util.List;
import java.util.Map;

import com.toughguy.sinograin.model.barn.Shuifen;
import com.toughguy.sinograin.persist.prototype.IGenericDao;

public interface IShuifenDao extends IGenericDao<Shuifen, Integer>  {
	/**
	 * 根据小样id查询检验单
	 * @param smallSampleId
	 * @return
	 */
	public Shuifen findBySmallSampleId(int smallSampleId);
	/**
	 * 查询待审批的所有检验单
	 * @param map
	 * @return
	 */
	public List<Shuifen> findByCheckOrderApprovalStatus(String sort);
}
