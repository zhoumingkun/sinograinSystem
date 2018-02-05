package com.toughguy.sinograin.service.barn.impl;

import org.springframework.stereotype.Service;

import com.toughguy.sinograin.model.barn.SafetyReport;
import com.toughguy.sinograin.persist.impl.GenericDaoImpl;
import com.toughguy.sinograin.service.barn.prototype.ISafetyReportService;

@Service
public class SafetyReportServiceImpl extends GenericDaoImpl<SafetyReport, Integer> implements ISafetyReportService{

}
