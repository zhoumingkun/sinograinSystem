package com.toughguy.sinograin.service.authority.impl;

import static org.mockito.Mockito.reset;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toughguy.sinograin.dto.TreeDTO;
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
	public List<TreeDTO> findResourceTree() {
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
	private List<TreeDTO> listToTree(List<Resource> roles){
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
		return tree(resourceTrees);
	}
	
	public List<TreeDTO> tree(List<Resource> roles) {
		 List<TreeDTO> treeList = new ArrayList<>();
		for(Resource r:roles) {
			TreeDTO tree1 = new TreeDTO();
			tree1.setName(r.getResourceName());
			tree1.setId(r.getId());
			treeList.add(tree1);
			if(r.getList().size() != 0) {
				List<TreeDTO> treeList2 = new ArrayList<>();
				for(Resource r1:r.getList()) {
					TreeDTO tree2 = new TreeDTO();
					tree2.setName(r1.getResourceName());
					tree2.setId(r1.getId());
					treeList2.add(tree2);
					tree1.setChildren(treeList2);
					if(r1.getList().size() != 0) {
						tree(r1.getList());
					} else if(r1.getOperationList().size() != 0){
						List<TreeDTO> treeList3 = new ArrayList<>();
						for(Operation o:r1.getOperationList()) {
							if(r1.getId() == o.getResourceId()) {
								TreeDTO tree3 = new TreeDTO();
								tree3.setName(o.getDisplayName());
								tree3.setId(o.getId());
								treeList3.add(tree3);
								tree2.setChildren(treeList3);
							}
						}
					}
				}
			} else if(r.getOperationList().size() != 0) {
				List<TreeDTO> treeList3 = new ArrayList<>();
				for(Operation o:r.getOperationList()) {
					if(r.getId() == o.getResourceId()) {
						TreeDTO tree3 = new TreeDTO();
						tree3.setName(o.getDisplayName());
						tree3.setId(o.getId());
						treeList3.add(tree3);
						tree1.setChildren(treeList3);
					}
				}
			}

		}
		return treeList;
	}
		
}
