package com.toughguy.sinograin.service.barn.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toughguy.sinograin.model.barn.Register;
import com.toughguy.sinograin.persist.barn.prototype.IRegisterDao;
import com.toughguy.sinograin.service.barn.prototype.IRegisterService;
import com.toughguy.sinograin.service.impl.GenericServiceImpl;

@Service
public class RegisterServiceImpl extends GenericServiceImpl<Register, Integer> implements IRegisterService {
	
	@Autowired
	private IRegisterDao registerDao;
	
	@Override
	public List<Register> findByLibraryId(int libraryId) {
		List<Register> registers = registerDao.findByLibraryId(libraryId);
		return registers;
	}
	
}
