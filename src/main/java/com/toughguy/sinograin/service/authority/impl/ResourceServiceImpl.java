package com.toughguy.sinograin.service.authority.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toughguy.sinograin.model.authority.Operation;
import com.toughguy.sinograin.model.authority.Resource;
import com.toughguy.sinograin.persist.authority.prototype.IOperationDao;
import com.toughguy.sinograin.persist.authority.prototype.IResourceDao;
import com.toughguy.sinograin.service.authority.prototype.IResourceService;
import com.toughguy.sinograin.service.impl.GenericServiceImpl;

@Service
public class ResourceServiceImpl extends GenericServiceImpl<Resource, Integer> implements IResourceService {
	
	@Autowired
	IOperationDao operationDao;
	
	@Override
	public List<Integer> findROsByResourceId(int resourceId) {
		
		return ((IResourceDao)dao).findROsByResourceId(resourceId);
	}
	
	
	
	@Override
	public List<Resource> findResourceTree() {
		List<Resource> resource= findAll(); //查出所有资源
    	for (Resource res : resource) {
    		List<Operation> Operation = operationDao.findById(res.getId());
    		for (Operation ope : Operation) {
    			res.getOperationList().add(ope);
    		}
		}
		return listToTree(resource);	//转化为树形结构
	}
	//将集合转化为树形结构
	private List<Resource> listToTree(List<Resource> roles){
		List<Resource> resourceTrees = new ArrayList<Resource>();
			//System.out.println(JsonUtil.objectToJson(roles));
		for (Resource res : roles) {
            if(res.getResourcePId() == -1 || res.getResourcePId() == 0){
            	resourceTrees.add(res);
            	}
	        for (Resource r : roles) {
	            if(r.getResourcePId() == res.getId()){
	                	res.getList().add(r);
	            }
	         }
       }
		return resourceTrees;
	}
		
}
