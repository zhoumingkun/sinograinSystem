package com.toughguy.sinograin.service;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.toughguy.sinograin.SinograinApplication;
import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.pagination.PagerModel;
import com.toughguy.sinograin.persist.barn.prototype.ISampleDao;
import com.toughguy.sinograin.service.barn.prototype.ISampleService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=SinograinApplication.class)
public class SampleServiceTest {

	@Autowired
	private ISampleService sampleService;
	@Test
	public void testFind() {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("page",1);
		map.put("rows", 5);
		PagerModel<Sample> l = sampleService.findPaginatedMobile(map);
		System.out.println(l.getData());
	}

}
