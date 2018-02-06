package com.toughguy.sinograin.service.barn.prototype;

import java.util.List;

import com.toughguy.sinograin.model.barn.Register;
import com.toughguy.sinograin.service.prototype.IGenericService;

public interface IRegisterService extends IGenericService<Register, Integer> {

	/**
	 * 根据库id查找扦样表
	 */
	public List<Register> findByLibraryId(int libraryId);
}
