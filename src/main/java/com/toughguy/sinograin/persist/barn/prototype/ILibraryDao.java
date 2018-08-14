package com.toughguy.sinograin.persist.barn.prototype;

import java.util.List;
import java.util.Map;

import com.toughguy.sinograin.model.barn.Library;
import com.toughguy.sinograin.persist.prototype.IGenericDao;

public interface ILibraryDao extends IGenericDao<Library, Integer>  {
	
	public List<Library> findFirst(Map<String, Object> params);
	
	/**
	 * 根据条件查询多个库
	 * @param params
	 * @return 库集合
	 */
	public List<Library> findByParams(Map<String, Object> params);
	/**
	 * 临时查询之根据库名查询库
	 * @param libraryName
	 * @return 库
	 */
	public Library findByLibraryName(String libraryName);
}
