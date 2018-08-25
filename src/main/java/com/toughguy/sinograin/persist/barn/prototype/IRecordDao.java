package com.toughguy.sinograin.persist.barn.prototype;

import java.util.List;
import java.util.Map;

import com.toughguy.sinograin.model.barn.Record;
import com.toughguy.sinograin.persist.prototype.IGenericDao;

public interface IRecordDao extends IGenericDao<Record, Integer>{
	
	public List<Record> findRecord(Map<String, Object> params);
}
