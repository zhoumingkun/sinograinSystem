package com.toughguy.sinograin.persist.barn.prototype;

import java.util.List;

import com.toughguy.sinograin.model.barn.Register;
import com.toughguy.sinograin.persist.prototype.IGenericDao;

public interface IRegisterDao extends IGenericDao<Register, Integer> {
	
	/**
	 * 根据库id查询钎样表
	 * @param libraryId 库id
	 */
	public List<Register> findByLibraryId(int libraryId);
}
