package com.toughguy.sinograin.persist.barn.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.toughguy.sinograin.model.barn.Register;
import com.toughguy.sinograin.persist.barn.prototype.IRegisterDao;
import com.toughguy.sinograin.persist.impl.GenericDaoImpl;

@Repository
public class RegisterDaoImpl extends GenericDaoImpl<Register, Integer> implements IRegisterDao {

	@Override
	public List<Register> findByLibraryId(int libraryId) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(typeNameSpace + ".findByLibraryId", libraryId);
	}

}
