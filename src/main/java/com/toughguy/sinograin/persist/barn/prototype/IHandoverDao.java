package com.toughguy.sinograin.persist.barn.prototype;

import java.util.List;

import com.toughguy.sinograin.model.barn.Handover;
import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.persist.prototype.IGenericDao;

public interface IHandoverDao extends IGenericDao<Handover, Integer>  {
	public Handover findsampleNums(String sampleNums);
}
