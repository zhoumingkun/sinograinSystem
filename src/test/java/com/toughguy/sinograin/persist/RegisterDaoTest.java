package com.toughguy.sinograin.persist;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.toughguy.sinograin.SinograinApplication;
import com.toughguy.sinograin.model.barn.Register;
import com.toughguy.sinograin.persist.barn.prototype.IRegisterDao;
import com.toughguy.sinograin.service.barn.prototype.IRegisterService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=SinograinApplication.class)
public class RegisterDaoTest {

	@Autowired
	private IRegisterDao registerDao;
	@Autowired
	private IRegisterService registerService;
	
	@Test
	public void testAdd() {
		Register r = new Register();
		r.setFormName("2017秋季检测");
		r.setRegState(0);
		registerDao.save(r);
	}
	@Test
	public void testSelete() {
		List<Register> rs = registerService.findByLibraryId(0);
		System.out.println(rs);
	}

}
