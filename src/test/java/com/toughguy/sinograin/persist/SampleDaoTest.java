package com.toughguy.sinograin.persist;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.toughguy.sinograin.SinograinApplication;
import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.persist.barn.prototype.ISampleDao;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=SinograinApplication.class)
public class SampleDaoTest {

	@Autowired
	private ISampleDao sampleDao;
	
	@Test
	public void testAdd() {
		Sample s= new Sample();
		s.setDepot("12234");
		sampleDao.save(s);
	}
	@Test
	public void testUpdate() {
		Sample s= new Sample();
		s.setUpdateTime(new Date());
		s.setId(1);
		sampleDao.update(s);
	}
	@Test
	public void testFind() {
		Sample s= sampleDao.find(2);
		System.out.println(s);	
	}
//	@Test
//	public void testFindBySampleNum() {
//		String [] sampleNums = {"20180012"};
//		List<Sample> samples =  sampleDao.findBySampleNums(StringUtils.join(sampleNums,","));
//		System.out.println(samples);
//	}

}
