package com.toughguy.sinograin.service.barn.impl;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.stereotype.Service;

import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.model.barn.TestItem;
import com.toughguy.sinograin.persist.barn.prototype.ITestItemDao;
import com.toughguy.sinograin.service.barn.prototype.ITestItemService;
import com.toughguy.sinograin.service.impl.GenericServiceImpl;
import com.toughguy.sinograin.util.POIUtils;

@Service
public class TestItemServiceImpl extends GenericServiceImpl<TestItem, Integer> implements ITestItemService {

	@Override
	public List<TestItem> findResult(int sampleId) {
		// TODO Auto-generated method stub
		return ((ITestItemDao)dao).findResult(sampleId);
	}

	@Override
	public List<Sample> getSampleBySortAndTestItem(TestItem testItem) {
		// TODO Auto-generated method stub
		return ((ITestItemDao)dao).getSampleBySortAndTestItem(testItem);
	}
	@Override
	public List<Sample> getAllSampleBySortAndTestItem() {
		// TODO Auto-generated method stub
		return ((ITestItemDao)dao).getAllSampleBySortAndTestItem();
	}
	//样品确认单导出
  	@Override
  	public	void expotexpotTestItem(HttpServletResponse response,int sampleId){
  		// TODO Auto-generated method stub
  	}
	
}