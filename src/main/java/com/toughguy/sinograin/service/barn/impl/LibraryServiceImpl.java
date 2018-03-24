package com.toughguy.sinograin.service.barn.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toughguy.sinograin.model.barn.Library;
import com.toughguy.sinograin.persist.barn.prototype.ILibraryDao;
import com.toughguy.sinograin.service.barn.prototype.ILibraryService;
import com.toughguy.sinograin.service.impl.GenericServiceImpl;

@Service
public class LibraryServiceImpl extends GenericServiceImpl<Library, Integer> implements ILibraryService {
	
	@Autowired
	private ILibraryDao dao;
	@Override
	public List<Library> findFirst(Map<String, Object> params) {	
		return dao.findFirst(params);
	}

}
