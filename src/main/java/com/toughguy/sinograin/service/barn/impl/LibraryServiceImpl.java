package com.toughguy.sinograin.service.barn.impl;

import org.springframework.stereotype.Service;

import com.toughguy.sinograin.model.barn.Library;
import com.toughguy.sinograin.persist.impl.GenericDaoImpl;
import com.toughguy.sinograin.service.barn.prototype.ILibraryService;

@Service
public class LibraryServiceImpl extends GenericDaoImpl<Library, Integer> implements ILibraryService {

}
