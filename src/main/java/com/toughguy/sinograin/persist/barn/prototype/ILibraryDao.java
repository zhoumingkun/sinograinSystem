package com.toughguy.sinograin.persist.barn.prototype;

import java.util.List;

import com.toughguy.sinograin.model.barn.Library;
import com.toughguy.sinograin.persist.prototype.IGenericDao;

public interface ILibraryDao extends IGenericDao<Library, Integer>  {
	
	public List<Library> findFirst();
}
