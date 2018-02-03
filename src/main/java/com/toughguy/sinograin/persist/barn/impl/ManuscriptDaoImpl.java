package com.toughguy.sinograin.persist.barn.impl;

import org.springframework.stereotype.Repository;

import com.toughguy.sinograin.model.barn.Manuscript;
import com.toughguy.sinograin.persist.barn.prototype.IManuscriptDao;
import com.toughguy.sinograin.persist.impl.GenericDaoImpl;

@Repository
public class ManuscriptDaoImpl extends GenericDaoImpl<Manuscript, Integer> implements IManuscriptDao {

}
