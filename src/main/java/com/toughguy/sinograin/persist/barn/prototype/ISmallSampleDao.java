package com.toughguy.sinograin.persist.barn.prototype;

import java.util.List;

import com.toughguy.sinograin.model.barn.SmallSample;
import com.toughguy.sinograin.persist.prototype.IGenericDao;

public interface ISmallSampleDao  extends IGenericDao<SmallSample, Integer> {
	/**
	 * 根据小样编号查询小样
	 * */
	public SmallSample findBySmallSampleNum(String smallSampleNum);
	/**
	 * 根据检验编号查询小样
	 * */
	public List<SmallSample> findBySampleId(int sampleId);
	/**
	 * 根据检验编号查询小样
	 * */
	public List<SmallSample> findBySampleNum(String sampleNum);
}
