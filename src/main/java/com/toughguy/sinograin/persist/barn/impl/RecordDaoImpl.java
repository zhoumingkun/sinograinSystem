package com.toughguy.sinograin.persist.barn.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.toughguy.sinograin.model.barn.Record;
import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.persist.barn.prototype.IRecordDao;
import com.toughguy.sinograin.persist.impl.GenericDaoImpl;
@Repository
public class RecordDaoImpl  extends GenericDaoImpl<Record, Integer> implements IRecordDao {

	@Override
	public List<Record> findRecord(Sample sample) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(typeNameSpace + ".findRecord",sample);
	}

}
