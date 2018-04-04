package com.toughguy.sinograin.persist;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.toughguy.sinograin.SinograinApplication;
import com.toughguy.sinograin.model.barn.CornExaminingReport;
import com.toughguy.sinograin.model.barn.Mianjinxishuiliang;
import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.persist.barn.prototype.ICornExaminingReportDao;
import com.toughguy.sinograin.persist.barn.prototype.IMianjinxishuiliangDao;
import com.toughguy.sinograin.service.barn.prototype.ISampleService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=SinograinApplication.class)
public class CornExaminingReportDaoTest {
	@Autowired
	private ICornExaminingReportDao icornExaminingReportDao;
	
	@Autowired
	private ISampleService sampleService;
	
	@Before
	public void init(){}
	    //查询所有面筋吸水量测定记录
		@Test
		public void testFindAllicornExaminingReportDao(){
		sampleService.Export("8,9,10,45,11,12","中央储备粮轮换验收申请统计表（2016年度）");
			
		}
		
		@Test
		public void testFind(){
		sampleService.ExeclPOI("8,9,10,45,11,12","中央储备粮轮换验收申请统计表（2016年度）");
			
		}

}
