package com.toughguy.sinograin.persist;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.toughguy.sinograin.SinograinApplication;
import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.model.barn.Task;
import com.toughguy.sinograin.persist.barn.prototype.ITaskDao;
import com.toughguy.sinograin.service.barn.prototype.ITaskService;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=SinograinApplication.class)
public class TaskDaoTest {
	
	@Autowired
	private ITaskDao itaskDao;
	
	
	@Autowired
	private ITaskService iTaskService;
	
	@Before
	public void init(){}
	
	
	@Test
	public void testFindsampleIdBylibraryId(){
//		Map<String,Object> params = new HashMap<String,Object>();
//		params.put("chenjiangzhi_1", "lisi");
		List<Sample> list = iTaskService.findsampleIdBylibraryId(36);
		System.out.println(list.get(0).getId());
	}
	    //查询所有真菌毒素记录
		@Test
		public void testFindAllitaskDao(){
//			Map<String,Object> params = new HashMap<String,Object>();
//			params.put("chenjiangzhi_1", "lisi");
			List<Task> list = itaskDao.findAll();
				System.out.println(list.get(0).getTaskName());
		}
		
		
		//根据ID查询不完善粒真菌毒素记录
		@Test
		public void testFindAllByIditaskDao(){
			int A = 1;
			Task task = itaskDao.find(A);
		    System.out.println(task.getGuid());
			System.out.println(task.getTaskName());
		}
		
		//修改真菌毒素记录
		@Test
		public void testUpdateZhenjundusu(){
			Task task = new Task();
			task.setId(1);
			task.setGuid("1");
			itaskDao.update(task);
		}
		
		
		//添加真菌毒素记录
		@Test
		public void testAddZhenjundusu(){
			Task task = new Task();
			task.setTaskName("1");;
			task.setGuid("2");;
			itaskDao.save(task);
		}
		
		//删除真菌毒素记录
		@Test
		public void testDeleteTask(){
			    
			itaskDao.delete(0);;
		}
		
		
				
	
}

