package com.toughguy.sinograin.persist.barn.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.toughguy.sinograin.model.barn.Register;
import com.toughguy.sinograin.persist.barn.prototype.IRegisterDao;
import com.toughguy.sinograin.persist.impl.GenericDaoImpl;

@Repository
public class RegisterDaoImpl extends GenericDaoImpl<Register, Integer> implements IRegisterDao {

	@Override
	public List<Register> findByLibraryId(Map<String, Object> params) {
		return sqlSessionTemplate.selectList(typeNameSpace + ".findByLibraryId", params);
	}

}
