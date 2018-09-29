package com.toughguy.sinograin.service;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.toughguy.sinograin.SinograinApplication;
import com.toughguy.sinograin.model.barn.Sample;
import com.toughguy.sinograin.pagination.PagerModel;
import com.toughguy.sinograin.persist.barn.prototype.ISampleDao;
import com.toughguy.sinograin.service.barn.prototype.ISampleService;
import com.toughguy.sinograin.util.BarCodeUtil;
import com.toughguy.sinograin.util.SamplingUtil;
import com.toughguy.sinograin.util.UploadUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=SinograinApplication.class)
public class SampleServiceTest {

	@Autowired
	private ISampleService sampleService;
	@Test
	public void testFind() {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("page",1);
		map.put("rows", 5);
		PagerModel<Sample> l = sampleService.findPaginatedMobile(map);
		System.out.println(l.getData());
	}
	@Test
	public void testF() {
		String sampleNum = "2018020945";
		// 生成二维码
		String path = UploadUtil.getAbsolutePath("barcode");
		File f = new File(path); // 无路径则创建
		if (!f.exists()) {
			f.mkdirs();
		}
		String barFileName = BarCodeUtil.rename("png");
		BarCodeUtil.generateFile(sampleNum, path + "/" + barFileName);
	}

}
