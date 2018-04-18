package com.toughguy.sinograin.service.authority.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toughguy.sinograin.dto.TreeDTO;
import com.toughguy.sinograin.model.authority.Operation;
import com.toughguy.sinograin.model.authority.Resource;
import com.toughguy.sinograin.model.authority.Role;
import com.toughguy.sinograin.persist.authority.prototype.IOperationDao;
import com.toughguy.sinograin.persist.authority.prototype.IResourceDao;
import com.toughguy.sinograin.persist.authority.prototype.IRoleDao;
import com.toughguy.sinograin.service.authority.prototype.IResourceService;
import com.toughguy.sinograin.service.impl.GenericServiceImpl;

@Service
public class ResourceServiceImpl extends GenericServiceImpl<Resource, Integer> implements IResourceService {

	@Autowired
	IOperationDao operationDao;
	@Autowired
	IRoleDao roleDao;

	@Override
	public List<Integer> findROsByResourceId(int resourceId) {

		return ((IResourceDao) dao).findROsByResourceId(resourceId);
	}

	@Override
	public List<TreeDTO> findResourceTree(int roleId) {
		List<Resource> resource = findAll(); // 查出所有资源
		for (Resource res : resource) {
			List<Operation> Operation = operationDao.findById(res.getId());
			for (Operation ope : Operation) {
				res.getOperationList().add(ope);
			}
		}
		return listToTree(resource, roleId); // 转化为树形结构
	}

	// 将集合转化为树形结构
	private List<TreeDTO> listToTree(List<Resource> roles, int roleId) {
		List<Resource> resourceTrees = new ArrayList<Resource>();
		// System.out.println(JsonUtil.objectToJson(roles));
		for (Resource res : roles) {
			if (res.getResourcePId() == -1 || res.getResourcePId() == 0) {
				resourceTrees.add(res);
			}
			for (Resource r : roles) {
				if (r.getResourcePId() == res.getId()) {
					res.getList().add(r);
				}
			}
		}
		return tree(resourceTrees, roleId);
	}

	public List<TreeDTO> tree(List<Resource> roles, int roleId) {
		List<TreeDTO> treeList = new ArrayList<>();
		List<Operation> list = operationDao.findByRoleId(roleId); // 得到该角色所拥有的操作集合
		Role role = roleDao.find(roleId);
		List<Operation> operList = operationDao.findByRoleId(role.getRoleRelyId()); // 得到依赖角色的所有操作
		for (Resource r : roles) {
			if (list.size() > 0) {
				if (operList.size() > 0) { // 有角色依赖 本身也有权限
					TreeDTO tree1 = new TreeDTO();
					tree1.setName(r.getResourceName());
					tree1.setId(r.getId());
					tree1.setType(-1);
					tree1.setIndex(r.getGuid());
					// List<Resource> rList =((IResourceDao)
					// dao).findById(r.getId()); //查询出资源所拥有的下属资源
					// for (int j = 0; j < list.size(); j++) {
					// for (Resource resource : rList) {
					// if (resource.getId() == list.get(j).getResourceId()) {
					// tree1.setChecked("true");
					// break; //如果该角色有此操作的资源 跳出循环
					// } else {
					// tree1.setChecked("false");
					// }
					// }
					// }
					treeList.add(tree1);
					if (r.getList().size() != 0) {
						List<TreeDTO> treeList2 = new ArrayList<>();
						for (Resource r1 : r.getList()) {
							TreeDTO tree2 = new TreeDTO();
							tree2.setName(r1.getResourceName());
							tree2.setId(r1.getId());
							tree2.setType(-1);
							tree2.setIndex(r1.getGuid());
							// for (int j = 0; j < list.size(); j++) {
							// System.out.println(r1.getId()+"-------"+list.get(j).getResourceId());
							// if (r1.getId() == list.get(j).getResourceId()) {
							// tree2.setChecked("true");
							// break;
							// } else {
							// tree2.setChecked("false");
							// }
							// }
							treeList2.add(tree2);
							tree1.setChildren(treeList2);
							if (r1.getList().size() != 0) {
								tree(r1.getList(), roleId);
							} else if (r1.getOperationList().size() != 0) {
								List<TreeDTO> treeList3 = new ArrayList<>();
								for (Operation o : r1.getOperationList()) {
									if (r1.getId() == o.getResourceId()) {
										TreeDTO tree3 = new TreeDTO();
										tree3.setName(o.getDisplayName());
										tree3.setId(o.getId());
										tree3.setType(1);
										tree3.setIndex(o.getGuid());
										for (int i = 0; i < operList.size(); i++) {
											if (o.getId() == operList.get(i).getId()) {
												tree3.setDisabled(true);
												break;
											} else {
												tree3.setDisabled(false);
											}
										}
										for (int j = 0; j < list.size(); j++) {
											if (o.getId() == list.get(j).getId()) {
												tree3.setChecked(true);
												break;
											} else {
												tree3.setChecked(false);
											}
										}
										treeList3.add(tree3);
										tree2.setChildren(treeList3);
									}
								}
							}
						}
					} else if (r.getOperationList().size() != 0) {
						List<TreeDTO> treeList3 = new ArrayList<>();
						for (Operation o : r.getOperationList()) {
							if (r.getId() == o.getResourceId()) {
								TreeDTO tree3 = new TreeDTO();
								tree3.setName(o.getDisplayName());
								tree3.setId(o.getId());
								tree3.setType(1);
								tree3.setIndex(o.getGuid());
								for (int i = 0; i < operList.size(); i++) {
									if (o.getId() == operList.get(i).getId()) {
										tree3.setDisabled(true);
										break;
									} else {
										tree3.setDisabled(false);
									}
								}
								for (int j = 0; j < list.size(); j++) {
									if (o.getId() == list.get(j).getId()) {
										tree3.setChecked(true);
										break;
									} else {
										tree3.setChecked(false);
									}
								}
								treeList3.add(tree3);
								tree1.setChildren(treeList3);
							}
						}
					}
				} else {
					TreeDTO tree1 = new TreeDTO();
					tree1.setName(r.getResourceName());
					tree1.setId(r.getId());
					tree1.setType(-1);
					tree1.setIndex(r.getGuid());
					// List<Resource> rList =((IResourceDao)
					// dao).findById(r.getId()); //查询出资源所拥有的下属资源
					// for (int j = 0; j < list.size(); j++) {
					// for (Resource resource : rList) {
					// if (resource.getId() == list.get(j).getResourceId()) {
					// tree1.setChecked("true");
					// break; //如果该角色有此操作的资源 跳出循环
					// } else {
					// tree1.setChecked("false");
					// }
					// }
					// }
					treeList.add(tree1);
					if (r.getList().size() != 0) {
						List<TreeDTO> treeList2 = new ArrayList<>();
						for (Resource r1 : r.getList()) {
							TreeDTO tree2 = new TreeDTO();
							tree2.setName(r1.getResourceName());
							tree2.setId(r1.getId());
							tree2.setType(-1);
							tree2.setIndex(r1.getGuid());
							// for (int j = 0; j < list.size(); j++) {
							// System.out.println(r1.getId()+"-------"+list.get(j).getResourceId());
							// if (r1.getId() == list.get(j).getResourceId()) {
							// tree2.setChecked("true");
							// break;
							// } else {
							// tree2.setChecked("false");
							// }
							// }
							treeList2.add(tree2);
							tree1.setChildren(treeList2);
							if (r1.getList().size() != 0) {
								tree(r1.getList(), roleId);
							} else if (r1.getOperationList().size() != 0) {
								List<TreeDTO> treeList3 = new ArrayList<>();
								for (Operation o : r1.getOperationList()) {
									if (r1.getId() == o.getResourceId()) {
										TreeDTO tree3 = new TreeDTO();
										tree3.setName(o.getDisplayName());
										tree3.setId(o.getId());
										tree3.setType(1);
										tree3.setIndex(o.getGuid());
										tree3.setDisabled(false);
										for (int j = 0; j < list.size(); j++) {
											if (o.getId() == list.get(j).getId()) {
												tree3.setChecked(true);
												break;
											} else {
												tree3.setChecked(false);
											}
										}
										treeList3.add(tree3);
										tree2.setChildren(treeList3);
									}
								}
							}
						}
					} else if (r.getOperationList().size() != 0) {
						List<TreeDTO> treeList3 = new ArrayList<>();
						for (Operation o : r.getOperationList()) {
							if (r.getId() == o.getResourceId()) {
								TreeDTO tree3 = new TreeDTO();
								tree3.setName(o.getDisplayName());
								tree3.setId(o.getId());
								tree3.setType(1);
								tree3.setIndex(o.getGuid());
								tree3.setDisabled(false);
								for (int j = 0; j < list.size(); j++) {
									if (o.getId() == list.get(j).getId()) {
										tree3.setChecked(true);
										break;
									} else {
										tree3.setChecked(false);
									}
								}
								treeList3.add(tree3);
								tree1.setChildren(treeList3);
							}
						}
					}
				}
			} else { // 该角色还未拥有资源与操作
				if (operList.size() > 0) { // 有角色依赖 本身没有权限
					TreeDTO tree1 = new TreeDTO();
					tree1.setName(r.getResourceName());
					tree1.setId(r.getId());
					tree1.setType(-1);
					tree1.setIndex(r.getGuid());
					treeList.add(tree1);
					if (r.getList().size() != 0) {
						List<TreeDTO> treeList2 = new ArrayList<>();
						for (Resource r1 : r.getList()) {
							TreeDTO tree2 = new TreeDTO();
							tree2.setName(r1.getResourceName());
							tree2.setId(r1.getId());
							tree2.setType(-1);
							tree2.setIndex(r1.getGuid());
							treeList2.add(tree2);
							tree1.setChildren(treeList2);
							if (r1.getList().size() != 0) {
								tree(r1.getList(), roleId);
							} else if (r1.getOperationList().size() != 0) {
								List<TreeDTO> treeList3 = new ArrayList<>();
								for (Operation o : r1.getOperationList()) {
									if (r1.getId() == o.getResourceId()) {
										TreeDTO tree3 = new TreeDTO();
										tree3.setName(o.getDisplayName());
										tree3.setId(o.getId());
										tree3.setType(1);
										tree3.setIndex(o.getGuid());
										for (int i = 0; i < operList.size(); i++) {
											if (o.getId() == operList.get(i).getId()) {
												tree3.setDisabled(true);
												break;
											} else {
												tree3.setDisabled(false);
											}
										}
										treeList3.add(tree3);
										tree2.setChildren(treeList3);
									}
								}
							}
						}
					} else if (r.getOperationList().size() != 0) {
						List<TreeDTO> treeList3 = new ArrayList<>();
						for (Operation o : r.getOperationList()) {
							if (r.getId() == o.getResourceId()) {
								TreeDTO tree3 = new TreeDTO();
								tree3.setName(o.getDisplayName());
								tree3.setId(o.getId());
								tree3.setType(1);
								tree3.setIndex(o.getGuid());
								for (int i = 0; i < operList.size(); i++) {
									if (o.getId() == operList.get(i).getId()) {
										tree3.setDisabled(true);
										break;
									} else {
										tree3.setDisabled(false);
									}
								}
								treeList3.add(tree3);
								tree1.setChildren(treeList3);
							}
						}
					}
				} else {
					TreeDTO tree1 = new TreeDTO();
					tree1.setName(r.getResourceName());
					tree1.setId(r.getId());
					tree1.setType(-1);
					tree1.setIndex(r.getGuid());
					treeList.add(tree1);
					if (r.getList().size() != 0) {
						List<TreeDTO> treeList2 = new ArrayList<>();
						for (Resource r1 : r.getList()) {
							TreeDTO tree2 = new TreeDTO();
							tree2.setName(r1.getResourceName());
							tree2.setId(r1.getId());
							tree2.setType(-1);
							tree2.setIndex(r1.getGuid());
							treeList2.add(tree2);
							tree1.setChildren(treeList2);
							if (r1.getList().size() != 0) {
								tree(r1.getList(), roleId);
							} else if (r1.getOperationList().size() != 0) {
								List<TreeDTO> treeList3 = new ArrayList<>();
								for (Operation o : r1.getOperationList()) {
									if (r1.getId() == o.getResourceId()) {
										TreeDTO tree3 = new TreeDTO();
										tree3.setName(o.getDisplayName());
										tree3.setId(o.getId());
										tree3.setType(1);
										tree3.setIndex(o.getGuid());
										treeList3.add(tree3);
										tree2.setChildren(treeList3);
									}
								}
							}
						}
					} else if (r.getOperationList().size() != 0) {
						List<TreeDTO> treeList3 = new ArrayList<>();
						for (Operation o : r.getOperationList()) {
							if (r.getId() == o.getResourceId()) {
								TreeDTO tree3 = new TreeDTO();
								tree3.setName(o.getDisplayName());
								tree3.setId(o.getId());
								tree3.setType(1);
								tree3.setIndex(o.getGuid());
								treeList3.add(tree3);
								tree1.setChildren(treeList3);
							}
						}
					}
				}
			}
		}
		return treeList;
	}

}
