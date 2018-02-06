package com.toughguy.sinograin.persist.barn.impl;

import org.springframework.stereotype.Repository;

import com.toughguy.sinograin.model.barn.Library;
import com.toughguy.sinograin.persist.barn.prototype.ILibraryDao;
import com.toughguy.sinograin.persist.impl.GenericDaoImpl;

@Repository
public class LibraryDaoImpl extends GenericDaoImpl<Library, Integer> implements ILibraryDao {

}
