package com.toughguy.sinograin.persist;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.toughguy.sinograin.SinograinApplication;
import com.toughguy.sinograin.model.barn.Zhifangsuanzhi;
import com.toughguy.sinograin.persist.barn.prototype.IZhifangsuanzhiDao;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=SinograinApplication.class)
public class ZhifangsuanzhiDaoTest {
	
	@Autowired
	private IZhifangsuanzhiDao izhifangsuanzhiDao;
	
	@Before
	public void init(){}
	    //查询所有脂肪酸值测定记录
		@Test
		public void testFindAllizhifangsuanzhiDao(){
//			Map<String,Object> params = new HashMap<String,Object>();
//			params.put("chenjiangzhi_1", "lisi");
			List<Zhifangsuanzhi> list = izhifangsuanzhiDao.findAll();
				System.out.println(list.get(0).getBeizhu());
		}
		
		
		//根据ID查询脂肪酸值测定记录
		@Test
		public void testFindAllByIdizhifangsuanzhiDao(){
			int A = 1;
			Zhifangsuanzhi zhifangsuanzhi = izhifangsuanzhiDao.find(A);
		    System.out.println(zhifangsuanzhi.getZf_riqi());
			System.out.println(zhifangsuanzhi.getDidingqishidushu_1());
		}
		
		//修改脂肪酸值测定记录
		@Test
		public void testUpdateZhifangsuanzhi(){
			Zhifangsuanzhi zhifangsuanzhi = new Zhifangsuanzhi();
			zhifangsuanzhi.setId(1);
			zhifangsuanzhi.setZf_table_version("1234-0");
			izhifangsuanzhiDao.update(zhifangsuanzhi);
		}
		
		
		//添加脂肪酸值测定记录
		@Test
		public void testAddZhifangsuanzhi(){
			Zhifangsuanzhi zhifangsuanzhi = new Zhifangsuanzhi();
			zhifangsuanzhi.setZf_table_version("1234-2");
			zhifangsuanzhi.setSmallSampleId(2);
			izhifangsuanzhiDao.save(zhifangsuanzhi);
		}
		
		//添加脂肪酸值测定记录
		@Test
		public void testDeleteZhifangsuanzhi(){
			    
			izhifangsuanzhiDao.delete(0);;
		}
				
	
}



