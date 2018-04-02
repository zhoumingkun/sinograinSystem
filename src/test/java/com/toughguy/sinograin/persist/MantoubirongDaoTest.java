package com.toughguy.sinograin.persist;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.toughguy.sinograin.SinograinApplication;
import com.toughguy.sinograin.model.barn.Mantoubirong;
import com.toughguy.sinograin.persist.barn.prototype.IMantoubirongDao;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=SinograinApplication.class)
public class MantoubirongDaoTest {
	
	@Autowired
	private IMantoubirongDao imantoubirongDao;
	
	@Before
	public void init(){}
	    //查询所有真菌毒素记录
		@Test
		public void testFindAllimantoubirongDao(){
//			Map<String,Object> params = new HashMap<String,Object>();
//			params.put("chenjiangzhi_1", "lisi");
			List<Mantoubirong> list = imantoubirongDao.findAll();
				System.out.println(list.get(0).getDidian());
		}
		
		
		//根据ID查询不完善粒真菌毒素记录
		@Test
		public void testFindAllByIdimantoubirongDao(){
			int A = 1;
			Mantoubirong mantoubirong = imantoubirongDao.find(A);
		    System.out.println(mantoubirong.getRiqi());
			System.out.println(mantoubirong.getContent());
		}
		
		//修改真菌毒素记录
		@Test
		public void testUpdateMantoubirong(){
			Mantoubirong mantoubirong = new Mantoubirong();
			mantoubirong.setId(1);
			mantoubirong.setTable_version("1234-0");
			imantoubirongDao.update(mantoubirong);
		}
		
		
		//添加真菌毒素记录
		@Test
		public void testAddMantoubirong(){
			Mantoubirong mantoubirong = new Mantoubirong();
			mantoubirong.setTable_version("1234-2");
			mantoubirong.setDidian("地点");;
			imantoubirongDao.save(mantoubirong);
		}
		
		//删除真菌毒素记录
		@Test
		public void testDeleteMantoubirong(){
			    
			imantoubirongDao.delete(0);;
		}
				
	
}



