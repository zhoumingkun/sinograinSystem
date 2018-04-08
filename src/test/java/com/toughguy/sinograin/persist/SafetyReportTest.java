package com.toughguy.sinograin.persist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.toughguy.sinograin.SinograinApplication;
import com.toughguy.sinograin.model.barn.Library;
import com.toughguy.sinograin.model.barn.SafetyReport;
import com.toughguy.sinograin.pagination.PagerModel;
import com.toughguy.sinograin.persist.barn.prototype.ILibraryDao;
import com.toughguy.sinograin.service.barn.prototype.ISafetyReportService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=SinograinApplication.class)
public class SafetyReportTest {
	
	@Autowired
	private ISafetyReportService safetyReportService;
	
//	@Test
//	public void testReg(){
//		safetyReportService.ExportSafetyReport(null, null);
//	}

}
