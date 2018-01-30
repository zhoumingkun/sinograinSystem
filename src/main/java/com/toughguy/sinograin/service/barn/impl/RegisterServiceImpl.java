package com.toughguy.sinograin.service.barn.impl;

import org.springframework.stereotype.Service;

import com.toughguy.sinograin.model.barn.Register;
import com.toughguy.sinograin.service.barn.prototype.IRegisterService;
import com.toughguy.sinograin.service.impl.GenericServiceImpl;

@Service
public class RegisterServiceImpl extends GenericServiceImpl<Register, Integer> implements IRegisterService {

}
