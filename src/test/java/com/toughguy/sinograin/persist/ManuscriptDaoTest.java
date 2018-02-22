package com.toughguy.sinograin.persist;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.toughguy.sinograin.SinograinApplication;
import com.toughguy.sinograin.model.barn.Manuscript;
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

}
