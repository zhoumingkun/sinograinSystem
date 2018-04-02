package com.toughguy.sinograin.persist;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.toughguy.sinograin.SinograinApplication;
import com.toughguy.sinograin.model.barn.Mianjinxishuiliang;
import com.toughguy.sinograin.persist.barn.prototype.IMianjinxishuiliangDao;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=SinograinApplication.class)
public class MianjinxishuiliangDaoTest {
	@Autowired
	private IMianjinxishuiliangDao imianjinxishuiliangDao;
	
	@Before
	public void init(){}
	    //查询所有面筋吸水量测定记录
		@Test
		public void testFindAllimianjinxishuiliangDao(){
//			Map<String,Object> params = new HashMap<String,Object>();
//			params.put("chenjiangzhi_1", "lisi");
			List<Mianjinxishuiliang> list = imianjinxishuiliangDao.findAll();
				System.out.println(list.get(0).getBeizhu());
		}
		
		
		//根据ID查询面筋吸水量测定记录
		@Test
		public void testFindAllByIdimianjinxishuiliangDao(){
			int A = 1;
			Mianjinxishuiliang mianjinxishuiliang = imianjinxishuiliangDao.find(A);
		    System.out.println(mianjinxishuiliang.getRiqi());
			System.out.println(mianjinxishuiliang.getGanmianjinzhiliang_1());
		}
		
		//修改面筋吸水量测定记录
		@Test
		public void testUpdateMianjinxishuiliang(){
			Mianjinxishuiliang mianjinxishuiliang = new Mianjinxishuiliang();
			mianjinxishuiliang.setId(1);
			mianjinxishuiliang.setTable_version("0000000-0");
			imianjinxishuiliangDao.update(mianjinxishuiliang);
		}
		
		
		//添加面筋吸水量测定记录
		@Test
		public void testAddMianjinxishuiliang(){
			Mianjinxishuiliang mianjinxishuiliang = new Mianjinxishuiliang();
			mianjinxishuiliang.setTable_version("1234-2");
			mianjinxishuiliang.setSmallSampleId(2);;
			imianjinxishuiliangDao.save(mianjinxishuiliang);
		}
		
		//删除面筋吸水量测定记录
		@Test
		public void testDeleteMianjinxishuiliang(){
			    
			imianjinxishuiliangDao.delete(0);;
		}
				
	
}






