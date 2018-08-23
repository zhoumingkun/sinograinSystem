package com.toughguy.sinograin.persist.barn.prototype;

import java.util.List;

import com.toughguy.sinograin.model.barn.Record;
import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.persist.prototype.IGenericDao;

public interface IRecordDao extends IGenericDao<Record, Integer>{
	
	public List<Record> findRecord(Sample sample);
}
