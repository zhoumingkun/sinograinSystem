package com.toughguy.sinograin.persist;


import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.toughguy.sinograin.SinograinApplication;
import com.toughguy.sinograin.model.barn.Zhenjundusu;
import com.toughguy.sinograin.persist.barn.prototype.IZhenjundusuDao;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=SinograinApplication.class)
public class ZhenjundusuDaoTest {
	
	@Autowired
	private IZhenjundusuDao izhenjundusuDao;
	
	@Before
	public void init(){}
	    //查询所有真菌毒素记录
		@Test
		public void testFindAllizhenjundusuDao(){
//			Map<String,Object> params = new HashMap<String,Object>();
//			params.put("chenjiangzhi_1", "lisi");
			List<Zhenjundusu> list = izhenjundusuDao.findAll();
				System.out.println(list.get(0).getBeizhu());
		}
		
		
		//根据ID查询不完善粒真菌毒素记录
		@Test
		public void testFindAllByIdizhenjundusuDao(){
			int A = 1;
			Zhenjundusu zhenjundusu = izhenjundusuDao.find(A);
		    System.out.println(zhenjundusu.getRiqi());
			System.out.println(zhenjundusu.getHuangqumeidusu_1());
		}
		
		//修改真菌毒素记录
		@Test
		public void testUpdateZhenjundusu(){
			Zhenjundusu zhenjundusu = new Zhenjundusu();
			zhenjundusu.setId(1);
			zhenjundusu.setTable_version("1234-0");
			izhenjundusuDao.update(zhenjundusu);
		}
		
		
		//添加真菌毒素记录
		@Test
		public void testAddZhenjundusu(){
			Zhenjundusu zhenjundusu = new Zhenjundusu();
			zhenjundusu.setTable_version("1234-2");
			zhenjundusu.setSmallSampleId(2);
			izhenjundusuDao.save(zhenjundusu);
		}
		
		//删除真菌毒素记录
		@Test
		public void testDeleteZhenjundusu(){
			    
			izhenjundusuDao.delete(0);;
		}
				
	
}
