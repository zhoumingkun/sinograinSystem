package com.toughguy.sinograin.service.barn.impl;

import org.springframework.stereotype.Service;

import com.toughguy.sinograin.model.barn.Manuscript;
import com.toughguy.sinograin.persist.impl.GenericDaoImpl;
import com.toughguy.sinograin.service.barn.prototype.IManuscriptService;

@Service
public class ManuscriptServiceImpl extends GenericDaoImpl<Manuscript, Integer> implements IManuscriptService{

}
