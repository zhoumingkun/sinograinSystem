package com.toughguy.sinograin.persist;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.toughguy.sinograin.SinograinApplication;
import com.toughguy.sinograin.model.barn.Register;
import com.toughguy.sinograin.persist.barn.prototype.IRegisterDao;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=SinograinApplication.class)
public class RegisterDaoTest {

	@Autowired
	private IRegisterDao registerDao;
	
	@Test
	public void testAdd() {
		Register r = new Register();
		r.setFormName("2017秋季检测");
		r.setState(0);
		registerDao.save(r);
	}

}
