package com.toughguy.sinograin.service.barn.impl;

import org.springframework.stereotype.Service;

import com.toughguy.sinograin.model.barn.SafetyReport;
import com.toughguy.sinograin.service.barn.prototype.ISafetyReportService;
import com.toughguy.sinograin.service.impl.GenericServiceImpl;

@Service
public class SafetyReportServiceImpl extends GenericServiceImpl<SafetyReport, Integer> implements ISafetyReportService{

}
