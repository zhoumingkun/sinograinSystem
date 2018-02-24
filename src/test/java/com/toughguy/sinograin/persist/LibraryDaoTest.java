package com.toughguy.sinograin.persist;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.toughguy.sinograin.SinograinApplication;
import com.toughguy.sinograin.model.barn.Library;
import com.toughguy.sinograin.persist.barn.prototype.ILibraryDao;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=SinograinApplication.class)
public class LibraryDaoTest {
	
	@Autowired
	private ILibraryDao libraryDao;
	
	@Test
	public void testAdd() {
		for(int i=0;i<10;i++) {
			Library l = new Library();
			l.setLibraryName("山西库" + i);
			l.setLibraryState(0);
			libraryDao.save(l);
		}
	}

}
