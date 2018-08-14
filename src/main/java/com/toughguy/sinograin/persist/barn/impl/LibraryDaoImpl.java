package com.toughguy.sinograin.persist.barn.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.toughguy.sinograin.model.barn.Library;
import com.toughguy.sinograin.persist.barn.prototype.ILibraryDao;
import com.toughguy.sinograin.persist.impl.GenericDaoImpl;

@Repository
public class LibraryDaoImpl extends GenericDaoImpl<Library, Integer> implements ILibraryDao {

	@Override
	public List<Library> findFirst(Map<String, Object> params) {
		return sqlSessionTemplate.selectList(typeNameSpace + ".findFirst",params);
	}

	@Override
	public List<Library> findByParams(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(typeNameSpace + ".findByParams",params);
	}

	@Override
	public Library findByLibraryName(String libraryName) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(typeNameSpace + ".findByLibraryName",libraryName);
	}

}
