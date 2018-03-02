package com.toughguy.sinograin.persist;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.toughguy.sinograin.SinograinApplication;
import com.toughguy.sinograin.model.barn.Manuscript;
import com.toughguy.sinograin.pagination.PagerModel;
import com.toughguy.sinograin.persist.barn.prototype.IManuscriptDao;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=SinograinApplication.class)
public class ManuscriptDaoTest {
	
	@Autowired
	private IManuscriptDao mDao;
	@Test
	public void test() {
		Manuscript list = mDao.find(1);		
		System.out.println(list);
	}
	@Test
	public void testMan(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("startTime", "2018-02-11");
		map.put("endTime", "2018-03-11");
		PagerModel<Manuscript>pm = mDao.findPaginated(map);
		System.out.println(pm.getData());
	}
}
