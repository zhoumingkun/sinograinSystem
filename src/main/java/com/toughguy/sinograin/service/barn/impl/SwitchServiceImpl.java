package com.toughguy.sinograin.service.barn.impl;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toughguy.sinograin.model.barn.Switch;
import com.toughguy.sinograin.persist.barn.prototype.ISwitchDao;
import com.toughguy.sinograin.service.barn.prototype.ISwitchService;
import com.toughguy.sinograin.service.impl.GenericServiceImpl;
import com.toughguy.sinograin.util.POIUtils;

@Service
public class SwitchServiceImpl extends GenericServiceImpl<Switch, Integer> implements ISwitchService {
	
	@Autowired
	private ISwitchDao switchDao;
	
	@Override
	public Switch findSwitch() {
		Switch switch1= switchDao.findSwitch();
		return switch1;
	}

	

	
}
